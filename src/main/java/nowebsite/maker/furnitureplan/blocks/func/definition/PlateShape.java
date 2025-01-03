package nowebsite.maker.furnitureplan.blocks.func.definition;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.blocks.tableware.FoodPlateBlock;
import nowebsite.maker.furnitureplan.utils.ModelSR;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum PlateShape implements ModelSR {
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
    public static final VoxelShape
     PLATE_BASE,CUTLERY_N,CUTLERY_E,CUTLERY_S,CUTLERY_W,GLASS_N,GLASS_E,GLASS_S,GLASS_W;

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

        CUTLERY_N = Shapes.or(Shapes.box(0.9375, 0, 0.4375, 0.9625, 0.00625, 0.5625),
                Shapes.box(0.925, 0, 0.1875, 0.9625, 0.0125, 0.4375),
                Shapes.box(0.8375, 0, 0.1875, 0.875, 0.0125, 0.45),
                Shapes.box(0.8375, 0, 0.475, 0.84375, 0.00625, 0.5375),
                Shapes.box(0.853125, 0, 0.475, 0.859375, 0.00625, 0.5375),
                Shapes.box(0.86875, 0, 0.475, 0.875, 0.00625, 0.5375),
                Shapes.box(0.8375, 0, 0.45, 0.875, 0.00625, 0.475),
                Shapes.box(0.0625, 0, 0.1875, 0.1, 0.0125, 0.45),
                Shapes.box(0.05, 0, 0.45, 0.1125, 0.00625, 0.5125)
        );

        CUTLERY_E = Shapes.or(Shapes.box(0.4375, 0, 0.9375, 0.5625, 0.00625, 0.9625),
                Shapes.box(0.5625, 0, 0.925, 0.8125, 0.0125, 0.9625),
                Shapes.box(0.55, 0, 0.8375, 0.8125, 0.0125, 0.875),
                Shapes.box(0.4625, 0, 0.8375, 0.525, 0.00625, 0.84375),
                Shapes.box(0.4625, 0, 0.853125, 0.525, 0.00625, 0.859375),
                Shapes.box(0.4625, 0, 0.86875, 0.525, 0.00625, 0.875),
                Shapes.box(0.525, 0, 0.8375, 0.55, 0.00625, 0.875),
                Shapes.box(0.55, 0, 0.0625, 0.8125, 0.0125, 0.1),
                Shapes.box(0.4875, 0, 0.05, 0.55, 0.00625, 0.1125)
        );

        CUTLERY_S = Shapes.or(Shapes.box(0.0375, 0, 0.4375, 0.0625, 0.00625, 0.5625),
                Shapes.box(0.0375, 0, 0.5625, 0.075, 0.0125, 0.8125),
                Shapes.box(0.125, 0, 0.55, 0.1625, 0.0125, 0.8125),
                Shapes.box(0.15625, 0, 0.4625, 0.1625, 0.00625, 0.525),
                Shapes.box(0.140625, 0, 0.4625, 0.146875, 0.00625, 0.525),
                Shapes.box(0.125, 0, 0.4625, 0.13125, 0.00625, 0.525),
                Shapes.box(0.125, 0, 0.525, 0.1625, 0.00625, 0.55),
                Shapes.box(0.9, 0, 0.55, 0.9375, 0.0125, 0.8125),
                Shapes.box(0.8875, 0, 0.4875, 0.95, 0.00625, 0.55)
        );

        CUTLERY_W = Shapes.or(Shapes.box(0.4375, 0, 0.0375, 0.5625, 0.00625, 0.0625),
                Shapes.box(0.1875, 0, 0.0375, 0.4375, 0.0125, 0.075),
                Shapes.box(0.1875, 0, 0.125, 0.45, 0.0125, 0.1625),
                Shapes.box(0.475, 0, 0.15625, 0.5375, 0.00625, 0.1625),
                Shapes.box(0.475, 0, 0.140625, 0.5375, 0.00625, 0.146875),
                Shapes.box(0.475, 0, 0.125, 0.5375, 0.00625, 0.13125),
                Shapes.box(0.45, 0, 0.125, 0.475, 0.00625, 0.1625),
                Shapes.box(0.1875, 0, 0.9, 0.45, 0.0125, 0.9375),
                Shapes.box(0.45, 0, 0.8875, 0.5125, 0.00625, 0.95)
        );

        GLASS_N = Shapes.or(Shapes.box(
                0.9375, 0, 0.75, 0.96875, 0.375, 0.9375)
                ,Shapes.box(0.78125, 0, 0.71875, 0.96875, 0.375, 0.75)
                ,Shapes.box(0.75, 0, 0.90625, 0.9375, 0.375, 0.9375)
                ,Shapes.box(0.75, 0, 0.71875, 0.78125, 0.375, 0.90625)
                ,Shapes.box(0.78125, 0, 0.75, 0.9375, 0.0001, 0.90625)
        );

        GLASS_E = Shapes.or(Shapes.box(0.0625, 0, 0.9375, 0.25, 0.375, 0.96875),
                Shapes.box(0.25, 0, 0.78125, 0.28125, 0.375, 0.96875),
                Shapes.box(0.0625, 0, 0.75, 0.09375, 0.375, 0.9375),
                Shapes.box(0.09375, 0, 0.75, 0.28125, 0.375, 0.78125),
                Shapes.box(0.09375, 0, 0.78125, 0.25, 0.0001, 0.9375)
        );

        GLASS_S = Shapes.or(Shapes.box(0.03125, 0, 0.0625, 0.0625, 0.375, 0.25),
                Shapes.box(0.03125, 0, 0.25, 0.21875, 0.375, 0.28125),
                Shapes.box(0.0625, 0, 0.0625, 0.25, 0.375, 0.09375),
                Shapes.box(0.21875, 0, 0.09375, 0.25, 0.375, 0.28125),
                Shapes.box(0.0625, 0, 0.09375, 0.21875, 0.0001, 0.25)
        );

        GLASS_W = Shapes.or(Shapes.box(0.75, 0, 0.03125, 0.9375, 0.375, 0.0625),
                Shapes.box(0.71875, 0, 0.03125, 0.75, 0.375, 0.21875),
                Shapes.box(0.90625, 0, 0.0625, 0.9375, 0.375, 0.25),
                Shapes.box(0.71875, 0, 0.21875, 0.90625, 0.375, 0.25),
                Shapes.box(0.75, 0, 0.0625, 0.90625, 0.0001, 0.21875)
        );
    }
    public static final VoxelShape
            PAC_N = Shapes.or(PLATE_BASE,CUTLERY_N),
            PAC_E = Shapes.or(PLATE_BASE,CUTLERY_E),
            PAC_S = Shapes.or(PLATE_BASE,CUTLERY_S),
            PAC_W = Shapes.or(PLATE_BASE,CUTLERY_W),
            PAG_N = Shapes.or(PLATE_BASE,GLASS_N),
            PAG_E = Shapes.or(PLATE_BASE,GLASS_E),
            PAG_S = Shapes.or(PLATE_BASE,GLASS_S),
            PAG_W = Shapes.or(PLATE_BASE,GLASS_W),
            PAGAC_N = Shapes.or(PLATE_BASE,GLASS_N,CUTLERY_N),
            PAGAC_E = Shapes.or(PLATE_BASE,GLASS_E,CUTLERY_E),
            PAGAC_S = Shapes.or(PLATE_BASE,GLASS_S,CUTLERY_S),
            PAGAC_W = Shapes.or(PLATE_BASE,GLASS_W,CUTLERY_W);
    @Override
    public @Nullable VoxelShape getOccModel(@NotNull BlockState state, BlockGetter getter, BlockPos pos) {
        return switch (this){
            case PLATE_SHAPE -> PLATE_BASE;
            case PLATE_AND_GLASS_SHAPE ->
                    switch (state.getValue(FoodPlateBlock.FACING))
                    {
                        case DOWN, UP -> null;
                        case NORTH -> PAG_N;
                        case EAST -> PAG_E;
                        case SOUTH -> PAG_S;
                        case WEST -> PAG_W;
                    };
            case PLATE_AND_CUTLERY_SHAPE ->
                    switch (state.getValue(FoodPlateBlock.FACING))
                    {
                        case DOWN, UP -> null;
                        case NORTH -> PAC_N;
                        case EAST -> PAC_E;
                        case SOUTH -> PAC_S;
                        case WEST -> PAC_W;
                    };
            case PLATE_AND_GLASS_AND_CUTLERY_SHAPE ->
                    switch (state.getValue(FoodPlateBlock.FACING))
                    {
                        case DOWN, UP -> null;
                        case NORTH -> PAGAC_N;
                        case EAST -> PAGAC_E;
                        case SOUTH -> PAGAC_S;
                        case WEST -> PAGAC_W;
                    };
        };
    }

    @Override
    public ResourceLocation getModel(Block block) {
        return switch (this){
            case PLATE_SHAPE -> modLoc("plate");
            case PLATE_AND_GLASS_SHAPE -> modLoc("plate_and_glass");
            case PLATE_AND_CUTLERY_SHAPE -> modLoc("plate_and_cutlery");
            case PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> modLoc("plate_and_glass_and_cutlery");
        };
    }

    @Override
    public ResourceLocation getTexture() {
        // We write like this for the current break particle color.
        return switch (this){
            case PLATE_SHAPE, PLATE_AND_CUTLERY_SHAPE, PLATE_AND_GLASS_AND_CUTLERY_SHAPE -> modLoc("block/plate");
            case PLATE_AND_GLASS_SHAPE -> modLoc("block/glass");
        };
    }
}
