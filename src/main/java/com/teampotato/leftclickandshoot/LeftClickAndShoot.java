package com.teampotato.leftclickandshoot;

import com.teampotato.leftclickandshoot.event.BowEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(LeftClickAndShoot.MOD_ID)
public class LeftClickAndShoot {
    public static final String MOD_ID = "leftclickandshoot";

    public LeftClickAndShoot() {
        MinecraftForge.EVENT_BUS.register(BowEvents.class);
    }
}
