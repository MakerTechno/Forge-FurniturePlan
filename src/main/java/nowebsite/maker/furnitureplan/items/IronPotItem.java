package nowebsite.maker.furnitureplan.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public class IronPotItem extends BlockItem {
    //1200' is a minute, as 20 per second.
    private static final MobEffectInstance[] effectAbilities = {
            new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false),
            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, false, false),
            new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false),//as well-known "nausea"
            new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, false, false),
            new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0, false, false),
            new MobEffectInstance(MobEffects.DARKNESS, 200, 0, false, false)
    };
    public IronPotItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public int getDamage(ItemStack stack) {
        return 8;
    }
    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        attacker.playSound(SoundEvents.ANVIL_LAND, 5.0f, 1.0f);
        target.addEffect(getRandomEffect(attacker.getRandom()));
        target.addDeltaMovement(attacker.getViewVector(1.0F).normalize().scale(1.8));
        target.hurtMarked = true;
        return super.hurtEnemy(stack, target, attacker);
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
    }
    @Override
    protected @NotNull SoundEvent getPlaceSound(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player entity) {
        return SoundEvents.ANVIL_LAND;
    }
    public MobEffectInstance getRandomEffect(RandomSource source){
        return effectAbilities[source.nextInt(effectAbilities.length)];
    }
}
