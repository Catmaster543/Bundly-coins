package com.fiskerz.bundlycoins.coins;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Coins {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> COPPERCOIN = ITEMS.register("copper_coin", () -> new CoinItem(new Item.Properties(), 0.015625f));

    public static final DeferredItem<Item> IRONCOIN = ITEMS.register("iron_coin", () -> new CoinItem(new Item.Properties(), 1f));

    public static final DeferredItem<Item> GOLDCOIN = ITEMS.register("gold_coin", () -> new CoinItem(new Item.Properties(), 64f));

    public static final DeferredItem<Item> DIAMONDCOIN = ITEMS.register("diamond_coin", () -> new CoinItem(new Item.Properties(), 4096f));

    public static final DeferredItem<Item> NETHERITECOIN = ITEMS.register("netherite_coin", () -> new CoinItem(new Item.Properties(), 262144f));

    public static void register(IEventBus coinEventBus) {
        ITEMS.register(coinEventBus);
    }
}
