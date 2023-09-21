package com.teampotato.leftclickandshoot.mixin;

import com.teampotato.leftclickandshoot.api.PlayerTheItemUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Player.class)
public class PlayerMixin implements PlayerTheItemUser {

    @Unique
    @Nullable
    protected ItemStack leftClickAndShoot$usingStack = null;

    @Override
    public void leftClickAndShoot$setUsingStack(@Nullable ItemStack itemStack) {
        this.leftClickAndShoot$usingStack = itemStack;
    }

    @Override
    @Nullable
    public ItemStack leftClickAndShoot$getUsingStack() {
        return this.leftClickAndShoot$usingStack;
    }
}
