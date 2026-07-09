package nowebsite.maker.furnitureplan.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPColorfulSetType;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import nowebsite.maker.furnitureplan.common.init.FPBlockSetTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FPDataMapProvider extends DataMapProvider {

    protected FPDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        Builder<Oxidizable, Block> oxidizables = this.builder(NeoForgeDataMaps.OXIDIZABLES).replace(false);
        for (FPBlockType<?> type : FPBlockType.registry().values()) {
            DeferredBlock<?> origin = FPBlockReg.CUT_COPPERS.get().getByType(type);
            if (origin == null) continue;
            DeferredBlock<?> second = FPBlockReg.EXPOSED_COPPERS.get().getByType(type);
            DeferredBlock<?> third = FPBlockReg.WEATHERED_COPPERS.get().getByType(type);
            DeferredBlock<?> last = FPBlockReg.OXIDIZED_COPPERS.get().getByType(type);
            assert second != null;assert third != null;assert last != null;
            oxidizables.add(origin, new Oxidizable(second.get()), false);
            oxidizables.add(second, new Oxidizable(third.get()), false);
            oxidizables.add(third, new Oxidizable(last.get()), false);
        }


        {
            List<DeferredBlock<@NotNull CabinetBlock>> originList = FPBlockReg.CABINET_HOLDERS.get(FPBlockSetTypes.CUT_COPPER_SET);
            List<DeferredBlock<@NotNull CabinetBlock>> secondList = FPBlockReg.CABINET_HOLDERS.get(FPBlockSetTypes.EXPOSED_CUT_COPPER_SET);
            List<DeferredBlock<@NotNull CabinetBlock>> thirdList = FPBlockReg.CABINET_HOLDERS.get(FPBlockSetTypes.WEATHERED_CUT_COPPER_SET);
            List<DeferredBlock<@NotNull CabinetBlock>> lastList = FPBlockReg.CABINET_HOLDERS.get(FPBlockSetTypes.OXIDIZED_CUT_COPPER_SET);

            List<FPColorfulSetType> withNull = new ArrayList<>(FPColorfulSetType.TYPES);
            withNull.add(null);
            for (FPColorfulSetType type : withNull) {
                DeferredBlock<@NotNull CabinetBlock> origin = originList.stream()
                    .filter(holder -> holder.get().getFrameType() == type)
                    .findFirst().orElse(null);
                if (origin == null) continue;
                DeferredBlock<@NotNull CabinetBlock> second = secondList.stream()
                    .filter(holder -> holder.get().getFrameType() == type)
                    .findFirst().orElse(null);
                DeferredBlock<@NotNull CabinetBlock> third = thirdList.stream()
                    .filter(holder -> holder.get().getFrameType() == type)
                    .findFirst().orElse(null);
                DeferredBlock<@NotNull CabinetBlock> last = lastList.stream()
                    .filter(holder -> holder.get().getFrameType() == type)
                    .findFirst().orElse(null);
                assert second != null;assert third != null;assert last != null;
                oxidizables.add(origin, new Oxidizable(second.get()), false);
                oxidizables.add(second, new Oxidizable(third.get()), false);
                oxidizables.add(third, new Oxidizable(last.get()), false);
            }
        }
    }
}
