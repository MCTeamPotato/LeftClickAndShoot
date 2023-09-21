package com.teampotato.leftclickandshoot.api;

import net.minecraft.world.item.ItemStack;

public interface PlayerTheBowUser {
    void leftClickAndShoot$setUsingBowStack(ItemStack itemStack);
    ItemStack leftClickAndShoot$getUsingBowStack();
}
