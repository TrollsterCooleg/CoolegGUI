package me.cooleg.cooleggui.clicktypes;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class ActiveButton extends ButtonType {
    public ActiveButton(ItemStack item, Consumer<InventoryClickEvent> consumer) {
        super(item, consumer);
    }
}
