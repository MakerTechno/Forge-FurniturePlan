package nowebsite.maker.furnitureplan.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class GUIUtil {
    private static void buildVertex(@NotNull VertexConsumer consumer, @NotNull PoseStack poseStack, float r, float g, float b, float a, float p1, float p2, float u0, float u1, int light, int overlay) {
        consumer.addVertex(poseStack.last().pose(), p1, p2, 0)
                .setColor(r, g, b, a).setUv(u0, u1)
                .setOverlay(overlay)
                .setUv2(light & '\uffff', light >> 16 & '\uffff')
                .setNormal(poseStack.last(), 1, 1, 1);
    }
    public static void drawTexturedColoredRect(
            VertexConsumer builder, PoseStack transform, float x, float y, float w,
            float h, float r, float g, float b, float alpha, float u0, float u1, float v0, float v1, int light, int overlay
    ) {
        buildVertex(builder, transform, r, g, b, alpha, x, y + h, u0, v1, light, overlay);
        buildVertex(builder, transform, r, g, b, alpha, x + w, y + h, u1, v1, light, overlay);
        buildVertex(builder, transform, r, g, b, alpha, x + w, y, u1, v0, light, overlay);
        buildVertex(builder, transform, r, g, b, alpha, x, y, u0, v0, light, overlay);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Vector3f colorCast(int col) {
        return new Vector3f((col >> 16 & 255) / 255.0f, (col >> 8 & 255) / 255.0f, (col & 255) / 255.0f);
    }
}
