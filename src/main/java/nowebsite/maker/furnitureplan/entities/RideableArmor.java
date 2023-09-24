package nowebsite.maker.furnitureplan.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import nowebsite.maker.furnitureplan.blocks.blockentities.ChairBlockEntity;

import java.util.function.Supplier;

public class RideableArmor extends ArmorStand {
    public Supplier<ChairBlockEntity> supplier;
    public RideableArmor(EntityType<? extends ArmorStand> entityType, Level level, Supplier<ChairBlockEntity> supplier) {
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
    public void tick() {
        super.tick();
        if (supplier.get() == null){
            this.remove(RemovalReason.DISCARDED);
            supplier.get().setRemoved();
        }
    }

    int count;
    @Override
    public void baseTick() {
        super.baseTick();
        if (count ==50) {
            if (supplier.get() == null){
                this.remove(RemovalReason.DISCARDED);
                supplier.get().setRemoved();
            }
        } else {
            count++;
        }
    }

}
