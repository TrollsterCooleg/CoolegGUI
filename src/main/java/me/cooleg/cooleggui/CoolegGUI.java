package me.cooleg.cooleggui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoolegGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new CurrentInventories(), this);
    }

}
