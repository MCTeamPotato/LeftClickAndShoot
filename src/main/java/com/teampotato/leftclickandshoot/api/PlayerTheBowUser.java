package com.teampotato.leftclickandshoot.api;

import net.minecraft.world.item.ItemStack;

public interface PlayerTheBowUser {
    void leftClickAndShoot$setUsingStack(ItemStack itemStack);
    ItemStack leftClickAndShoot$getUsingStack();
}
