package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import nowebsite.maker.furnitureplan.common.block.seating.BenchBlock;
import nowebsite.maker.furnitureplan.common.block.seating.ChairBlock;
import nowebsite.maker.furnitureplan.common.init.FPBlockReg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FPBlockSet {
    public final FPBlockSetType materialType;
    public final DeferredBlock<@NotNull ChairBlock> CHAIR;
    public final DeferredBlock<@NotNull BenchBlock> BENCH;

    protected FPBlockSet(Builder builder) {
        this.materialType = builder.materialType;
        CHAIR = init(builder, FPBlockType.CHAIR);
        BENCH = init(builder, FPBlockType.BENCH);
    }

    @SuppressWarnings("all")
    public static <T extends Block> DeferredBlock<T> init(Builder builder, FPBlockType<T> type) {
        Builder.TFBlockBuildEntry<T> entry = builder.getEntry(type);
        if (!entry.available) {
            return null;
        }
        DeferredBlock<T> block = FPBlockReg.registerWithItem(entry.specialId != null ? entry.specialId : builder.materialType.name() + "_" + type.name(), entry.getEntryResult());
        type.register(block);
        return block;
    }

    public static class Builder {
        public static class TFBlockBuildEntry<T extends Block> {
            public boolean available = true;
            public @Nullable String specialId;
            public BiFunction<BlockBehaviour.Properties, Consumer<BlockBehaviour.Properties>, T> blockSupplier;
            public BlockBehaviour.Properties properties;
            public Consumer<BlockBehaviour.Properties> applier = properties1 -> {};
            public final FPBlockType<T> blockType;
            public TFBlockBuildEntry(FPBlockType<T> blockType, BlockBehaviour.Properties defaultProp, BiFunction<BlockBehaviour.Properties, Consumer<BlockBehaviour.Properties>, T> blockSupplier) {
                this.blockType = blockType;
                this.properties = defaultProp;
                this.blockSupplier = blockSupplier;
            }
            public Function<Identifier, T> getEntryResult() {
                /* Copy to instance-like */
                BlockBehaviour.Properties propertiesFinal = this.properties;
                Consumer<BlockBehaviour.Properties> applierFinal = applier;
                BiFunction<BlockBehaviour.Properties, Consumer<BlockBehaviour.Properties>, T> blockSupplierFinal = blockSupplier;
                return name -> blockSupplierFinal.apply(propertiesFinal.setId(ResourceKey.create(Registries.BLOCK, name)), applierFinal.andThen(p -> p.setId(ResourceKey.create(Registries.BLOCK, name))));
            }
        }

        protected final FPBlockSetType materialType;
        protected final boolean fullCopyProp;
        private final Block propSourceBlock;

        private final Map<FPBlockType<?>, TFBlockBuildEntry<?>> entries = new Object2ObjectArrayMap<>();

        public Builder(FPBlockSetType materialType, Block propSourceBlock, boolean fullCopyProp) {
            this.materialType = materialType;
            this.fullCopyProp = fullCopyProp;
            this.propSourceBlock = propSourceBlock;
            //putEntry(FPBlockType.BUTTON, (p, a) -> new ButtonBlock(materialType.getType(), this.buttonPressedTick, p));
            putEntry(FPBlockType.CHAIR, (p, a) -> new ChairBlock(materialType, propSourceBlock.defaultBlockState(), a, 0.4375F));
            putEntry(FPBlockType.BENCH, (p, a) -> new BenchBlock(materialType, propSourceBlock.defaultBlockState(), p));
        }

        @SuppressWarnings("deprecation")
        protected <T extends Block> void putEntry(FPBlockType<T> type, BiFunction<BlockBehaviour.Properties, Consumer<BlockBehaviour.Properties>, T> blockSupplier) {
            entries.put(type, new TFBlockBuildEntry<>(type, fullCopyProp ? BlockBehaviour.Properties.ofFullCopy(propSourceBlock) : BlockBehaviour.Properties.ofLegacyCopy(propSourceBlock), blockSupplier));
        }

        @SuppressWarnings("unchecked")
        public <T extends Block> TFBlockBuildEntry<T> getEntry(FPBlockType<T> type) {
            return (TFBlockBuildEntry<T>) entries.get(type);
        }

        public Builder disableAll() {
            entries.values().forEach(entry -> entry.available = false);
            return this;
        }

        public <T extends Block> Builder setAvailabilityFor(FPBlockType<T> key, boolean availability) {
            entries.get(key).available = availability;
            return this;
        }

        @SuppressWarnings("all")
        public <T extends Block> Builder setGetterFor(FPBlockType<T> key, BiFunction<BlockBehaviour.Properties, Consumer<BlockBehaviour.Properties>, T> instanceGetter) {
            ((TFBlockBuildEntry<T>)entries.get(key)).blockSupplier = instanceGetter;
            return this;
        }

        public <T extends Block> Builder setSpecialIdFor(FPBlockType<T> key, String id) {
            entries.get(key).specialId = id;
            return this;
        }

        public <T extends Block> Builder setPropertyApplierFor(FPBlockType<T> key, Consumer<BlockBehaviour.Properties> applier) {
            entries.get(key).applier = applier;
            return this;
        }

        public <T extends Block> Builder setPropertyFor(FPBlockType<T> key, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> properties) {
            BlockBehaviour.Properties old = entries.get(key).properties;
            entries.get(key).properties = properties.apply(old);
            return this;
        }

        public Builder doLightSetup(int candle, int lantern, int lamp, int candelabras, int chandelier) {
            //this.candleBlockLight = candle;
            //this.lanternBlockLight = lantern;
            //this.lamp = lamp;
            //this.candelabras = candelabras;
            //this.chandelier = chandelier;
            return this;
        }


        public Builder chairSitHeight(float chairSitHeight) {
            return this;
        }

        public FPBlockSet build() {
            /* Light init */
            //setPropertyFor(FPBlockType.CHANDELIER, properties -> properties.lightLevel(TFBlocks.litBlockEmission(chandelier)));
            return new FPBlockSet(this);
        }
    }
}
