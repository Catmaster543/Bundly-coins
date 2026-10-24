package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.coins.CoinItem;
import com.fiskerz.bundlycoins.screen.custom.PouchMenu;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BasicPouchItem extends Item {
    private final int size;
    private final ResourceLocation texture;

    public BasicPouchItem(Properties properties, int size, ResourceLocation texture) {
        super(properties);
        this.size = size;
        this.texture = texture;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Menus are opened server-side only; the server syncs the GUI to the client.
        if (!level.isClientSide()) {
            PouchContainer contents = new PouchContainer(stack, this.size);
            player.openMenu(new SimpleMenuProvider(
                    (containerId, inv, p) -> new PouchMenu(containerId, inv, contents, this.texture),
                    stack.getHoverName()
            ), buf -> {buf.writeVarInt(this.size); buf.writeResourceLocation(this.texture);});
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        float finalValue = 0f;
        ItemContainerContents contents = stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);

        for (ItemStack inner : contents.nonEmptyItems()) {
            if (inner.getItem() instanceof CoinItem coin) {
                finalValue += coin.getMultiplier() * inner.getCount();
            }
        }
        BigDecimal bd = new BigDecimal(Double.toString(finalValue));
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        tooltipComponents.add(Component.literal("§6§l" + bd + "C"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}