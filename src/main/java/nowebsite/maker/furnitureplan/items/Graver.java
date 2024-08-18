package nowebsite.maker.furnitureplan.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import nowebsite.maker.furnitureplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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

        public List<RegistryObject<? extends Block>> getList(){
            return switch (this){
                case CHAIR -> FoldingRegistration.getChairBlockLists();
                case TABLE -> FoldingRegistration.getTableBlockLists();
                case COLUMN -> FoldingRegistration.getColumnBlockLists();
                case CARVED_COLUMN -> FoldingRegistration.getCarvedColumnBlockLists();
                case LIGHTED_COLUMN -> FoldingRegistration.getLightedColumnBlockLists();
            };
        }
    }

    public GraveKind kind = GraveKind.CHAIR;
    public Graver(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        InteractionResult result = findAndReplace(context, this.kind);
        if (!result.equals(InteractionResult.SUCCESS)){
            return use(context.getLevel(), Objects.requireNonNull(context.getPlayer()), context.getHand()).getResult();
        }
        return result;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (level.isClientSide && hand.equals(InteractionHand.MAIN_HAND))kind = kind.getNext();
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()){
            components.add(Component.translatable("tip.furnitureplan.graver").withStyle(ChatFormatting.YELLOW));
            components.add(Component.literal("Kind:" + kind.name()).withStyle(ChatFormatting.GREEN));
        } else {
            components.add(Component.translatable("tip.furnitureplan.shiftdown").withStyle(ChatFormatting.AQUA));
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private InteractionResult findAndReplace(@NotNull UseOnContext context, GraveKind kind){
        BlockPos pos = context.getClickedPos();
        BlockState blockState = context.getLevel().getBlockState(pos);
        int count = 0;
        for (Block block : FoldingRegistration.getPropertyBlocks()){
            if (block.equals(blockState.getBlock())) {
                context.getLevel().setBlockAndUpdate(pos, Objects.requireNonNull(
                    kind.getList().get(count).get().defaultBlockState())
                );
                if (block.defaultBlockState().getTags().anyMatch(blockTagKey -> blockTagKey.equals(BlockTags.PLANKS))){
                    Block.popResource(context.getLevel(), pos, new ItemStack(ItemRegistration.SAWDUST.get(), 2));
                } else {
                    Block.popResource(context.getLevel(), pos, new ItemStack(ItemRegistration.DETRITUS.get(), 2));
                }
                Objects.requireNonNull(context.getPlayer()).broadcastBreakEvent(EquipmentSlot.MAINHAND);
                return InteractionResult.SUCCESS;
            }
            count++;
        }
        return InteractionResult.PASS;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 20;
    }
}
