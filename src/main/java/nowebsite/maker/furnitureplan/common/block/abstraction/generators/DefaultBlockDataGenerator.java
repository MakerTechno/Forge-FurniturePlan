package nowebsite.maker.furnitureplan.common.block.abstraction.generators;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import nowebsite.maker.furnitureplan.common.block.abstraction.BlockSetGetter;
import nowebsite.maker.furnitureplan.common.data.gen.FPChineseProvider;
import nowebsite.maker.furnitureplan.common.data.gen.empowered.BlockDataGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

/**
 * 以泰拉家具的生成器为参考, 对其进行特异化改造, 以符合基本生成需求。
 */
public abstract class DefaultBlockDataGenerator<T extends Block & BlockSetGetter> implements BlockDataGenerator<@NotNull T> {
    @Override
    public void buildModelWithTemplate(@NotNull T block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output) {
        MultiVariant model = BlockModelGenerators.plainVariant(TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(toIdentifier("block/template/" + getTemplateType(block))),
                Optional.empty(),
                TextureSlot.PARTICLE
            )).create(block, blockModelGenerators.modelOutput)
        );
        MultiVariantGenerator variant = MultiVariantGenerator.dispatch(block, model);
        if (doLockUV()) variant.with(BlockModelGenerators.UV_LOCK);
        blockModelGenerators.blockStateOutput.accept(variant);
    }

    @Override
    public void addBlockTags(T block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
        keys.addAll(block.getType().getTagKeys().get());
    }

    @Override
    public String getChineseTranslation(@NotNull T block) {
        return block.getType().getTranslations().get(FPChineseProvider.LOCALE) + getTemplateType(block).getTranslations().get(FPChineseProvider.LOCALE);
    }

    @Override
    public void addItemTags(@NotNull T block, ItemTagsProvider provider, List<TagKey<Item>> keys) {

    }
}
