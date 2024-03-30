package nowebsite.maker.furnitureplan.funcs;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
@OnlyIn(Dist.CLIENT)
public class ModLayerDefinitions {
    public static @NotNull ImmutableMap<ModelLayerLocation, LayerDefinition> createRoots(){
        ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();


        builder.put(ModelLayers.CHEST, ChestRenderer.createSingleBodyLayer());

        ForgeHooksClient.loadLayerDefinitions(builder);
        ImmutableMap<ModelLayerLocation, LayerDefinition> immutablemap = builder.build();

        List<ModelLayerLocation> list = ModelLayers.getKnownLocations().filter((layerLocation) -> {
            return !immutablemap.containsKey(layerLocation);
        }).collect(Collectors.toList());

        if (!list.isEmpty()) {
            throw new IllegalStateException("Missing layer definitions: " + list);
        } else {
            return immutablemap;
        }
    }

}
