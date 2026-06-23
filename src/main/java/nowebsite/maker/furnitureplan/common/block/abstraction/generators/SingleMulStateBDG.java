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
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.block.abstraction.MulStateGetter;
import nowebsite.maker.furnitureplan.utils.ICustomModelInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public abstract class SingleMulStateBDG<M extends Enum<M> & ICustomModelInfo, B extends Block & BlockSetGetter & MulStateGetter<M>> extends DefaultBlockDataGenerator<B> {
    @Override
    public void buildModelWithTemplate(@NotNull B block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output) {
        PropertyDispatch.C1<MultiVariant, @NotNull M> dispatch = PropertyDispatch.initial(block.getContainer());
        List<M> mainProp = block.getEnumPropertyObjects();
        mainProp.stream()
            .map(modelInfo -> new Pair<>(modelInfo, BlockModelGenerators.plainVariant(TexturedModel.createDefault(
                _ -> new TextureMapping()
                    .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture())),
                new ModelTemplate(
                    Optional.of(modelInfo.getModel(block)),
                    Optional.empty(),
                    TextureSlot.PARTICLE
                )
            ).createWithSuffix(block, "_" + modelInfo.getSerializedName(), blockModelGenerators.modelOutput))))
            .forEach(pair -> dispatch.select(pair.getFirst(), pair.getSecond()));

        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block).with(dispatch);
        blockModelGenerators.blockStateOutput.accept(variant);

        if (getItemTemplate() != null) blockModelGenerators.registerSimpleItemModel(block, TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(getItemTemplate()),
                Optional.empty(),
                TextureSlot.PARTICLE
            )).create(block, itemModelGenerators.modelOutput));
        else blockModelGenerators.registerSimpleItemModel(block, FurniturePlan.asResource("block/" + getBlockPath(block) + "_" + mainProp.getFirst().getSerializedName()));
    }
}
