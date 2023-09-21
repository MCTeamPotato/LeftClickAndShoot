package com.teampotato.leftclickandshoot.api;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface LeftClickUser {
    void leftClickAndShoot$setUsingStack(ItemStack itemStack);
    ItemStack leftClickAndShoot$getUsingStack();
    void leftClickAndShoot$setUsingItem(Item item);
    Item leftClickAndShoot$getUsingItem();
}
