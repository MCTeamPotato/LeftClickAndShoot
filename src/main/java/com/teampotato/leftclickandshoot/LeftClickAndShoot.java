package com.teampotato.leftclickandshoot;

import com.teampotato.leftclickandshoot.event.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(LeftClickAndShoot.MOD_ID)
public class LeftClickAndShoot {
    public static final String MOD_ID = "leftclickandshoot";

    public LeftClickAndShoot() {
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }
}
