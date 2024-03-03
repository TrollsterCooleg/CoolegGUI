package me.cooleg.cooleggui.clicktypes;

import org.bukkit.inventory.ItemStack;

public abstract class ButtonType {

    private final ItemStack item;
    private final Runnable runnable;

    public ButtonType(ItemStack item, Runnable runnable) {
        this.item = item;
        this.runnable = runnable;
    }

    public ItemStack getItem() {
        return item;
    }

    public void buttonPress() {
        runnable.run();
    }


}
