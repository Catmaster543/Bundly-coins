package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GoldPouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLGOLDPOUCH = ITEMS.register("small_gold_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            9,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/small_gold_pouch_gui.png")));
    public static final DeferredItem<Item> MEDIGOLDPOUCH = ITEMS.register("medium_gold_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            12,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/medium_gold_pouch_gui.png")));
    public static final DeferredItem<Item> BIGGOLDPOUCH = ITEMS.register("big_gold_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            15,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/big_gold_pouch_gui.png")));

    public static void register(IEventBus goldPouchEventBus) {
        ITEMS.register(goldPouchEventBus);
    }
}
