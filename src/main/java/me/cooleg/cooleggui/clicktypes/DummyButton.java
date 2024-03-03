package me.cooleg.cooleggui.clicktypes;

import org.bukkit.inventory.ItemStack;

public class DummyButton extends ButtonType{
    public DummyButton(ItemStack item) {
        super(item, (event) -> {});
    }
}
