package com.fiskerz.bundlycoins.pouches;

import com.fiskerz.bundlycoins.screen.custom.PouchMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
}