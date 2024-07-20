package nowebsite.maker.furnitureplan.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import nowebsite.maker.furnitureplan.blocks.singleblockfurniture.blockentities.ChairBlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RideableEntityNull extends Entity {
    public final Supplier<ChairBlockEntity> supplier;
    public RideableEntityNull(EntityType<? extends ArmorStand> entityType, Level level, Supplier<ChairBlockEntity> supplier) {
        super(entityType, level);
        this.supplier = supplier;
        setNoGravity(true);
        setInvisible(true);
        horizontalCollision = false;
        minorHorizontalCollision = false;
        verticalCollision = false;
        verticalCollisionBelow = false;
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    public void tick() {
        super.tick();
        if (supplier.get() == null){
            this.kill();
        }
        else if (supplier.get().getBlockState() != supplier.get().containerBlock || canAddPassenger(this)){
            supplier.get().setRemoved();
        }
    }

    int count;
    @Override
    public void baseTick() {
        super.baseTick();
        if (count ==50) {
            if (supplier.get() == null){
                this.kill();
                supplier.get().setRemoved();
            }
        } else {
            count++;
        }
    }
    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag pCompound) {}
    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag pCompound) {}
}
