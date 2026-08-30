package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GoldPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLGOLDPOUCH = ITEMS.register("small_gold_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> MEDIGOLDPOUCH = ITEMS.register("medium_gold_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BIGGOLDPOUCH = ITEMS.register("big_gold_pouch", () -> new Item(new  Item.Properties()));

    public static void register(IEventBus goldPouchEventBus) {
        ITEMS.register(goldPouchEventBus);
    }
}
