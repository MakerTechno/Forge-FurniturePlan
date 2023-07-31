package nowebsite.maker.furnitureplan.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.registry.FoldingRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("deprecation")
public class ModBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper HELPER;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, FurniturePlan.MOD_ID, helper);
        this.HELPER = helper;
    }

    protected void registerStatesAndModels() {
        addKindsAsBlock(FoldingRegistration.getChairBlockLists(), "chairs");
        addKindsAsBlock(FoldingRegistration.getTableBlockLists(), "tables");
    }

    public void addKindsAsBlock(@NotNull List<RegistryObject<? extends Block>> list, String modelCap) {
        assert list.size() <= FoldingRegistration.PROPERTY_KINDS.length;
        int count = 0;
        for(RegistryObject<? extends Block> ro : list) {
            horizontalBlock(ro.get(), models().singleTexture(
                    BuiltInRegistries.BLOCK.getKey(ro.get()).toString(),
                    modLoc("block/" + modelCap), "particle",
                    mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS[count])
                    ));
            count++;
        }
    }
}
