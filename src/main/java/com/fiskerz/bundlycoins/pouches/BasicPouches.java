package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import com.ibm.icu.util.BuddhistCalendar;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BasicPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLBASICPOUCH = ITEMS.register("small_basic_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            1,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/small_basic_pouch_gui.png")));
    public static final DeferredItem<Item> BASICPOUCH = ITEMS.register("basic_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            2,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/basic_pouch_gui.png")));
    public static final DeferredItem<Item> BIGBASICPOUCH = ITEMS.register("big_basic_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            3,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/big_basic_pouch_gui.png")));
    public static final DeferredItem<Item> HUGEBASICPOUCH = ITEMS.register("huge_basic_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            5,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/huge_basic_pouch_gui.png")));
    public static final DeferredItem<Item> SMALLCOPPERPOUCH = ITEMS.register("small_copper_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            6,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/basic_pouch_gui.png")));
    public static final DeferredItem<Item> BIGCOPPERPOUCH = ITEMS.register("big_copper_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            8,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/basic_pouch_gui.png")));

    public static void register(IEventBus basicPouchEventBus) {
        ITEMS.register(basicPouchEventBus);
    }
}
