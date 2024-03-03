package me.cooleg.cooleggui.inventorytypes;

import me.cooleg.cooleggui.clicktypes.ButtonType;
import me.cooleg.cooleggui.clicktypes.DummyButton;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CustomInventoryBuilder {

    private final HashMap<Integer, ButtonType> buttons = new HashMap<>();
    private Consumer<InventoryOpenEvent> openConsumer = (discard) -> {};
    private Consumer<InventoryCloseEvent> closeConsumer = (discard) -> {};
    private String name;
    private final int size;

    public CustomInventoryBuilder(String name, int size) {
        this.name = name;
        if (size < 0 || size > 54) {throw new RuntimeException("Tried to make inventory with size " + size + " which is not a valid size.");}
        if (size % 9 != 0) {throw new RuntimeException("Tried to make inventory with size " + size + " which is not divisible by 9");}
        this.size = size;
    }

    public CustomInventoryBuilder onOpen(Consumer<InventoryOpenEvent> consumer) {
        this.openConsumer = consumer;
        return this;
    }

    public CustomInventoryBuilder onClose(Consumer<InventoryCloseEvent> consumer) {
        this.closeConsumer = consumer;
        return this;
    }

    public CustomInventoryBuilder button(int slot, ButtonType button) {
        buttons.put(slot, button);
        return this;
    }

    public CustomInventoryBuilder item(int slot, ItemStack item) {
        buttons.put(slot, new DummyButton(item));
        return this;
    }

    public CustomInventoryBuilder filler(ItemStack item) {
        for (int i = 0; i < size; i++) {
            ButtonType type = buttons.get(i);
            if (type == null) {
                buttons.put(i, new DummyButton(item));
            }
        }
        return this;
    }

    public CustomInventoryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public InventoryHandler build() {
        Inventory inventory = Bukkit.createInventory(null, size, name);
        for (Map.Entry<Integer, ButtonType> entries : buttons.entrySet()) {
            inventory.setItem(entries.getKey(), entries.getValue().getItem());
        }

        return new ButtonInventory(buttons, inventory, openConsumer, closeConsumer);
    }

}
