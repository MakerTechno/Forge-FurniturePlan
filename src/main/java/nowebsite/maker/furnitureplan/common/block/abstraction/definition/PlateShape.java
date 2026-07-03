package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.common.block.cooking.utensils.FoodPlateBlock;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import nowebsite.maker.furnitureplan.utils.voxel.IVoxelHolder;
import nowebsite.maker.furnitureplan.utils.voxel.VoxelShapeBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum PlateShape implements ICustomModelInfo {
    PLATE_SHAPE("plt"),
    PLATE_AND_GLASS_SHAPE("pag"),
    PLATE_AND_CUTLERY_SHAPE("pac"),
    PLATE_AND_GLASS_AND_CUTLERY_SHAPE("pagac");

    private final String name;
    PlateShape(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        return this.name;
    }
    public boolean hasGlass(){
        return switch (this){
            case PLATE_SHAPE, PLATE_AND_CUTLERY_SHAPE -> false;
            case PLATE_AND_GLASS_SHAPE, PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> true;
        };
    }
    public boolean hasCutlery(){
        return switch (this){
            case PLATE_SHAPE, PLATE_AND_GLASS_SHAPE ->false;
            case PLATE_AND_CUTLERY_SHAPE, PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> true;
        };
    }
    public PlateShape addCutlery(){
        if (this == PLATE_SHAPE) return PLATE_AND_CUTLERY_SHAPE;
        else if (this == PLATE_AND_GLASS_SHAPE) return PLATE_AND_GLASS_AND_CUTLERY_SHAPE;
        return this;
    }
    public PlateShape addGlass(){
        if (this == PLATE_SHAPE) return PLATE_AND_GLASS_SHAPE;
        else if (this == PLATE_AND_CUTLERY_SHAPE) return PLATE_AND_GLASS_AND_CUTLERY_SHAPE;
        return this;
    }
    @Nullable
    public PlateShape getNext(){
        return switch (this){
            case PLATE_SHAPE -> null;
            case PLATE_AND_GLASS_SHAPE, PLATE_AND_CUTLERY_SHAPE -> PLATE_SHAPE;
            case PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> PLATE_AND_GLASS_SHAPE;
        };
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
    public static final VoxelShape PLATE_BASE;
    public static final IVoxelHolder CUTLERY, GLASS;

    static {
        PLATE_BASE = Shapes.or(Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.03125, 0.6875),
                Shapes.box(0.375, 0, 0.6875, 0.625, 0.03125, 0.75),
                Shapes.box(0.6875, 0.03125, 0.625, 0.75, 0.0625, 0.6875),
                Shapes.box(0.6875, 0.03125, 0.3125, 0.75, 0.0625, 0.375),
                Shapes.box(0.25, 0, 0.375, 0.3125, 0.03125, 0.625),
                Shapes.box(0.6875, 0, 0.375, 0.75, 0.03125, 0.625),
                Shapes.box(0.75, 0.03125, 0.375, 0.8125, 0.0625, 0.625),
                Shapes.box(0.1875, 0.03125, 0.375, 0.25, 0.0625, 0.625),
                Shapes.box(0.25, 0.03125, 0.3125, 0.3125, 0.0625, 0.375),
                Shapes.box(0.3125, 0.03125, 0.6875, 0.375, 0.0625, 0.75),
                Shapes.box(0.25, 0.03125, 0.625, 0.3125, 0.0625, 0.6875),
                Shapes.box(0.625, 0.03125, 0.25, 0.6875, 0.0625, 0.3125),
                Shapes.box(0.3125, 0.03125, 0.25, 0.375, 0.0625, 0.3125),
                Shapes.box(0.625, 0.03125, 0.6875, 0.6875, 0.0625, 0.75),
                Shapes.box(0.375, 0, 0.25, 0.625, 0.03125, 0.3125),
                Shapes.box(0.375, 0.03125, 0.1875, 0.625, 0.0625, 0.25),
                Shapes.box(0.375, 0.03125, 0.75, 0.625, 0.0625, 0.8125)
        );

        CUTLERY = VoxelShapeBuilder.ofYRot()
            .or(0.9375, 0, 0.4375, 0.9625, 0.00625, 0.5625)
            .or(0.925, 0, 0.1875, 0.9625, 0.0125, 0.4375)
            .or(0.8375, 0, 0.1875, 0.875, 0.0125, 0.45)
            .or(0.8375, 0, 0.475, 0.84375, 0.00625, 0.5375)
            .or(0.853125, 0, 0.475, 0.859375, 0.00625, 0.5375)
            .or(0.86875, 0, 0.475, 0.875, 0.00625, 0.5375)
            .or(0.8375, 0, 0.45, 0.875, 0.00625, 0.475)
            .or(0.0625, 0, 0.1875, 0.1, 0.0125, 0.45)
            .or(0.05, 0, 0.45, 0.1125, 0.00625, 0.5125)
            .build();
            

        GLASS = VoxelShapeBuilder.ofYRot()
            .or(0.9375, 0, 0.75, 0.96875, 0.375, 0.9375)
            .or(0.78125, 0, 0.71875, 0.96875, 0.375, 0.75)
            .or(0.75, 0, 0.90625, 0.9375, 0.375, 0.9375)
            .or(0.75, 0, 0.71875, 0.78125, 0.375, 0.90625)
            .or(0.78125, 0, 0.75, 0.9375, 0.0001, 0.90625)
            .build();
    }
    public static final VoxelShape
            PAC_N = Shapes.or(PLATE_BASE,CUTLERY.getShape(Direction.NORTH)),
            PAC_E = Shapes.or(PLATE_BASE,CUTLERY.getShape(Direction.EAST)),
            PAC_S = Shapes.or(PLATE_BASE,CUTLERY.getShape(Direction.SOUTH)),
            PAC_W = Shapes.or(PLATE_BASE,CUTLERY.getShape(Direction.WEST)),
            PAG_N = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.NORTH)),
            PAG_E = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.EAST)),
            PAG_S = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.SOUTH)),
            PAG_W = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.WEST)),
            PAGAC_N = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.NORTH),CUTLERY.getShape(Direction.NORTH)),
            PAGAC_E = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.EAST),CUTLERY.getShape(Direction.EAST)),
            PAGAC_S = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.SOUTH),CUTLERY.getShape(Direction.SOUTH)),
            PAGAC_W = Shapes.or(PLATE_BASE,GLASS.getShape(Direction.WEST),CUTLERY.getShape(Direction.WEST));

    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {

        return switch (this){
            case PLATE_SHAPE -> PLATE_BASE;
            case PLATE_AND_GLASS_SHAPE ->
                switch (state.getValue(FoodPlateBlock.FACING))
                {
                    case DOWN, UP -> Shapes.empty();
                    case NORTH -> PAG_N;
                    case EAST -> PAG_E;
                    case SOUTH -> PAG_S;
                    case WEST -> PAG_W;
                };
            case PLATE_AND_CUTLERY_SHAPE ->
                switch (state.getValue(FoodPlateBlock.FACING))
                {
                    case DOWN, UP -> Shapes.empty();
                    case NORTH -> PAC_N;
                    case EAST -> PAC_E;
                    case SOUTH -> PAC_S;
                    case WEST -> PAC_W;
                };
            case PLATE_AND_GLASS_AND_CUTLERY_SHAPE ->
                switch (state.getValue(FoodPlateBlock.FACING))
                {
                    case DOWN, UP -> Shapes.empty();
                    case NORTH -> PAGAC_N;
                    case EAST -> PAGAC_E;
                    case SOUTH -> PAGAC_S;
                    case WEST -> PAGAC_W;
                };
        };
    }


    @Override
    public Identifier getModel(Block block) {
        return switch (this){
            case PLATE_SHAPE -> blockTemplateLoc("plate");
            case PLATE_AND_GLASS_SHAPE -> blockTemplateLoc("plate_and_glass");
            case PLATE_AND_CUTLERY_SHAPE -> blockTemplateLoc("plate_and_cutlery");
            case PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> blockTemplateLoc("plate_and_glass_and_cutlery");
        };
    }
}
