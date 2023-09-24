package com.teampotato.leftclickandshoot.event;

import com.teampotato.leftclickandshoot.api.LeftClickUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

public class EventHandler {
    @SubscribeEvent
    public static void onLeftClickItem(PlayerInteractEvent.@NotNull LeftClickEmpty event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        if (item instanceof ProjectileWeaponItem) {
            //This event is clientside only, so we need to get the player on the server.
            LeftClickUser player = (LeftClickUser) ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(event.getEntity().getUUID());
            if (player != null) {
                player.leftClickAndShoot$setUsingStack(itemStack);
                player.leftClickAndShoot$setUsingItem(item);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.@NotNull PlayerTickEvent event) {
        Player player = event.player;
        LeftClickUser iPlayer = ((LeftClickUser)player);
        ItemStack itemStack = iPlayer.leftClickAndShoot$getUsingStack();
        Item item = iPlayer.leftClickAndShoot$getUsingItem();
        if (itemStack != null && item != null) {
            item.releaseUsing(itemStack, player.level, player, 0);
            iPlayer.leftClickAndShoot$setUsingStack(null);
        }
    }
}
