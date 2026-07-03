package nowebsite.maker.furnitureplan.utils.uvmodel;

import java.util.ArrayList;
import java.util.List;

public class CubeModel {
    private final float x, y, z, w, h, d;
    private final List<Face> faces = new ArrayList<>();

    public CubeModel(float x, float y, float z, float w, float h, float d) {
        this.x = x; this.y = y; this.z = z;
        this.w = w; this.h = h; this.d = d;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }

    public float getH() {
        return h;
    }

    public float getD() {
        return d;
    }

    void addFace(Face face) {
        faces.add(face);
    }

    public List<Face> getFaces() {
        return faces;
    }

    // 只存储几何和贴图声明，不做渲染
}
