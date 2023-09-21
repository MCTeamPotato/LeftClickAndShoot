package com.teampotato.leftclickandshoot.mixin;

import com.teampotato.leftclickandshoot.api.PlayerTheBowUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Player.class)
public abstract class PlayerMixin implements PlayerTheBowUser {

    @Unique
    @Nullable
    protected ItemStack leftClickAndShoot$usingBowStack = null;


    @Override
    public void leftClickAndShoot$setUsingBowStack(@Nullable ItemStack itemStack) {
        this.leftClickAndShoot$usingBowStack = itemStack;
    }

    @Override
    @Nullable
    public ItemStack leftClickAndShoot$getUsingBowStack() {
        return this.leftClickAndShoot$usingBowStack;
    }
}
