package nowebsite.maker.furnitureplan.utils.uvmodel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class CubeRendererHelper {
    public static void render(
        CubeModel model, VertexConsumer builder, PoseStack.Pose pose,
        int light, int overlay
    ) {
        renderWithColor(model, builder, pose, 1f, 1f, 1f, 1f, light, overlay);
    }

    public static void renderWithColor(
        CubeModel model, VertexConsumer builder, PoseStack.Pose pose,
        float r, float g, float b, float a,
        int light, int overlay
    ) {
        for (Face face : model.getFaces()) {
            renderFace(face, builder, pose,
                model.getX(), model.getY(), model.getZ(),
                model.getW(), model.getH(), model.getD(),
                r,g,b,a,
                light, overlay);
        }
    }

    public static void renderFace(Face face,
                                   VertexConsumer builder,
                                   PoseStack.Pose pose,
                                   float x, float y, float z,
                                   float w, float h, float d,
                                   float r, float g, float b, float a,
                                   int light, int overlay) {
        switch (face.getDir()) {
            case NORTH -> drawQuad(
                builder, pose,
                x, y, z,
                x + w, y, z,
                x + w, y + h, z,
                x, y + h, z,
                face,
                r, g, b, a,
                light, overlay,
                0, 0, 1
            );
            case SOUTH -> drawQuad(
                builder, pose,
                x + w, y, z + d,
                x, y, z + d,
                x, y + h, z + d,
                x + w, y + h, z + d,
                face,
                r,g,b,a,
                light, overlay,
                0, 0, -1
            );
            case WEST -> drawQuad(
                builder, pose,
                x, y, z + d,
                x, y, z,
                x, y + h, z,
                x, y + h, z + d,
                face,
                r,g,b,a,
                light, overlay,
                1, 0, 0
            );
            case EAST -> drawQuad(
                builder, pose,
                x + w, y, z,
                x + w, y, z + d,
                x + w, y + h, z + d,
                x + w, y + h, z,
                face,
                r,g,b,a,
                light, overlay,
                -1, 0, 0
            );
            case UP -> drawQuad(
                builder, pose,
                x, y + h, z,
                x + w, y + h, z,
                x + w, y + h, z + d,
                x, y + h, z + d,
                face,
                r,g,b,a,
                light, overlay,
                0, -1, 0
            );
            case DOWN -> drawQuad(
                builder, pose,
                x, y, z + d,
                x + w, y, z + d,
                x + w, y, z,
                x, y, z,
                face,
                r,g,b,a,
                light, overlay,
                0, 1, 0
            );
        }
    }

        private static void drawQuad(VertexConsumer builder, PoseStack.Pose pose,
                                 float x0, float y0, float z0,
                                 float x1, float y1, float z1,
                                 float x2, float y2, float z2,
                                 float x3, float y3, float z3,
                                 Face face,
                                 float r, float g, float b, float a,
                                 int light, int overlay,
                                 float nx, float ny, float nz) {
        int lu = light & 0xFFFF;
        int lv = (light >> 16) & 0xFFFF;

        // 取旋转后的四个 UV
        float[][] uvs = face.getRotatedUVs();

        builder.addVertex(pose.pose(), x0, y0, z0)
            .setColor(r,g,b,a)
            .setUv(uvs[0][0], uvs[0][1])
            .setOverlay(overlay).setUv2(lu, lv)
            .setNormal(pose, nx, ny, nz);

        builder.addVertex(pose.pose(), x1, y1, z1)
            .setColor(r,g,b,a)
            .setUv(uvs[1][0], uvs[1][1])
            .setOverlay(overlay).setUv2(lu, lv)
            .setNormal(pose, nx, ny, nz);

        builder.addVertex(pose.pose(), x2, y2, z2)
            .setColor(r,g,b,a)
            .setUv(uvs[2][0], uvs[2][1])
            .setOverlay(overlay).setUv2(lu, lv)
            .setNormal(pose, nx, ny, nz);

        builder.addVertex(pose.pose(), x3, y3, z3)
            .setColor(r,g,b,a)
            .setUv(uvs[3][0], uvs[3][1])
            .setOverlay(overlay).setUv2(lu, lv)
            .setNormal(pose, nx, ny, nz);
    }

}

