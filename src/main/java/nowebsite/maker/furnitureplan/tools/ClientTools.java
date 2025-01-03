package nowebsite.maker.furnitureplan.tools;

import com.mojang.math.Transformation;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
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

    public static BakedQuad createQuad(Vector3f v1, Vector3f v2, Vector3f v3, Vector3f v4, Transformation rotation, TextureAtlasSprite sprite) {
        Vector3f normal = new Vector3f(v3);
        normal.sub(v2);
        Vector3f temp = new Vector3f(v1);
        temp.sub(v2);
        normal.cross(temp);
        normal.normalize();

        int tw = sprite.contents().width();
        int th = sprite.contents().height();

        rotation = rotation.blockCenterToCorner();
        rotation.transformNormal(normal);

        Vector4f vv1 = new Vector4f(v1, 1.0f); rotation.transformPosition(vv1);
        Vector4f vv2 = new Vector4f(v2, 1.0f); rotation.transformPosition(vv2);
        Vector4f vv3 = new Vector4f(v3, 1.0f); rotation.transformPosition(vv3);
        Vector4f vv4 = new Vector4f(v4, 1.0f); rotation.transformPosition(vv4);

        var builder = new QuadBakingVertexConsumer();
        builder.setSprite(sprite);
        builder.setDirection(Direction.getNearest(normal.x(), normal.y(), normal.z()));
        putVertex(builder, normal, vv1, 0, 0, sprite);
        putVertex(builder, normal, vv2, 0, th, sprite);
        putVertex(builder, normal, vv3, tw, th, sprite);
        putVertex(builder, normal, vv4, tw, 0, sprite);
        return builder.bakeQuad();
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull Vector3f v(float x, float y, float z) {
        return new Vector3f(x, y, z);
    }
}
