package nowebsite.maker.furnitureplan.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredHolder;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.init.FPItemReg;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import nowebsite.maker.furnitureplan.networks.GraverSyncData;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class GraverItem extends Item {
    public static final List<FPBlockType<?>> VALUES = FPBlockType.registry().values().stream()
        .filter(GraverItem::isAvailableType)
        .toList();


    public static boolean isAvailableType(FPBlockType<?> type) {
        return type != FPBlockType.MOON_SHELF && type != FPBlockType.POT_HOLDER && type != FPBlockType.WALL_SHELF;
    }

    public FPBlockType<?> targetType = FPBlockType.CHAIR;
    public GraverItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
        if (!(livingEntity instanceof Player player)) {
            livingEntity.releaseUsingItem();
            return;
        }

        HitResult hitresult = this.calculateHitResult(player);

        if (!(hitresult instanceof BlockHitResult blockHitResult)) return;

        if (remainingUseDuration > 4) {
            if (hitresult.getType() != HitResult.Type.BLOCK) return;

            int usingTick = this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1;
            boolean isEveryFiveTick = usingTick % 10 == 5;
            if (!isEveryFiveTick) return;

            BlockPos blockpos = blockHitResult.getBlockPos();
            BlockState blockstate = level.getBlockState(blockpos);
            HumanoidArm humanoidarm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND
                ? player.getMainArm()
                : player.getMainArm().getOpposite();

            if (blockstate.shouldSpawnTerrainParticles() && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                this.spawnDustParticles(level, blockHitResult, blockstate, livingEntity.getViewVector(0.0F), humanoidarm);
            }

            level.playSound(player, blockpos, blockstate.getBlock().getSoundType(blockstate, level, blockpos, null).getBreakSound(), SoundSource.BLOCKS);
            return;
        }

        if (hitresult.getType() == HitResult.Type.BLOCK) {
            findAndReplace(player, level, player.getUsedItemHand(), blockHitResult, targetType);
            livingEntity.releaseUsingItem();
            player.getCooldowns().addCooldown(stack, 20);
        }

    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            player.startUsingItem(context.getHand());
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) return InteractionResult.CONSUME;

        if (this.calculateHitResult(player).getType() == HitResult.Type.MISS && !player.getCooldowns().isOnCooldown(player.getItemInHand(hand))) {
            int index = VALUES.indexOf(targetType);
            if (++index == VALUES.size()) index = 0;
            targetType = VALUES.get(index);
            player.getCooldowns().addCooldown(player.getItemInHand(hand), 5);
            PacketDistributor.sendToPlayer((ServerPlayer) player, new GraverSyncData(targetType.name()));
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.FAIL;
    }


    @Override
    @SuppressWarnings("deprecation")
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        if (tooltipFlag.hasShiftDown()) {
            builder.accept(Component.translatable("tip.furnitureplan.graver").withStyle(ChatFormatting.YELLOW));
            builder.accept(Component.translatable("tip.furnitureplan.click"));
            builder.accept(
                Component.translatable("tip.furnitureplan.graver.kind")
                    .append(Component.translatable("tip.furnitureplan.graver.kind." + targetType.name()))
                    .withStyle(ChatFormatting.GREEN)
            );
        } else builder.accept(Component.translatable("tip.furnitureplan.shiftdown").withStyle(ChatFormatting.AQUA));
    }


    private void findAndReplace(Player player, Level level, InteractionHand hand, BlockHitResult result, FPBlockType<?> kind) {
        Block carving = level.getBlockState(result.getBlockPos()).getBlock();
        Block target = kind.getAll().stream().map(DeferredHolder::get)
            .filter(block -> ((BlockSetGetter)block).getType().getBase().defaultBlockState().is(carving))
            .filter(block -> !(block instanceof CabinetBlock cabinetBlock) || cabinetBlock.getFrameType() == null)
            .findFirst()
            .orElse(null);
        if (target == null) return;

        BlockState state = target.getStateForPlacement(new BlockPlaceContext(level, player, hand, target.asItem().getDefaultInstance(), result));
        if (state != null) {
            level.setBlockAndUpdate(result.getBlockPos(), state);
            if (state.tags().anyMatch(tag -> tag.equals(FPTags.DROP_SAWDUST))) {
                Block.popResource(level, result.getBlockPos(), new ItemStack(FPItemReg.SAWDUST.get(), level.getRandom().nextInt(3) + 1));
            }
            if (state.tags().anyMatch(tag -> tag.equals(FPTags.DROP_DETRITUS))) {
                Block.popResource(level, result.getBlockPos(), new ItemStack(FPItemReg.DETRITUS.get(), level.getRandom().nextInt(3) + 1));
            }
        }
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.BRUSH;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 100;
    }

    private HitResult calculateHitResult(Player player) {
        return ProjectileUtil.getHitResultOnViewVector(
            player, entity -> !entity.isSpectator() && entity.isPickable(), player.blockInteractionRange()
        );
    }

    /*From BrushItem*/
    private void spawnDustParticles(Level level, BlockHitResult hitResult, BlockState state, Vec3 pos, HumanoidArm arm) {
        int i = arm == HumanoidArm.RIGHT ? 1 : -1;
        int j = level.getRandom().nextInt(7, 12);
        BlockParticleOption blockparticleoption = new BlockParticleOption(ParticleTypes.BLOCK, state);
        Direction direction = hitResult.getDirection();
        DustParticlesDelta brushitem$dustparticlesdelta = DustParticlesDelta.fromDirection(pos, direction);
        Vec3 vec3 = hitResult.getLocation();

        for (int k = 0; k < j; k++) {
            level.addParticle(
                blockparticleoption,
                vec3.x - (double)(direction == Direction.WEST ? 1.0E-6F : 0.0F),
                vec3.y,
                vec3.z - (double)(direction == Direction.NORTH ? 1.0E-6F : 0.0F),
                brushitem$dustparticlesdelta.xd() * (double)i * 3.0 * level.getRandom().nextDouble(),
                0.0,
                brushitem$dustparticlesdelta.zd() * (double)i * 3.0 * level.getRandom().nextDouble()
            );
        }
    }

    record DustParticlesDelta(double xd, double yd, double zd) {

        public static DustParticlesDelta fromDirection(Vec3 pos, @NotNull Direction direction) {

            return switch (direction) {
                case DOWN, UP -> new DustParticlesDelta(pos.z(), 0.0, -pos.x());
                case NORTH -> new DustParticlesDelta(1.0, 0.0, -0.1);
                case SOUTH -> new DustParticlesDelta(-1.0, 0.0, 0.1);
                case WEST -> new DustParticlesDelta(-0.1, 0.0, -1.0);
                case EAST -> new DustParticlesDelta(0.1, 0.0, 1.0);
            };
        }
    }
}
