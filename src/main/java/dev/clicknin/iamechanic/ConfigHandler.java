package dev.clicknin.iamechanic;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class ConfigHandler {
    public static HashMap smelt = new HashMap();

    public static YamlConfiguration getConfig(String name) {
        File file = new File(Main.plugin.getDataFolder(), name);
        if (!file.exists()) {
            Main.plugin.saveResource(name, false);
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void loadConfig() {
        //Smelt behavior config
        FileConfiguration smeltConfig = getConfig("smelt.yml");
        smelt.clear();
        smeltConfig.getConfigurationSection("").getKeys(false).forEach((key) -> {
            smelt.put(key, new Smelt(smeltConfig.getInt("burn_time"), smeltConfig.getString("replacement_item")));
        });
    }
}
