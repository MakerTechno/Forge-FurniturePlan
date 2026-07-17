package nowebsite.maker.furnitureplan.common.block.abstraction.set;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.furnitureplan.FurniturePlan;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class FPBlockSetType {
    public static final List<FPBlockSetType> TYPES = new ArrayList<>();
    private final String name;
    private final Supplier<List<TagKey<Block>>> tagKeys;
    private final Map<String, String> translations = new HashMap<>();
    private final boolean enableTransGen;
    private final Identifier texture;
    private final Block base;
    private final boolean copyAll;
    private final int animPart;

    public FPBlockSetType(String name, Supplier<List<TagKey<Block>>> key, Block base, boolean copyAll) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = false;
        this.texture = Identifier.withDefaultNamespace("block/" + name);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = 0;
    }

    public FPBlockSetType(String name, Supplier<List<TagKey<Block>>> key, Block base, boolean copyAll, String texture) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = false;
        this.texture = Identifier.withDefaultNamespace("block/" + texture);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = 0;
    }

    public FPBlockSetType(String name, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = transInit.apply(this.translations);
        this.texture = Identifier.withDefaultNamespace("block/" + name);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = 0;
    }

    public FPBlockSetType(String name, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit, String texture) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = transInit.apply(this.translations);
        this.texture = Identifier.withDefaultNamespace("block/" + texture);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = 0;
    }

    public FPBlockSetType(String name, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit, String texture, String mod_id) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = transInit.apply(this.translations);
        this.texture = Identifier.fromNamespaceAndPath(mod_id, "block/" + texture);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = 0;
    }


    public FPBlockSetType(String name, Supplier<List<TagKey<Block>>> key, Block base, boolean copyAll, int animPart) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = false;
        this.texture = Identifier.withDefaultNamespace("block/" + name);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = animPart;
    }

    public FPBlockSetType(String name, Supplier<List<TagKey<Block>>> key, Block base, boolean copyAll, String texture, int animPart) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = false;
        this.texture = Identifier.withDefaultNamespace("block/" + texture);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = animPart;
    }

    public FPBlockSetType(String name, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit, int animPart) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = transInit.apply(this.translations);
        this.texture = Identifier.withDefaultNamespace("block/" + name);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = animPart;
    }

    public FPBlockSetType(String name, Block base, boolean copyAll, Supplier<List<TagKey<Block>>> key, Function<Map<String, String>, Boolean> transInit, String texture, int animPart) {
        this.name = name;
        this.tagKeys = key;
        this.enableTransGen = transInit.apply(this.translations);
        this.texture = Identifier.withDefaultNamespace("block/" + texture);
        TYPES.add(this);
        this.base = base;
        this.copyAll = copyAll;
        this.animPart = animPart;
    }

    public Supplier<List<TagKey<Block>>> getTagKeys() {
        return tagKeys;
    }

    public String name() {
        return name;
    }

    public boolean isEnableTransGen() {
        return enableTransGen;
    }

    public Identifier getTexture() {
        return texture;
    }

    public Block getBase() {
        return base;
    }

    public boolean shouldCopyAll() {
        return copyAll;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public int getAnimPart() {
        return animPart;
    }
}
