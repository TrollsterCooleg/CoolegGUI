package me.cooleg.cooleggui.inventorytypes;

import me.cooleg.cooleggui.CurrentInventories;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public abstract class InventoryHandler {

    public void onOpen(InventoryOpenEvent event) {}

    public void onClose(InventoryCloseEvent event) {}

    public void onClick(InventoryClickEvent event, boolean clickedGUI) {}

    /**
     * Make sure to make it register the listener with {@link CurrentInventories#registerHandler(Inventory, InventoryHandler)}
     * @param player Player to open inventory for
     */
    public abstract void openFor(Player player);

}
