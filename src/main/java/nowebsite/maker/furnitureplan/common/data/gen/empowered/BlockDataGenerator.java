package nowebsite.maker.furnitureplan.common.data.gen.empowered;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import nowebsite.maker.furnitureplan.FurniturePlan;
import nowebsite.maker.furnitureplan.common.block.abstraction.set.FPBlockType;

import java.util.HashSet;

public interface BlockDataGenerator<T extends Block> {
    String TEMPLATE_FOLDER = "template";
    /**
     * 生成方块模型、方块状态表和物品模型
     */
    void buildModelWithTemplate(T block, BlockModelGenerators blockModelGenerators, ItemModelGenerators itemModelGenerators, PackOutput output);

    /**
     * 对应方块的模板类型
     */
    FPBlockType<? extends T> getTemplateType(T block);

    /**
     * 生成方块标签，在现有基础上添加标签请用{@link #addBlockTags(Block, BlockTagsProvider, HashSet)}
     */
    default HashSet<TagKey<Block>> getRegBlockTags(T block, BlockTagsProvider provider) {
        HashSet<TagKey<Block>> keys = new HashSet<>();
        addBlockTags(block, provider, keys);
        return keys;
    }

    /**
     * 添加方块标签
     */
    void addBlockTags(T block, BlockTagsProvider provider, HashSet<TagKey<Block>> keys);

    /**
     * 生成物品标签，在现有基础上添加标签请用{@link #addItemTags(Block, ItemTagsProvider, HashSet)}
     */
    default HashSet<TagKey<Item>> getRegItemTags(T block, ItemTagsProvider provider) {
        HashSet<TagKey<Item>> keys = new HashSet<>();
        addItemTags(block, provider, keys);
        return keys;
    }

    /**
     * 添加物品标签
     */
    void addItemTags(T block, ItemTagsProvider provider, HashSet<TagKey<Item>> keys);

    /**
     * 获取模板文件位置
     */
    default String getTemplateLoc(T block) {
        return "block/" + TEMPLATE_FOLDER + "/" + getTemplateType(block);
    }

    /**
     * 添加前缀
     */
    default String prefix(String loc, AccessType type) {
        return type.prefix(loc);
    }

    /**
     * 转换为家具资源路径
     */
    default Identifier toIdentifier(String loc) {
        return FurniturePlan.asResource(loc);
    }

    /**
     * 获取方块id名
     */
    default String getBlockPath(T block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }


    default boolean doLockUV() {
        return false;
    }

    /**
     * 前缀类型
     */
    enum AccessType {
        BLOCK("block"),
        ITEM("item");

        private final String type;
        AccessType(String type) {
            this.type = type;
        }

        public String prefix(String loc) {
            return this.type + "/" + loc;
        }

    }
}
