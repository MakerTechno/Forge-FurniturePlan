package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.surfacing.WallShelfBlock;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.NotNull;

public enum WallShelfShape implements ICustomModelInfo {
    SINGLE("single"),
    BI("bi");

    private final String name;
    WallShelfShape(String name) {
        this.name = name;
    }
    @Override
    public Identifier getModel(Block block) {
        return blockTemplateLoc("wall_shelf_" + name);
    }

    private static final IVoxelHolder SINGLE_OCC = VoxelShapeBuilder.ofYRot()
        .or(0, 0.25, 0.375, 1, 0.3125, 1)
        .build();
    private static final IVoxelHolder BI_OCC = VoxelShapeBuilder.ofYRot()
        .or(0, 0, 0.375, 1, 0.0625, 1)
        .or(0, 0.5, 0.375, 1, 0.5625, 1)
        .build();

    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        return switch (this) {
            case SINGLE -> SINGLE_OCC.getShape(state.getValue(WallShelfBlock.FACING));
            case BI -> BI_OCC.getShape(state.getValue(WallShelfBlock.FACING));
        };
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
