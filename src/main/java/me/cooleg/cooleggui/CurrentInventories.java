package me.cooleg.cooleggui;

import me.cooleg.cooleggui.inventorytypes.InventoryHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class CurrentInventories implements Listener {

    private static final HashMap<Inventory, InventoryHandler> inventoryHandlers = new HashMap<>();

    @EventHandler
    public void inventoryOpen(InventoryOpenEvent event) {
        InventoryHandler handler = inventoryHandlers.get(event.getInventory());
        if (handler == null) {return;}
        handler.onOpen(event);
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event) {
        InventoryHandler handler = inventoryHandlers.get(event.getInventory());
        if (handler == null) {return;}
        handler.onClose(event);

        unregisterHandler(handler);
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        InventoryHandler handler = inventoryHandlers.get(event.getInventory());
        if (handler == null) {return;}
        handler.onClick(event);
    }

    public static void registerHandler(InventoryHandler handler) {
        inventoryHandlers.put(handler.getInventory(), handler);
    }

    public static void unregisterHandler(InventoryHandler handler) {
        inventoryHandlers.remove(handler.getInventory());
    }


}
