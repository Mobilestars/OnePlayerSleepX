package de.scholle.oneplayersleepx;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class OnePlayerSleepX extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        boolean enabled = config.getBoolean("enabled", true);

        for (World world : Bukkit.getWorlds()) {
            if (enabled) {
                world.setGameRuleValue("playersSleepingPercentage", "0");
                getLogger().info("OnePlayerSleepX enabled: Only one player must sleep in world " + world.getName());
            } else {
                world.setGameRuleValue("playersSleepingPercentage", "100");
                getLogger().info("OnePlayerSleepX disabled: All players must sleep in world " + world.getName());
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("OnePlayerSleepX has been disabled.");
    }
}
