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
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;
import nowebsite.maker.furnitureplan.common.block.storaging.CabinetBlock;
import nowebsite.maker.furnitureplan.common.data.gen.FPChineseProvider;
import nowebsite.maker.furnitureplan.common.init.FPTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class CabinetBDG extends HorizontalBDG<CabinetBlock> {
    public static final TextureSlot TRIM = TextureSlot.create("trim");
    @SuppressWarnings("all")
    @Override
    public void buildModelWithTemplate(CabinetBlock block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output) {
        assert !block.hasDoorRendered() || block.getFrameType() != null;
        createHorizontallyRotatedBlock(block, TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture()))
                .put(TRIM, new Material(block.hasDoorRendered() ? block.getFrameType().getTexture() : block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(toIdentifier("block/template/" + (block.hasDoorRendered() ? getTemplateType(block) : "cube"))),
                Optional.empty(),
                TextureSlot.PARTICLE,
                TRIM
            )
        ), blockModelGenerators);
        blockModelGenerators.registerSimpleItemModel(block, TexturedModel.createDefault(
            _ -> new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(block.getType().getTexture()))
                .put(TRIM, new Material(block.hasDoorRendered() ? block.getFrameType().getTexture() : block.getType().getTexture())),
            new ModelTemplate(
                Optional.of(FurniturePlan.asResource("item/cabinet")),
                Optional.empty(),
                TextureSlot.PARTICLE,
                TRIM
            )).createWithSuffix(block, "_item", itemModelGenerators.modelOutput));
    }

    private void createHorizontallyRotatedBlock(Block block, TexturedModel.Provider modelProvider, BlockModelGenerators generators) {
        MultiVariant model = BlockModelGenerators.plainVariant(modelProvider.create(block, generators.modelOutput));
        generators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, model).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING).with(BlockModelGenerators.UV_LOCK));
    }

    @Override
    public FPBlockType<? extends @NotNull CabinetBlock> getTemplateType(CabinetBlock block) {
        return FPBlockType.CABINET;
    }

    @Override
    public String getChineseTranslation(CabinetBlock block) {
        if (block.hasDoorRendered()) {
            assert block.getFrameType() != null;
            return block.getFrameType().getTranslations().get(FPChineseProvider.LOCALE) + "镶框的" + block.getType().getTranslations().get(FPChineseProvider.LOCALE) + getTemplateType(block).getTranslations().get(FPChineseProvider.LOCALE);
        } else  {
            return block.getType().getTranslations().get(FPChineseProvider.LOCALE) + "伪装" + getTemplateType(block).getTranslations().get(FPChineseProvider.LOCALE);
        }
    }

    @Override
    public void addBlockTags(CabinetBlock block, BlockTagsProvider provider, List<TagKey<Block>> keys) {
        super.addBlockTags(block, provider, keys);
        keys.add(FPTags.CABINET_BLOCK);
    }
}
