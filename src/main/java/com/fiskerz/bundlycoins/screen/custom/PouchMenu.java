package com.fiskerz.bundlycoins.screen.custom;

import com.fiskerz.bundlycoins.pouches.PouchContainer;
import com.fiskerz.bundlycoins.screen.ModMenuTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class PouchMenu extends AbstractContainerMenu {

    public static final int POUCH_SLOT_COUNT = PouchContainer.SIZE;

    private static final int VANILLA_SLOT_COUNT = 36; // 27 inventory + 9 hotbar
    private static final int POUCH_FIRST_SLOT = 0;
    private static final int VANILLA_FIRST_SLOT = POUCH_SLOT_COUNT;

    private final Container pouchContainer;

    // Client-side constructor — this is the one ModMenuTypes uses.
    public PouchMenu(int containerId, Inventory playerInventory, RegistryFriendlyByteBuf extraData) {
        this(containerId, playerInventory, new SimpleContainer(POUCH_SLOT_COUNT));
    }

    // Server-side constructor.
    public PouchMenu(int containerId, Inventory playerInventory, Container pouchContainer) {
        super(ModMenuTypes.POUCH_MENU.get(), containerId);
        checkContainerSize(pouchContainer, POUCH_SLOT_COUNT);
        this.pouchContainer = pouchContainer;
        pouchContainer.startOpen(playerInventory.player);

        // Pouch slots first, so they occupy indices 0..2 — centred on a 176px wide GUI.
        for (int col = 0; col < POUCH_SLOT_COUNT; col++) {
            this.addSlot(new Slot(pouchContainer, col, 61 + col * 18, 35));
        }

        // Player inventory, 3 rows of 9.
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar.
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = this.slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSource = sourceStack.copy();

        if (index < POUCH_SLOT_COUNT) {
            // Pouch -> player
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT, VANILLA_FIRST_SLOT + VANILLA_SLOT_COUNT, true)) {
                return ItemStack.EMPTY;
            }
        } else if (index < VANILLA_FIRST_SLOT + VANILLA_SLOT_COUNT) {
            // Player -> pouch
            if (!moveItemStackTo(sourceStack, POUCH_FIRST_SLOT, POUCH_FIRST_SLOT + POUCH_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(player, sourceStack);
        return copyOfSource;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.pouchContainer.stillValid(player);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.pouchContainer.stopOpen(player);
    }
}