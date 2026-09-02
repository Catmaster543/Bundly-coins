package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.screen.custom.PouchMenu;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BasicPouchItem extends Item {
    public BasicPouchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Menus are opened server-side only; the server syncs the GUI to the client.
        if (!level.isClientSide()) {
            PouchContainer contents = new PouchContainer(stack);
            player.openMenu(new SimpleMenuProvider(
                    (containerId, inv, p) -> new PouchMenu(containerId, inv, contents),
                    stack.getHoverName()
            ));
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}