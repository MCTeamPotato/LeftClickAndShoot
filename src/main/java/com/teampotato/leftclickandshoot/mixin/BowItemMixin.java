package com.teampotato.leftclickandshoot.mixin;

import com.teampotato.leftclickandshoot.api.PlayerTheBowUser;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @Inject(method = "releaseUsing", at = @At("HEAD"), cancellable = true)
    private void disableVanillaLogic(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft, CallbackInfo ci) {
        if (pEntityLiving instanceof Player player) {
            if (((PlayerTheBowUser)player).leftClickAndShoot$getUsingBowStack() == null) ci.cancel();
        }
    }
}