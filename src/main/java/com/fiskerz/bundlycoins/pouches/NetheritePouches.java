package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NetheritePouches {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> SMALLNETHERITEPOUCH = ITEMS.register("small_netherite_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            9,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/small_netherite_pouch_gui.png")));
    public static final DeferredItem<Item> MEDINETHERITEPOUCH = ITEMS.register("medium_netherite_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            12,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/medium_netherite_pouch_gui.png")));
    public static final DeferredItem<Item> BIGNETHERITEPOUCH = ITEMS.register("big_netherite_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            15,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/big_netherite_pouch_gui.png")));
    public static final DeferredItem<Item> LARGENETHERITEPOUCH = ITEMS.register("large_netherite_pouch", () -> new BasicPouchItem(new Item.Properties().stacksTo(1),
            18,
            ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, "textures/gui/pouch/large_netherite_pouch_gui.png")));


    public static void register(IEventBus netheritePouchEventBus) {
        ITEMS.register(netheritePouchEventBus);
    }
}
