package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.furnitureplan.blocks.func.IColorfulBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.CabinetBlock;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.ColorfulBorderedCabinet;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.CabinetBlockEntity;
import nowebsite.maker.furnitureplan.registry.SheetReference;
import nowebsite.maker.furnitureplan.utils.Couple;
import nowebsite.maker.furnitureplan.utils.GUIUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

public class CabinetEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity> {
    /*Couple: translate, scale, rotate*/
    private static final List<Couple<Vec3, Vec2, Vec3>> DOOR = new ArrayList<>();
    private static final Couple<Vec3, Vec2, Vec3> HANDLE;
    static {
        DOOR.add(Couple.of(new Vec3(0,0, 0), new Vec2(14,14), new Vec3(0,0,0)));
        DOOR.add(Couple.of(new Vec3(.875,0,.0625), new Vec2(14, 14), new Vec3(0,180,0)));
        DOOR.add(Couple.of(new Vec3(.875, 0, 0), new Vec2(1, 14), new Vec3(0, 270,0)));
        DOOR.add(Couple.of(new Vec3(0,0,.0625), new Vec2(1 ,14), new Vec3(0,90,0)));
        DOOR.add(Couple.of(new Vec3(0,.875,0), new Vec2(14,1), new Vec3(90,0,0)));
        DOOR.add(Couple.of(new Vec3(0,0,.0625), new Vec2(14,1), new Vec3(270,0,0)));
        HANDLE = Couple.of(new Vec3(.6875,.375,-0.001), new Vec2(2,2), new Vec3(0,0,0));
    }
    private static final List<Pair<Vec2, Vec2>> MAPS = new ArrayList<>();
    static {
        MAPS.add(Pair.of(new Vec2(1f/16, 1f/16), new Vec2(15f/16, 15f/16)));
        MAPS.add(Pair.of(new Vec2(1f/16, 1f/16), new Vec2(2f/16, 15f/16)));
        MAPS.add(Pair.of(new Vec2(1f/16, 1f/16), new Vec2(15f/16, 2f/16)));
    }
    @Override
    public boolean shouldRenderOffScreen(@NotNull CabinetBlockEntity blockEntity) {
        return true;
    }
    @Override
    public void render(@NotNull CabinetBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        Quaternionf faceRotate;
        switch (blockEntity.getBlockState().getValue(CabinetBlock.FACING)) {
            case EAST -> faceRotate = Axis.YP.rotationDegrees(270);
            case SOUTH -> faceRotate = Axis.YP.rotationDegrees(180);
            case WEST -> faceRotate = Axis.YP.rotationDegrees(90);
            default -> faceRotate = Axis.YP.rotationDegrees(0);
        }
        poseStack.rotateAround(faceRotate, .5f, .5f, .5f);
        poseStack.translate(.0625, .0625, 0);

        CabinetBlock based = (CabinetBlock)blockEntity.getBlockState().getBlock();
        if (!based.hasDoorRendered()){
            poseStack.popPose();
            return;
        }
        if (!(based instanceof ColorfulBorderedCabinet colorful)) {
            poseStack.popPose();
            return;
        }
        Block baseBlock = based.base;
        boolean useRL = false;
        ResourceLocation location = null;
        if (SheetReference.COPPER_TRANS_LIST.containsKey(baseBlock)) {
            baseBlock = SheetReference.COPPER_TRANS_LIST.get(baseBlock);
        } else if (SheetReference.FIX_TRANS_LIST.containsKey(baseBlock)) {
            useRL = true;
            location = SheetReference.FIX_TRANS_LIST.get(baseBlock);
        }

        VertexConsumer builder = bufferSource.getBuffer(RenderType.cutout());
        TextureAtlasSprite sprite = Minecraft.getInstance().getModelManager()
            .getAtlas(InventoryMenu.BLOCK_ATLAS)
            .getSprite(useRL?location:TextureMapping.getBlockTexture(baseBlock));
        TextureAtlasSprite trim = Minecraft.getInstance().getModelManager()
            .getAtlas(InventoryMenu.BLOCK_ATLAS)
            .getSprite(IColorfulBlock.CONCRETE_TEXTURE_LIST.get(colorful.getColorId()));

        float openness = 1 - blockEntity.getOpenness(partialTick);
        float partRotate = (float) ((1 - Math.pow(openness, 3))*Math.PI/2);
        

        for (Couple<Vec3, Vec2, Vec3> part : DOOR) {
            poseStack.pushPose();
            transform(poseStack, part, partRotate);
            boolean isCuber = part.second().x==part.second().y;
            boolean isHorizontal = part.third().x!=0;
            int index = isCuber?0:isHorizontal?2:1;
            GUIUtil.drawTexturedRect(
                builder, poseStack, 0, 0, part.second().x /16, part.second().y /16,
                offset(sprite.getU0(), sprite.getU1(), index, true, true),
                offset(sprite.getU0(), sprite.getU1(), index, false, true),
                offset(sprite.getV0(), sprite.getV1(), index, true, false),
                offset(sprite.getV0(), sprite.getV1(), index, false, false),
                packedLight, packedOverlay
            );
            poseStack.popPose();
        }

        poseStack.pushPose();
        transform(poseStack, HANDLE, partRotate);
        GUIUtil.drawTexturedRect(
            builder, poseStack, 0, 0, HANDLE.second().x /16, HANDLE.second().y /16,
            trim.getU0(), trim.getU1(), trim.getV0(), trim.getV1(),
            packedLight, packedOverlay
        );
        poseStack.popPose();

        poseStack.popPose();
    }

    private static void transform(@NotNull PoseStack poseStack, @NotNull Couple<Vec3, Vec2, Vec3> part, float partRotate) {
        boolean flag1 = part.third().y == 180;
        boolean flag2 = part.third().x == 0;
        boolean flag3 = part.third().x == 270;
        poseStack.translate(part.first().x, part.first().y, part.first().z);
        poseStack.rotateAround(Axis.XP.rotationDegrees((float) part.third().x),0,0,0);
        poseStack.rotateAround(Axis.YP.rotationDegrees((float) part.third().y),0,0,0);
        if (part.equals(HANDLE)){
            poseStack.rotateAround(Axis.YP.rotation(partRotate), (float) -part.first().x, 0, (float) -part.first().z);
            return;
        }
        poseStack.rotateAround(flag2 ? Axis.YP.rotation(partRotate) : Axis.ZP.rotation(partRotate *(flag3?1:-1)),
            (float) ((flag1||flag3? part.first().x: part.first().z)),
            (float) (flag3? part.first().z:0),
            (float) ((flag1? part.first().z: part.first().x))
        );
    }
    /**U0, V0, U1, V1 trans.*/
    private static float offset(float f0, float f1, int index, boolean isFirst, boolean isU) {
        Vec2 vec2 = isFirst?MAPS.get(index).getFirst():MAPS.get(index).getSecond();
        return (isU?f0:f1)+(f1 - f0)*(isU?vec2.x:-vec2.y);
    }
}
