package nowebsite.maker.furnitureplan.common.block.abstraction.generators;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.common.data.gen.FPModelProvider;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public abstract class SingleMulStateBDG<S extends Enum<S> & ICustomModelInfo, T extends Block & BlockSetGetter & MulStateGetter<S>> extends HorizontalBDG<T> {
    @Override
    public void buildModelWithTemplate(@NotNull T block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output) {
        customModelBlockWithItem(block, blockModelGenerators);
    }
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, M extends Enum<M> & ICustomModelInfo, B extends Block & BlockSetGetter & MulStateGetter<M>> void customModelBlockWithItem(Block block, BlockModelGenerators generators) {
        List<Property<@NotNull T>> properties = block.defaultBlockState().getProperties().stream().map(property -> (Property<@NotNull T>) property).toList();

        Property<@NotNull M> modelProp = FPModelProvider.doModelSRCheck(properties, block);
        PropertyDispatch.C1<MultiVariant, @NotNull M> dispatch = PropertyDispatch.initial(modelProp);
        modelProp.getPossibleValues().stream()
            .map(modelInfo -> new Pair<>(modelInfo, BlockModelGenerators.plainVariant(TexturedModel.createDefault(
                _ -> new TextureMapping()
                    .put(TextureSlot.PARTICLE, new Material(((B)block).getType().getTexture())),
                new ModelTemplate(
                    Optional.of(modelInfo.getModel(block)),
                    Optional.empty(),
                    TextureSlot.PARTICLE
                )
            ).createWithSuffix(block, "_" + modelInfo.getSerializedName(), generators.modelOutput))))
            .forEach(pair -> dispatch.select(pair.getFirst(), pair.getSecond()));

        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block).with(dispatch);
        generators.blockStateOutput.accept(variant);

        generators.registerSimpleItemModel(block, FurniturePlan.asResource("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + modelProp.getPossibleValues().getFirst().getSerializedName()));
    }
}
