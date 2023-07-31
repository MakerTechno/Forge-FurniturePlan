package nowebsite.maker.furnitureplan.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;

public class RideableArmor extends ArmorStand {
    public RideableArmor(EntityType<? extends ArmorStand> entityType, Level level) {
        super(entityType, level);
        setNoGravity(true);
        setInvisible(true);
        horizontalCollision = false;
        minorHorizontalCollision = false;
        verticalCollision = false;
        verticalCollisionBelow = false;
    }

}
