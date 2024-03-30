package nowebsite.maker.furnitureplan.blocks.single.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.single.CupboardBlock;
import nowebsite.maker.furnitureplan.blocks.single.blockentities.CupboardBlockEntity;
import nowebsite.maker.furnitureplan.registry.SheetReference;
import nowebsite.maker.furnitureplan.setup.ClientSetup;
import org.jetbrains.annotations.NotNull;

public class CupboardEntityRenderer implements BlockEntityRenderer<CupboardBlockEntity> {
    private static final String SHELL = "shell";
    private static final String DRAWER_1 = "drawer1";
    private static final String DRAWER_2 = "drawer2";
    private static final String DRAWER_3 = "drawer3";
    private final ModelPart shell, drawer1, drawer2, drawer3;
    public CupboardEntityRenderer(BlockEntityRendererProvider.@NotNull Context context){
        ModelPart modelpart = context.bakeLayer(ClientSetup.CUPBOARD);
        this.shell = modelpart.getChild("shell");
        this.drawer1 = modelpart.getChild("drawer1");
        this.drawer2 = modelpart.getChild("drawer2");
        this.drawer3 = modelpart.getChild("drawer3");
    }
    public static @NotNull LayerDefinition createSingleBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot().addOrReplaceChild(SHELL, CubeListBuilder.create().texOffs(0,0), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r1", CubeListBuilder.create().texOffs(8, 0).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r2", CubeListBuilder.create().texOffs(4, 3).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r3", CubeListBuilder.create().texOffs(4, 8).addBox(0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r4", CubeListBuilder.create().texOffs(7, 7).addBox(0.0F, 1.0F, 14.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r5", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, 0.0F, 15.0F, 1.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("r6", CubeListBuilder.create().texOffs(0, 8).addBox(1.0F, 1.0F, 15.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);

        partdefinition.addOrReplaceChild("l1", CubeListBuilder.create().texOffs(4, 6).addBox(14.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("l2", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("l3", CubeListBuilder.create().texOffs(0, 6).addBox(15.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("l4", CubeListBuilder.create().texOffs(7, 5).addBox(15.0F, 1.0F, 14.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("l5", CubeListBuilder.create().texOffs(0, 3).addBox(15.0F, 0.0F, 15.0F, 1.0F, 2.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("l6", CubeListBuilder.create().texOffs(7, 2).addBox(14.0F, 1.0F, 15.0F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);

        partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 2.0F, 0.0F, 16.0F, 1.0F, 16.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(49, 2).addBox(0.5F, 3.0F, 0.5F, 1.0F, 12.0F, 15.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 49).addBox(14.5F, 3.0F, 0.5F, 1.0F, 12.0F, 15.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(72, 79).addBox(1.5F, 3.0F, 14.5F, 13.0F, 12.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 15.0F, 0.0F, 16.0F, 1.0F, 16.0F), PartPose.ZERO);

        partdefinition.addOrReplaceChild("f1", CubeListBuilder.create().texOffs(0, 34).addBox(1.5F, 11.0F, 0.5F, 13.0F, 0.5F, 14.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("f2", CubeListBuilder.create().texOffs(40, 35).addBox(1.5F, 7.0F, 0.5F, 13.0F, 0.5F, 14.0F), PartPose.ZERO);

        partdefinition = meshdefinition.getRoot().addOrReplaceChild(DRAWER_1, CubeListBuilder.create().texOffs(0,0), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p1base", CubeListBuilder.create().texOffs(32, 63).addBox(2.5F, 11.5F, 2.5F, 11.0F, 1.0F, 11.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p1right", CubeListBuilder.create().texOffs(0, 78).addBox(1.5F, 11.5F, 2.5F, 1.0F, 3.5F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p1left", CubeListBuilder.create().texOffs(46, 75).addBox(13.5F, 11.5F, 2.5F, 1.0F, 3.5F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p1back", CubeListBuilder.create().texOffs(80, 32).addBox(2.5F, 11.5F, 13.5F, 11.0F, 3.5F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p1forward", CubeListBuilder.create().texOffs(80, 0).addBox(1.5F, 11.5F, 0.5F, 13.0F, 3.5F, 2.0F), PartPose.ZERO);

        partdefinition = meshdefinition.getRoot().addOrReplaceChild(DRAWER_2, CubeListBuilder.create().texOffs(0,0), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p2base", CubeListBuilder.create().texOffs(50, 51).addBox(2.5F, 7.5F, 2.5F, 11.0F, 1.0F, 11.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p2right", CubeListBuilder.create().texOffs(20, 75).addBox(1.5F, 7.5F, 2.5F, 1.0F, 3.5F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p2left", CubeListBuilder.create().texOffs(69, 17).addBox(13.5F, 7.5F, 2.5F, 1.0F, 3.5F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p2back", CubeListBuilder.create().texOffs(80, 5).addBox(2.5F, 7.5F, 13.5F, 11.0F, 3.5F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p2forward", CubeListBuilder.create().texOffs(78, 69).addBox(1.5F, 7.5F, 0.5F, 13.0F, 3.5F, 2.0F), PartPose.ZERO);

        partdefinition = meshdefinition.getRoot().addOrReplaceChild(DRAWER_3, CubeListBuilder.create().texOffs(0,0), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p3base", CubeListBuilder.create().texOffs(17, 50)   .addBox(2.5F, 3.0F, 2.5F, 11.0F, 1.0F, 11.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p3right", CubeListBuilder.create().texOffs(66, 0)   .addBox(1.5F, 3.0F, 2.5F, 1.0F, 4.0F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p3left", CubeListBuilder.create().texOffs(64, 63)  .addBox(13.5F, 3.0F, 2.5F, 1.0F, 4.0F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p3back", CubeListBuilder.create().texOffs(34, 75)  .addBox(2.5F, 3.0F, 13.5F, 11.0F, 4.0F, 1.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("p3forward", CubeListBuilder.create().texOffs(78, 63).addBox(1.5F, 3.0F, 0.5F, 13.0F, 4.0F, 2.0F), PartPose.ZERO);


        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void render(@NotNull CupboardBlockEntity cupboard, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = cupboard.getLevel();
        boolean useBlockState = level != null;
        if (level != null) {
            packedLight = LevelRenderer.getLightColor(level, cupboard.getBlockPos());
        } else {
            packedLight = 15728880;
        }

        BlockState blockState = useBlockState ? cupboard.getBlockState() : cupboard.getBlockRef().defaultBlockState().setValue(CupboardBlock.FACING, Direction.SOUTH);
        Block block = blockState.getBlock();

        if (block instanceof CupboardBlock) {
            poseStack.pushPose();

            float f = blockState.getValue(CupboardBlock.FACING).toYRot()+180;

            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            poseStack.translate(-0.5D, -0.5D, -0.5D);

            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(SheetReference.CUPBOARD));

            for (int i = 0; i < 3; i++){
                float openness = 1 - cupboard.getOpenness(i, partialTick);
                openness = 1 - openness * openness * openness;
                ModelPart part = switch (i){
                    case 0 -> this.drawer1;
                    case 1 -> this.drawer2;
                    case 2 -> this.drawer3;
                    default -> null;
                };
                this.render(poseStack, vertexConsumer,cupboard.getBlockState().getValue(CupboardBlock.FACING), part, openness, packedLight, packedOverlay);
            }
            this.render(poseStack, vertexConsumer, cupboard.getBlockState().getValue(CupboardBlock.FACING), shell, 0, packedLight, packedOverlay);

            poseStack.popPose();

        }
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, @NotNull Direction direction, ModelPart part, float openness, int brightness, int combinedOverlayIn) {
        int mix = 8;
        part.z = -openness*mix;
        part.render(poseStack, vertexConsumer, brightness, combinedOverlayIn);
    }

    @Override
    public boolean shouldRenderOffScreen(@NotNull CupboardBlockEntity pBlockEntity) {
        return true;
    }
}
