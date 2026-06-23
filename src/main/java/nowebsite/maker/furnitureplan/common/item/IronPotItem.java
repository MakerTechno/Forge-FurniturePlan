package nowebsite.maker.furnitureplan.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class IronPotItem extends BlockItem {
    //1200' is one minute, as 20 per second.
    private static final MobEffectInstance[] effectAbilities = {
            new MobEffectInstance(MobEffects.BLINDNESS, 200, 255, false, true),
            new MobEffectInstance(MobEffects.SLOWNESS, 200, 2, false, true),
            new MobEffectInstance(MobEffects.NAUSEA, 200, 1, false, true),
            new MobEffectInstance(MobEffects.WEAKNESS, 200, 2, false, true),
            new MobEffectInstance(MobEffects.MINING_FATIGUE, 200, 2, false, true),
            new MobEffectInstance(MobEffects.DARKNESS, 400, 2, false, true)
    };
    public IronPotItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public int getDamage(ItemStack stack) {
        return 15;
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Vec3 pos = target.position();
        attacker.level().playSound(null, pos.x, pos.y, pos.z, SoundEvents.ANVIL_LAND, SoundSource.BLOCKS, 5.0f, 1.0f);
        target.addEffect(getRandomEffect(attacker.getRandom()));
        target.addEffect(getRandomEffect(attacker.getRandom()));
        target.addDeltaMovement(attacker.getViewVector(1.0F).normalize().scale(2.6).add(attacker.getDeltaMovement()));
        target.hurtMarked = true;
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
    }

    @Override
    protected SoundEvent getPlaceSound(BlockState state, Level world, BlockPos pos, Player entity) {
        return SoundEvents.ANVIL_LAND;
    }
    public MobEffectInstance getRandomEffect(RandomSource source){
        return effectAbilities[source.nextInt(effectAbilities.length)];
    }
}
