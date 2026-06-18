package nowebsite.maker.furnitureplan.common.block.abstraction.generators;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.FurniturePlan;
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
                Optional.of(FurniturePlan.asResource("block/template/" + getTemplateType(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )
        ));
        blockModelGenerators.registerSimpleItemModel(block, FurniturePlan.asResource(getTemplateLoc(block)).withPrefix("block/"));
    }
}
