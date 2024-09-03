package nowebsite.maker.furnitureplan.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
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
import nowebsite.maker.furnitureplan.networks.GraverSyncData;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Graver extends Item {
    public enum GraveKind{
        CHAIR,
        TABLE,
        COLUMN,
        CARVED_COLUMN,
        LIGHTED_COLUMN;

        public GraveKind getNext(){
            return this.equals(LIGHTED_COLUMN) ? CHAIR : GraveKind.values()[this.ordinal()+1];
        }

        public List<DeferredHolder<Block, ? extends Block>> getList(){
            return switch (this){
                case CHAIR -> FoldingRegistration.getChairBlockList();
                case TABLE -> FoldingRegistration.getTableBlockList();
                case COLUMN -> FoldingRegistration.getColumnBlockList();
                case CARVED_COLUMN -> FoldingRegistration.getCarvedColumnBlockList();
                case LIGHTED_COLUMN -> FoldingRegistration.getLightedColumnBlockList();
            };
        }
    }

    public GraveKind kind = GraveKind.CHAIR;
    public Graver(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
        if (livingEntity instanceof Player player) {
            HitResult hitresult = this.calculateHitResult(player);
            if (remainingUseDuration > 4) {
                if (hitresult instanceof BlockHitResult blockhitresult && hitresult.getType() == HitResult.Type.BLOCK) {
                    int i = this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1;
                    boolean flag = i % 10 == 5;
                    if (flag) {
                        BlockPos blockpos = blockhitresult.getBlockPos();
                        BlockState blockstate = level.getBlockState(blockpos);
                        HumanoidArm humanoidarm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND
                            ? player.getMainArm()
                            : player.getMainArm().getOpposite();
                        if (blockstate.shouldSpawnTerrainParticles() && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
                            this.spawnDustParticles(level, blockhitresult, blockstate, livingEntity.getViewVector(0.0F), humanoidarm);
                        }
                        level.playSound(player, blockpos, blockstate.getBlock().getSoundType(blockstate, level, blockpos, null).getBreakSound(), SoundSource.BLOCKS);
                    }
                    return;
                }
            }
            if (remainingUseDuration <= 4) {
                if (hitresult instanceof BlockHitResult blockhitresult && hitresult.getType() == HitResult.Type.BLOCK) {
                    findAndReplace(blockhitresult.getBlockPos(), level.getBlockState(blockhitresult.getBlockPos()), level, kind);
                    livingEntity.releaseUsingItem();
                    player.getCooldowns().addCooldown(ItemRegistration.GRAVER.get(), 20);
                }
            }
        } else {
            livingEntity.releaseUsingItem();
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
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && this.calculateHitResult(player).getType() == HitResult.Type.MISS && !player.getCooldowns().isOnCooldown(ItemRegistration.GRAVER.get())) {
            kind = kind.getNext();
            player.getCooldowns().addCooldown(ItemRegistration.GRAVER.get(), 5);
            PacketDistributor.sendToPlayer((ServerPlayer) player, new GraverSyncData((byte) kind.ordinal()));
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), false);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tip.furnitureplan.graver").withStyle(ChatFormatting.YELLOW));
            tooltipComponents.add(Component.translatable("tip.furnitureplan.click"));
            tooltipComponents.add(
                Component.translatable("tip.furnitureplan.graver.kind")
                    .append(Component.translatable("tip.furnitureplan.graver.kind." + kind.name().toLowerCase(Locale.ROOT)))
                    .withStyle(ChatFormatting.GREEN)
            );
        } else {
            tooltipComponents.add(Component.translatable("tip.furnitureplan.shiftdown").withStyle(ChatFormatting.AQUA));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    private void findAndReplace(BlockPos pos, BlockState state, Level level, GraveKind kind) {
        int count = 0;
        for (Block block : FoldingRegistration.getPropertyBlocks()){
            if (block.equals(state.getBlock())) {
                level.setBlockAndUpdate(pos, Objects.requireNonNull(
                    kind.getList().get(count).get().defaultBlockState())
                );
                if (block.defaultBlockState().getTags().anyMatch(blockTagKey -> blockTagKey.equals(BlockTags.PLANKS))){
                    Block.popResource(level, pos, new ItemStack(ItemRegistration.SAWDUST.get(), 2));
                } else {
                    Block.popResource(level, pos, new ItemStack(ItemRegistration.DETRITUS.get(), 2));
                }
                return;
            }
            count++;
        }
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BRUSH;
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
        Graver.DustParticlesDelta brushitem$dustparticlesdelta = Graver.DustParticlesDelta.fromDirection(pos, direction);
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

        public static Graver.DustParticlesDelta fromDirection(Vec3 pos, @NotNull Direction direction) {

            return switch (direction) {
                case DOWN, UP -> new Graver.DustParticlesDelta(pos.z(), 0.0, -pos.x());
                case NORTH -> new Graver.DustParticlesDelta(1.0, 0.0, -0.1);
                case SOUTH -> new Graver.DustParticlesDelta(-1.0, 0.0, 0.1);
                case WEST -> new Graver.DustParticlesDelta(-0.1, 0.0, -1.0);
                case EAST -> new Graver.DustParticlesDelta(0.1, 0.0, 1.0);
            };
        }
    }
}
