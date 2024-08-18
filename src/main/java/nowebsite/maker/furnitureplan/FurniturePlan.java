package nowebsite.maker.furnitureplan;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nowebsite.maker.furnitureplan.datagen.ModDataGenerators;
import nowebsite.maker.furnitureplan.registry.*;
import nowebsite.maker.furnitureplan.setup.ClientSetup;
import nowebsite.maker.furnitureplan.setup.ModSetup;
import org.slf4j.Logger;

@Mod(FurniturePlan.MOD_ID)
public class FurniturePlan {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "furnitureplan";
    public static BlockEntityWithoutLevelRenderer renderer;

    public FurniturePlan() {
        LOGGER.info("Furniture plan alpha is on loading!");
        EntityRegistration.init();
        BlockRegistration.init();
        ItemRegistration.init();
        PaintRegistration.init();
        GUIRegistration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModDataGenerators::gatherData);

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }

}
