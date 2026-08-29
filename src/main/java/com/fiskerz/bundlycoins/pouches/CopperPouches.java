package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CopperPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLCOPPERPOUCH = ITEMS.register("small_copper_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BIGCOPPERPOUCH = ITEMS.register("big_copper_pouch", () -> new Item(new  Item.Properties()));

    public static void register(IEventBus copperPouchEventBus) {
        ITEMS.register(copperPouchEventBus);
    }
}
