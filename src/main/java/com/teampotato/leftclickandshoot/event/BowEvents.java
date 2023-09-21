package com.teampotato.leftclickandshoot.event;

import com.teampotato.leftclickandshoot.api.PlayerTheBowUser;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

public class BowEvents {
    @SubscribeEvent
    public static void onLeftClickItem(PlayerInteractEvent.@NotNull LeftClickEmpty event) {
        ItemStack itemStack = event.getItemStack();
        if (itemStack.getItem() instanceof BowItem && !itemStack.isEmpty()) {
            PlayerTheBowUser player = ((PlayerTheBowUser) ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(event.getEntity().getUUID()));
            if (player != null) player.leftClickAndShoot$setUsingBowStack(itemStack);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.@NotNull PlayerTickEvent event) {
        Player player = event.player;
        PlayerTheBowUser iPlayer = ((PlayerTheBowUser)player);
        ItemStack itemStack = iPlayer.leftClickAndShoot$getUsingBowStack();
        if (itemStack != null) {
            itemStack.releaseUsing(player.level, player, 0);
            iPlayer.leftClickAndShoot$setUsingBowStack(null);
        }
    }
}
