package com.fiskerz.bundlycoins.pouches;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class PouchContainer extends SimpleContainer {
    public static final int SIZE = 3;

    private final ItemStack pouch;

    public PouchContainer(ItemStack pouch) {
        super(SIZE);
        this.pouch = pouch;
        pouch.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                .copyInto(this.getItems());
    }

    @Override
    public void setChanged() {
        super.setChanged();
        this.pouch.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        // Stops pouch-inside-pouch, which will eat your items.
        return !(stack.getItem() instanceof BasicPouchItem);
    }
}