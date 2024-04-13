package nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.container;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class DrawerOpensCounter extends ContainerOpenersCounter {
    @Override
    protected void onOpen(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        playSound(pLevel, pPos, SoundEvents.CHEST_OPEN);
    }
    @Override
    protected void onClose(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        playSound(pLevel, pPos, SoundEvents.CHEST_CLOSE);
    }

    @Override
    protected void openerCountChanged(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, int pCount, int pOpenCount) {

    }
    static void playSound(@NotNull Level pLevel, @NotNull BlockPos pPos, SoundEvent pSound) {
        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.5D;
        double d2 = (double)pPos.getZ() + 0.5D;
        pLevel.playSound(null, d0, d1, d2, pSound, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.1F + 0.9F);
    }
}
