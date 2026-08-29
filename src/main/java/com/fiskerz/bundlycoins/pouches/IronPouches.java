package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IronPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLIRONPOUCH = ITEMS.register("small_iron_pouch", () -> new Item(new  Item.Properties()));
    public static final DeferredItem<Item> BIGIRONPOUCH = ITEMS.register("big_iron_pouch", () -> new Item(new  Item.Properties()));

    public static void register(IEventBus ironPouchEventBus) {
        ITEMS.register(ironPouchEventBus);
    }
}
