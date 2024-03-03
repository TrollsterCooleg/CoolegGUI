package me.cooleg.cooleggui.clicktypes;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public abstract class ButtonType {
    private final ItemStack item;
    private final Consumer<InventoryClickEvent> consumer;

    public ButtonType(ItemStack item, Consumer<InventoryClickEvent> consumer) {
        this.item = item;
        this.consumer = consumer;
    }

    public ItemStack getItem() {
        return item;
    }

    public void buttonPress(InventoryClickEvent event) {
        consumer.accept(event);
    }

    public boolean isTakeable() {
        return false;
    }
}
