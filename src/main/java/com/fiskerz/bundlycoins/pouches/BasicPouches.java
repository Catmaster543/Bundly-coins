package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BasicPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLBASICPOUCH = ITEMS.register("small_basic_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BASICPOUCH = ITEMS.register("basic_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BIGBASICPOUCH = ITEMS.register("big_basic_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> HUGEBASICPOUCH = ITEMS.register("huge_basic_pouch", () -> new Item(new  Item.Properties()));

    public static void register(IEventBus basicPouchEventBus) {
        ITEMS.register(basicPouchEventBus);
    }
}
