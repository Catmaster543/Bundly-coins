package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DiamondPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLDIAMONDPOUCH = ITEMS.register("small_diamond_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            9,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/small_diamond_pouch_gui.png")));
    public static final DeferredItem<Item> MEDIDIAMONDPOUCH = ITEMS.register("medium_diamond_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            12,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/medium_diamond_pouch_gui.png")));
    public static final DeferredItem<Item> BIGDIAMONDPOUCH = ITEMS.register("big_diamond_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            15,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/big_diamond_pouch_gui.png")));
    public static final DeferredItem<Item> LARGEDIAMONDPOUCH = ITEMS.register("large_diamond_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            18,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/large_diamond_pouch_gui.png")));

    public static void register(IEventBus diamondPouchEventBus) {
        ITEMS.register(diamondPouchEventBus);
    }
}
