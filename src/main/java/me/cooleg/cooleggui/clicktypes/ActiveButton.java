package me.cooleg.cooleggui.clicktypes;

import org.bukkit.inventory.ItemStack;

public class ActiveButton extends ButtonType {
    public ActiveButton(ItemStack item, Runnable runnable) {
        super(item, runnable);
    }
}
