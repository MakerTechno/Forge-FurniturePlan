package nowebsite.maker.furnitureplan.tools;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.neoforged.neoforge.client.model.pipeline.QuadBakingVertexConsumer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector4f;

@SuppressWarnings("unused")
public class ClientTools {

    private static void putVertex(QuadBakingVertexConsumer builder, Vector3f normal, Vector4f vector,
                                  float u, float v, TextureAtlasSprite sprite) {
        builder.addVertex(vector.x(), vector.y(), vector.z())
                .setColor(1.0f, 1.0f, 1.0f, 1.0f)
                .setUv(sprite.getU(u), sprite.getV(v))
                .setUv2(0, 0)
                .setNormal(normal.x(), normal.y(), normal.z());
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Vector3f v(float x, float y, float z) {
        return new Vector3f(x, y, z);
    }
}
