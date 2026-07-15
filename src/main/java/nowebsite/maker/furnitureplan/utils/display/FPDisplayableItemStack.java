package nowebsite.maker.furnitureplan.utils.display;

import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FPDisplayableItemStack {
    private @Nullable Direction displayFacing = null;
    private @Nullable BlockState blockStateCache = null;
    private @Nullable BlockEntity blockEntityCache = null;

    public FPDisplayableItemStack() {}

    public @Nullable Direction getDisplayFacing() {
        return displayFacing;
    }

    public void setDisplayFacing(@Nullable Direction displayFacing) {
        this.displayFacing = displayFacing;
    }

    public @Nullable BlockState getBlockStateCache() {
        return blockStateCache;
    }

    public @Nullable BlockEntity getBlockEntityCache() {
        return blockEntityCache;
    }

    public void generateCache(ItemStack stack, Level clientLevel, BlockEntity holder) {

        if (stack.isEmpty() || !(stack.getItem() instanceof BlockItem blockItem)) {
            blockStateCache = null;
            return;
        }

        BlockState state = generateBlockState(holder, blockItem);

        tryGenerateBlockEntity(stack, clientLevel, holder, state);
    }

    private @NotNull BlockState generateBlockState(BlockEntity holder, BlockItem blockItem) {
        BlockState state = blockItem.getBlock().defaultBlockState();
        Direction defaultFacing = holder.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

        if (state.getProperties().contains(BlockStateProperties.FACING)) {
            state = state.setValue(BlockStateProperties.FACING,  displayFacing == null ? defaultFacing : displayFacing);
        } else if (state.getProperties().contains(BlockStateProperties.HORIZONTAL_FACING)) {
            state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, displayFacing == null ? defaultFacing : displayFacing);
        } else if (state.getProperties().contains(BlockStateProperties.ROTATION_16)) {
            state = state.setValue(BlockStateProperties.ROTATION_16, RotationSegment.convertToSegment(displayFacing == null ? defaultFacing : displayFacing));
        }
        blockStateCache = state;
        return state;
    }

    private void tryGenerateBlockEntity(ItemStack stack, Level clientLevel, BlockEntity holder, BlockState state) {
        if (!(state.getBlock() instanceof EntityBlock entityBlock)) return;
        BlockEntity toRend = entityBlock.newBlockEntity(holder.getBlockPos(), state);
        if (toRend != null) {
            if (!toRend.getType().onlyOpCanSetNbt()) {
                TypedEntityData<BlockEntityType<?>> customData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
                if (customData != null && customData.type().equals(toRend.getType())) {
                    customData.loadInto(toRend, clientLevel.registryAccess());
                }
            }
            toRend.applyComponentsFromItemStack(stack);
        }
        blockEntityCache = toRend; // also nullable
    }

}
