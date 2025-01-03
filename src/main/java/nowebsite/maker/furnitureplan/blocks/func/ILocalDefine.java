package nowebsite.maker.furnitureplan.blocks.func;

public interface ILocalDefine {
    String parentName();
    String textureKey();
    String textureName();
    default boolean fromVanilla() {
        return false;
    }
}
