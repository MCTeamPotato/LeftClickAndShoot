package com.teampotato.leftclickandshoot.mixin;

import com.teampotato.leftclickandshoot.api.LeftClickUser;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract Item getItem();

    @Inject(method = "releaseUsing", at = @At("HEAD"), cancellable = true)
    private void disableVanillaLogic(Level pLevel, LivingEntity pLivingEntity, int pTimeLeft, CallbackInfo ci) {
        if (pLivingEntity instanceof Player player && !(this.getItem() instanceof TridentItem) && ((LeftClickUser)player).leftClickAndShoot$getUsingStack() == null) {
            ci.cancel();
        }
    }
}
