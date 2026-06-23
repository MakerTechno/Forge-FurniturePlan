package nowebsite.maker.furnitureplan.common.block.abstraction.generators;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class HorizontalBDG<T extends Block & BlockSetGetter> extends DefaultBlockDataGenerator<T> {
    @Override
    public void buildModelWithTemplate(@NotNull T block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output) {
        blockModelGenerators.createHorizontallyRotatedBlock(block, TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(toIdentifier("block/template/" + getTemplateType(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )
        ));
        if (getItemTemplate() != null) blockModelGenerators.registerSimpleItemModel(block, TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(getItemTemplate()),
                Optional.empty(),
                TextureSlot.PARTICLE
            )).createWithSuffix(block, "_item", itemModelGenerators.modelOutput));
    }
}
