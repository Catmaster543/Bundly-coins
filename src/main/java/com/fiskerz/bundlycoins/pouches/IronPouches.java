package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IronPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLIRONPOUCH = ITEMS.register("small_iron_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            9,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/small_iron_pouch_gui.png")));
    public static final DeferredItem<Item> BIGIRONPOUCH = ITEMS.register("big_iron_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            12,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/big_iron_pouch_gui.png")));

    public static void register(IEventBus ironPouchEventBus) {
        ITEMS.register(ironPouchEventBus);
    }
}
