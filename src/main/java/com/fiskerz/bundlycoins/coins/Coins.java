package com.fiskerz.bundlycoins.coins;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Coins {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BundlyCoins.MODID);

    public static final DeferredItem<Item> COPPERCOIN = ITEMS.register("copper_coin", () -> new CoinItem(new Item.Properties(), 0.1f));

    public static final DeferredItem<Item> IRONCOIN = ITEMS.register("iron_coin", () -> new CoinItem(new Item.Properties(), 6.4f));

    public static final DeferredItem<Item> GOLDCOIN = ITEMS.register("gold_coin", () -> new CoinItem(new Item.Properties(), 409.6f));

    public static final DeferredItem<Item> DIAMONDCOIN = ITEMS.register("diamond_coin", () -> new CoinItem(new Item.Properties(), 26214.4f));

    public static final DeferredItem<Item> NETHERITECOIN = ITEMS.register("netherite_coin", () -> new CoinItem(new Item.Properties(), 1677721.6f));

    public static void register(IEventBus coinEventBus) {
        ITEMS.register(coinEventBus);
    }
}
