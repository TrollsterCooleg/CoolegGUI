package me.cooleg.cooleggui.inventorytypes;

import me.cooleg.cooleggui.CurrentInventories;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public abstract class InventoryHandler {

    private final Inventory inventory;

    public InventoryHandler(Inventory inventory) {
        this.inventory = inventory;
    }

    public void onOpen(InventoryOpenEvent event) {}

    public void onClose(InventoryCloseEvent event) {}

    public void onClick(InventoryClickEvent event) {}

    public void openFor(Player player) {
        CurrentInventories.registerHandler(this);
        player.openInventory(inventory);
    }

    /**
     * Returns instance of inventory that backs this handler.
     * Intended for internal use, if you wish to edit an inventory its recommended you do so in onOpen.
     * To show an inventory to a player, use #openFor(Player) or it will not be properly registered.
     * @return Instance of inventory behind this Inventory Handler
     */
    public Inventory getInventory() {
        return inventory;
    }
}
