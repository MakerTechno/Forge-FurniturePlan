package nowebsite.maker.furnitureplan.mixin.sources;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.state.BlockState;
import nowebsite.maker.furnitureplan.blocks.IWeatheringCopper;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(LightningBolt.class)
public class LightningBoltMixin {

    @Inject(method = {"clearCopperOnLightningStrike"}, at = {@At(value = "HEAD")} )
    private static void clearCopperOnLightningStrike(@NotNull Level level, BlockPos pos, CallbackInfo ci) {
        BlockState blockstate = level.getBlockState(pos);
        BlockPos blockpos;
        BlockState blockstate1;
        if (blockstate.is(Blocks.LIGHTNING_ROD)) {
            blockpos = pos.relative(blockstate.getValue(LightningRodBlock.FACING).getOpposite());
            blockstate1 = level.getBlockState(blockpos);
        } else {
            blockpos = pos;
            blockstate1 = blockstate;
        }

        if (blockstate1.getBlock() instanceof IWeatheringCopper) {
            level.setBlockAndUpdate(blockpos, IWeatheringCopper.getFirst(level.getBlockState(blockpos)));
            BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
            int i = level.random.nextInt(3) + 3;

            for(int j = 0; j < i; ++j) {
                int k = level.random.nextInt(8) + 1;
                forge1_19_4FurniturePlan$randomWalkCleaningCopper(level, blockpos, blockpos$mutableblockpos, k);
            }
        }
    }
    @Unique
    private static void forge1_19_4FurniturePlan$randomWalkCleaningCopper(Level level, BlockPos pos, BlockPos.@NotNull MutableBlockPos mutableBlockPos, int cont) {
        mutableBlockPos.set(pos);

        for(int i = 0; i < cont; ++i) {
            Optional<BlockPos> optional = forge1_19_4FurniturePlan$randomStepCleaningCopper(level, mutableBlockPos);
            if (optional.isEmpty()) {
                break;
            }

            mutableBlockPos.set(optional.get());
        }

    }

    @Unique
    private static Optional<BlockPos> forge1_19_4FurniturePlan$randomStepCleaningCopper(@NotNull Level level, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.randomInCube(level.random, 10, pos, 1)) {
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.getBlock() instanceof IWeatheringCopper) {
                IWeatheringCopper.getPrevious(blockstate).ifPresent((p_147144_) -> {
                    level.removeBlockEntity(blockpos);
                    level.removeBlock(blockpos, true);
                    level.setBlockAndUpdate(blockpos, p_147144_);
                });
                level.levelEvent(3002, blockpos, -1);
                return Optional.of(blockpos);
            }
        }

        return Optional.empty();
    }
}
