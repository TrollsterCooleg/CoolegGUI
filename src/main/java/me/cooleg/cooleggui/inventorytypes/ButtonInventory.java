package me.cooleg.cooleggui.inventorytypes;

import me.cooleg.cooleggui.CurrentInventories;
import me.cooleg.cooleggui.clicktypes.ButtonType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ButtonInventory extends InventoryHandler {

    private final HashMap<Integer, ButtonType> buttons;
    public final Consumer<InventoryOpenEvent> inventoryOpen;
    public final Consumer<InventoryCloseEvent> inventoryClose;
    private final int slotCount;
    private final String name;

    public ButtonInventory(HashMap<Integer, ButtonType> buttons, int size, String name,
                           Consumer<InventoryOpenEvent> inventoryOpen, Consumer<InventoryCloseEvent> inventoryClose) {
        this.buttons = buttons;
        this.inventoryOpen = inventoryOpen;
        this.inventoryClose = inventoryClose;
        this.name = name;
        slotCount = size;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        int clickedSlot = event.getSlot();
        if (clickedSlot < 0 || clickedSlot >= slotCount) {return;}

        ButtonType type = buttons.get(clickedSlot);
        if (type == null) {return;}
        type.buttonPress(event);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        inventoryOpen.accept(event);
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        inventoryClose.accept(event);
    }

    @Override
    public void openFor(Player player) {
        Inventory inventory = Bukkit.createInventory(null, slotCount, name);
        for (Map.Entry<Integer, ButtonType> entries : buttons.entrySet()) {
            inventory.setItem(entries.getKey(), entries.getValue().getItem());
        }

        CurrentInventories.registerHandler(inventory, this);
        player.openInventory(inventory);
    }
}
