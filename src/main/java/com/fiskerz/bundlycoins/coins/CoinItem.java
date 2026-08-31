package com.fiskerz.bundlycoins.coins;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CoinItem extends Item {
    private final float multiplier;

    public CoinItem(Properties properties, float multiplier) {
        super(properties);
        this.multiplier = multiplier;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        float value = stack.getCount() * multiplier;
        tooltipComponents.add(Component.literal("§6§l" + value + "C"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
