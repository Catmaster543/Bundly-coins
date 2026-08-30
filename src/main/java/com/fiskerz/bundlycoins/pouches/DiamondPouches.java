package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DiamondPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLDIAMONDPOUCH = ITEMS.register("small_diamond_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> MEDIDIAMONDPOUCH = ITEMS.register("medium_diamond_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BIGDIAMONDPOUCH = ITEMS.register("big_diamond_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> HUGEDIAMONDPOUCH = ITEMS.register("huge_diamond_pouch", () -> new Item(new  Item.Properties()));

    public static void register(IEventBus diamondPouchEventBus) {
        ITEMS.register(diamondPouchEventBus);
    }
}
