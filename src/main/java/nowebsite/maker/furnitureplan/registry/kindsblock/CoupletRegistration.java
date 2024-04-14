package nowebsite.maker.furnitureplan.registry.kindsblock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.furnitureplan.registry.BRUtils;

import static nowebsite.maker.furnitureplan.registry.BlockRegistration.BLOCKS;

@SuppressWarnings("unused")
public class CoupletRegistration extends BRUtils {
    public static void init(){}

    public static final RegistryObject<Block> COUPLET_A0 = BLOCKS.register("couplet_a0", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> COUPLET_A1 = BLOCKS.register("couplet_a1", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> COUPLET_C0 = BLOCKS.register("couplet_c0", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> COUPLET_A2 = BLOCKS.register("couplet_a2", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> COUPLET_A3 = BLOCKS.register("couplet_a3", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> COUPLET_C1 = BLOCKS.register("couplet_c1", () -> new Block(getSmallBlockBehaviors().sound(SoundType.WOOL)));
}
