package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.surfacing.MoonShelfBlock;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public enum MoonShelfPart implements ICustomModelInfo {
    CENTER("center"),
    UP("up"),
    LEFT("left"),
    RIGHT("right"),
    DOWN("down"),
    LEFT_UP("left_up"),
    LEFT_DOWN("left_down"),
    RIGHT_UP("right_up"),
    RIGHT_DOWN("right_down");

    private final String name;
    MoonShelfPart(String name) {
        this.name = name;
    }

    public static final IVoxelHolder V_CENTER, V_UP, V_LEFT, V_RIGHT, V_DOWN, V_LEFT_UP, V_RIGHT_UP, V_LEFT_DOWN, V_RIGHT_DOWN;

    static {
        V_CENTER = VoxelShapeBuilder.ofYRot()
            .or(0.9375, 0, 0.875, 1, 0.0625, 0.9375)
            .or(0.9375, 0, 0.3125, 1, 0.0625, 0.375)
            .or(0, 0, 0.875, 0.0625, 0.0625, 0.9375)
            .or(0, 0, 0.3125, 0.0625, 0.0625, 0.375)
            .or(0, 0.0625, 0.25, 0.0625, 0.125, 1)
            .or(0.9375, 0.0625, 0.25, 1, 0.125, 1)
            .or(0.46875, 0, 0.25, 0.53125, 0.4375, 1)
            .or(0, 0.4375, 0.25, 1, 0.5, 1)
            .or(0.46875, 0.5, 0.25, 0.53125, 1, 1)
            .or(0.9375, 0.875, 0.25, 1, 0.9375, 1)
            .or(0.9375, 0.9375, 0.875, 1, 1, 0.9375)
            .or(0.9375, 0.9375, 0.3125, 1, 1, 0.375)
            .or(0, 0.9375, 0.875, 0.0625, 1, 0.9375)
            .or(0, 0.875, 0.25, 0.0625, 0.9375, 1)
            .or(0, 0.9375, 0.3125, 0.0625, 1, 0.375)
            .build();
        V_DOWN = VoxelShapeBuilder.ofYRot()
            .or(0.875, 0.025, 0.25, 1, 0.0875, 1)
            .or(0.09375, 0, 0.25, 0.90625, 0.0625, 1)
            .or(0, 0.025, 0.25, 0.125, 0.0875, 1)
            .or(0, 0.0625, 0.875, 0.0625, 0.75, 0.9375)
            .or(0, 0.0625, 0.3125, 0.0625, 0.75, 0.375)
            .or(0.46875, 0.0625, 0.25, 0.53125, 1, 1)
            .or(0, 0.75, 0.25, 0.46875, 0.8125, 1)
            .or(0.53125, 0.75, 0.25, 1, 0.8125, 1)
            .or(0.9375, 0.0625, 0.3125, 1, 0.75, 0.375)
            .or(0.9375, 0.0625, 0.875, 1, 0.75, 0.9375)
            .or(0.9375, 0.8125, 0.3125, 1, 1, 0.375)
            .or(0.9375, 0.8125, 0.875, 1, 1, 0.9375)
            .or(0, 0.8125, 0.875, 0.0625, 1, 0.9375)
            .or(0, 0.8125, 0.3125, 0.0625, 1, 0.375)
            .build();
        V_LEFT_DOWN = VoxelShapeBuilder.ofYRot()
            .or(0.859375, 0.5625, 0.25, 1, 0.9375, 1)
            .or(0.421875, 0.875, 0.25, 0.859375, 0.9375, 1)
            .or(0.4375, 0.9375, 0.3125, 0.5, 1, 0.375)
            .or(0.4375, 0.9375, 0.875, 0.5, 1, 0.9375)
            .or(0, 0.5, 0.25, 0.625, 0.5625, 1)
            .or(0.625, 0.4375, 0.25, 1, 0.5625, 1)
            .or(0.5, 0.0625, 0.25, 0.625, 0.5, 1)
            .or(0, 0.0625, 0.25, 0.5, 0.1875, 1)
            .build();
        V_LEFT = VoxelShapeBuilder.ofYRot()
            .or(0, 0.875, 0.25, 0.4375, 0.9375, 1)
            .or(0, 0.5, 0.875, 0.0625, 0.875, 0.9375)
            .or(0, 0.5, 0.3125, 0.0625, 0.875, 0.375)
            .or(0, 0.4375, 0.25, 0.9375, 0.5, 1)
            .or(0.4375, 0, 0.875, 0.5, 0.4375, 0.9375)
            .or(0.4375, 0, 0.3125, 0.5, 0.4375, 0.375)
            .or(0, 0.0625, 0.25, 0.4375, 0.125, 1)
            .or(0.9375, 0.09375, 0.25, 1, 0.90625, 1)
            .or(0.90625, 0, 0.25, 0.96875, 0.125, 1)
            .or(0.90625, 0.875, 0.25, 0.96875, 1, 1)
            .build();
        V_LEFT_UP = VoxelShapeBuilder.ofYRot()
            .or(0.3125, 0.1875, 0.875, 0.375, 0.6875, 0.9375)
            .or(0.3125, 0.1875, 0.3125, 0.375, 0.6875, 0.375)
            .or(0, 0.4375, 0.25, 0.3125, 0.5, 1)
            .or(0.3125, 0.125, 0.2500625, 0.8125, 0.1875, 0.9999375)
            .or(0.796875, 0, 0.25, 0.9375, 0.375, 1)
            .or(0.5625, 0.375, 0.25, 0.9375, 0.5, 1)
            .or(0.5625, 0.5, 0.25, 0.6875, 0.6875, 1)
            .or(0, 0.6875, 0.25, 0.6875, 0.8125, 1)
            .build();
        V_RIGHT_DOWN = VoxelShapeBuilder.ofYRot()
            .or(0.140625, 0.875, 0.25, 0.578125, 0.9375, 1)
            .or(0.375, 0.5, 0.25, 1, 0.5625, 1)
            .or(0.5, 0.9375, 0.3125, 0.5625, 1, 0.375)
            .or(0.5, 0.9375, 0.875, 0.5625, 1, 0.9375)
            .or(0, 0.5625, 0.25, 0.140625, 0.9375, 1)
            .or(0, 0.4375, 0.25, 0.375, 0.5625, 1)
            .or(0.375, 0.0625, 0.25, 0.5, 0.5, 1)
            .or(0.5, 0.0625, 0.25, 1, 0.1875, 1)
            .build();
        V_RIGHT = VoxelShapeBuilder.ofYRot()
            .or(0.5625, 0.0625, 0.25, 1, 0.125, 1)
            .or(0.0625, 0.4375, 0.25, 1, 0.5, 1)
            .or(0.5, 0, 0.875, 0.5625, 0.4375, 0.9375)
            .or(0.5, 0, 0.3125, 0.5625, 0.4375, 0.375)
            .or(0.9375, 0.5, 0.875, 1, 0.875, 0.9375)
            .or(0.9375, 0.5, 0.3125, 1, 0.875, 0.375)
            .or(0.5625, 0.875, 0.25, 1, 0.9375, 1)
            .or(0, 0.09375, 0.25, 0.0625, 0.90625, 1)
            .or(0.03125, 0, 0.25, 0.09375, 0.125, 1)
            .or(0.025, 0.875, 0.25, 0.0875, 1, 1)
            .build();
        V_RIGHT_UP = VoxelShapeBuilder.ofYRot()
            .or(0.6875, 0.4375, 0.25, 1, 0.5, 1)
            .or(0.1875, 0.125, 0.25, 0.6875, 0.1875, 1)
            .or(0.625, 0.1875, 0.875, 0.6875, 0.6875, 0.9375)
            .or(0.625, 0.1875, 0.3125, 0.6875, 0.6875, 0.375)
            .or(0.3125, 0.6875, 0.25, 1, 0.8125, 1)
            .or(0.3125, 0.5, 0.25, 0.4375, 0.6875, 1)
            .or(0.0625, 0.375, 0.25, 0.4375, 0.5, 1)
            .or(0.0625, 0, 0.25, 0.1875, 0.375, 1)
            .build();
        V_UP = VoxelShapeBuilder.ofYRot()
            .or(0.09375, 0.9375, 0.25, 0.90625, 1, 1)
            .or(0.875, 0.90625, 0.25, 1, 0.96875, 1)
            .or(0, 0.90625, 0.25, 0.125, 0.96875, 1)
            .or(0.46875, 0, 0.25, 0.53125, 0.9375, 1)
            .or(0.9375, 0.4375, 0.25, 1, 0.5, 1)
            .or(0.9375, 0, 0.875, 1, 0.4375, 0.9375)
            .or(0.9375, 0, 0.3125, 1, 0.4375, 0.375)
            .or(0.53125, 0.25, 0.25, 0.9375, 0.3125, 1)
            .or(0.0625, 0.25, 0.25, 0.46875, 0.3125, 1)
            .or(0, 0, 0.875, 0.0625, 0.4375, 0.9375)
            .or(0, 0, 0.3125, 0.0625, 0.4375, 0.375)
            .or(0, 0.4375, 0.25, 0.0625, 0.5, 1)
            .build();
    }

    @Override
    public Identifier getModel(Block block) {
        return blockTemplateLoc("moon_shelf_" + this.name);
    }

    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        Direction facing = state.getValue(MoonShelfBlock.FACING);
        return switch (this) {
            case CENTER -> V_CENTER.getShape(facing);
            case UP -> V_UP.getShape(facing);
            case LEFT -> V_LEFT.getShape(facing);
            case RIGHT -> V_RIGHT.getShape(facing);
            case DOWN -> V_DOWN.getShape(facing);
            case LEFT_UP -> V_LEFT_UP.getShape(facing);
            case LEFT_DOWN -> V_LEFT_DOWN.getShape(facing);
            case RIGHT_UP -> V_RIGHT_UP.getShape(facing);
            case RIGHT_DOWN -> V_RIGHT_DOWN.getShape(facing);
        };
    }

    @Override
    public String getSerializedName() {
        return name;
    }
    
    public BlockPos toCenter(BlockPos now, Direction facing, boolean reverseRelative) {
        if (reverseRelative) facing = facing.getOpposite();
        int verticalReverse = reverseRelative ? -1 : 1;
        return switch (this){
            case CENTER -> now;
            case UP -> now.below(verticalReverse);
            case LEFT -> now.relative(facing.getCounterClockWise());
            case RIGHT -> now.relative(facing.getClockWise());
            case DOWN -> now.above(verticalReverse);
            case LEFT_UP -> now.below(verticalReverse).relative(facing.getCounterClockWise());
            case LEFT_DOWN -> now.above(verticalReverse).relative(facing.getCounterClockWise());
            case RIGHT_UP -> now.below(verticalReverse).relative(facing.getClockWise());
            case RIGHT_DOWN -> now.above(verticalReverse).relative(facing.getClockWise());
        };
    }

    public static @NotNull Map<MoonShelfPart, BlockPos> getAllExcept(Direction facing, BlockPos center, @Nullable MoonShelfPart ign) {
        Map<MoonShelfPart, BlockPos> allEx = new HashMap<>();
        for (MoonShelfPart part : MoonShelfPart.values()) {
            if (part == ign) continue;
            allEx.put(part, part.toCenter(center, facing, true));
        }
        return allEx;
    }

    public boolean isCenter() {
        return this.equals(CENTER);
    }

}
