package com.fiskerz.bundlycoins.screen;

import com.fiskerz.bundlycoins.BundlyCoins;
import com.fiskerz.bundlycoins.screen.custom.PouchScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = BundlyCoins.MODID, value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void register(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.POUCH_MENU.get(), PouchScreen::new);
    }
}
