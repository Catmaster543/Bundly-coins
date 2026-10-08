package com.fiskerz.bundlycoins.screen.custom;

import com.fiskerz.bundlycoins.pouches.PouchContainer;
import com.fiskerz.bundlycoins.screen.ModMenuTypes;
import com.fiskerz.bundlycoins.util.ModTags;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class PouchMenu extends AbstractContainerMenu {


    public static final int POUCH_SLOT_COUNT = PouchContainer.size;

    private final int pouchSlots;
    private final Container pouchContainer;
    private final ResourceLocation texture;

    // Client-side constructor — this is the one ModMenuTypes uses.
    public PouchMenu(int containerId, Inventory inv, RegistryFriendlyByteBuf extraData) {
        this(containerId, inv, new SimpleContainer(extraData.readVarInt()), extraData.readResourceLocation());
    }

    // Server-side constructor.
    public PouchMenu(int containerId, Inventory playerInventory, Container pouchContainer, ResourceLocation texture) {
        super(ModMenuTypes.POUCH_MENU.get(), containerId);
        checkContainerSize(pouchContainer, POUCH_SLOT_COUNT);
        this.pouchContainer = pouchContainer;
        this.texture = texture;
        this.pouchSlots = pouchContainer.getContainerSize();

        pouchContainer.startOpen(playerInventory.player);

        int size = pouchContainer.getContainerSize();
        int rows = (size + 8) / 9;        // ceiling division
        int slotIndex = 0;
        int firstRowY = (rows == 1) ? 35 : 18;

        for (int row = 0; row < rows; row++) {
            int slotsInRow = Math.min(9, size - row * 9);
            int rowStartX = (176 - slotsInRow * 18) / 2;

            for (int col = 0; col < slotsInRow; col++) {
                this.addSlot(new TagSlot(pouchContainer, slotIndex++, rowStartX + col * 18, firstRowY + row * 18));
            }
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

    public ResourceLocation getTexture() {
        return this.texture;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = this.slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSource = sourceStack.copy();

        int vanillaFirst = this.pouchSlots;
        int vanillaEnd = vanillaFirst + 36;

        if (index < this.pouchSlots) {
            // pouch -> player
            if (!moveItemStackTo(sourceStack, vanillaFirst, vanillaEnd, true)) {
                return ItemStack.EMPTY;
            }
        } else if (index < vanillaEnd) {
            // player -> pouch
            if (!moveItemStackTo(sourceStack, 0, this.pouchSlots, false)) {
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

    public static class TagSlot extends Slot {
        TagSlot(Container inventory, int index, int xPosition, int yPosition) {
            super(inventory, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return stack.is(ModTags.Items.COINS);
        }
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