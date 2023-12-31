package com.teampotato.leftclickandshoot.mixin;

import com.teampotato.leftclickandshoot.api.LeftClickUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Player.class)
public class PlayerMixin implements LeftClickUser {

    @Unique
    @Nullable
    protected ItemStack leftClickAndShoot$usingStack = null;

    @Unique
    @Nullable
    protected Item leftClickAndShoot$usingItem = null;

    @Override
    public void leftClickAndShoot$setUsingStack(@Nullable ItemStack itemStack) {
        this.leftClickAndShoot$usingStack = itemStack;
    }

    @Override
    @Nullable
    public ItemStack leftClickAndShoot$getUsingStack() {
        return this.leftClickAndShoot$usingStack;
    }

    @Override
    public void leftClickAndShoot$setUsingItem(@Nullable Item item) {
        this.leftClickAndShoot$usingItem = item;
    }

    @Override
    @Nullable
    public Item leftClickAndShoot$getUsingItem() {
        return this.leftClickAndShoot$usingItem;
    }
}
