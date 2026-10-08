package com.fiskerz.bundlycoins.util;

import com.fiskerz.bundlycoins.BundlyCoins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> COINS = createTag("coins");
        private static final TagKey<Item> POUCHES = createTag("pouches");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BundlyCoins.MODID, name));
        }
    }
}
