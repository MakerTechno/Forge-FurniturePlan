package nowebsite.maker.furnitureplan.common.block.abstraction.definition;

import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

public enum TableLampShape implements ICustomModelInfo {
    ON("on"), OFF("off");
    public static final VariantMutator ON_MUTATOR = VariantMutator.MODEL.withValue(FurniturePlan.asResource("block/table_lamp_on"));
    public static final VariantMutator OFF_MUTATOR = VariantMutator.MODEL.withValue(FurniturePlan.asResource("block/table_lamp_off"));

    private final String name;
    TableLampShape(String name) {
        this.name = name;
    }

    @Override
    public Identifier getModel(Block block) {
        return blockTemplateLoc("table_lamp_" + name);
    }

    @Override
    public PropertyDispatch<VariantMutator> getDispatcher() {
        return PropertyDispatch.modify(FPBlockReg.BlockStateReg.TABLE_LAMP_SHAPE)
            .select(ON, ON_MUTATOR)
            .select(OFF, OFF_MUTATOR);
    }

    private static final VoxelShape SHAPE = Shapes.or(
        Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875),
        Shapes.box(0.453125, 0.0625, 0.453125, 0.546875, 0.4375, 0.546875),
        Shapes.box(0.1875, 0.4375, 0.1875, 0.8125, 0.8125, 0.8125)
    );
    @Override
    public VoxelShape getOccModel(@NotNull BlockState state) {
        return SHAPE;
    }
    @Override
    public @NotNull String getSerializedName() {
        return this.name();
    }
    public boolean isLit(){
        return this.equals(ON);
    }
}
