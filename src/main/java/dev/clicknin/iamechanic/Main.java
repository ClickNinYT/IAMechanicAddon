package dev.clicknin.iamechanic;

import dev.clicknin.iamechanic.listener.SmeltListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ConfigHandler.loadConfig();
        getServer().getPluginManager().registerEvents(new SmeltListener(), this);
    }
}