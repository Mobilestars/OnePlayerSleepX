package de.scholle.oneplayersleepx;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnePlayerSleepX extends JavaPlugin implements TabExecutor {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        applyConfig();
        getCommand("oneplayersleep").setExecutor(this);
        getCommand("oneplayersleep").setTabCompleter(this);
        getLogger().info("OnePlayerSleepX wurde aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info("OnePlayerSleepX wurde deaktiviert.");
    }

    private void applyConfig() {
        FileConfiguration config = getConfig();
        boolean enabled = config.getBoolean("enabled", true);

        for (World world : Bukkit.getWorlds()) {
            if (enabled) {
                world.setGameRuleValue("playersSleepingPercentage", "0");
                getLogger().info("OnePlayerSleepX aktiviert: Nur ein Spieler muss schlafen in Welt " + world.getName());
            } else {
                world.setGameRuleValue("playersSleepingPercentage", "100");
                getLogger().info("OnePlayerSleepX deaktiviert: Alle Spieler müssen schlafen in Welt " + world.getName());
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§eVerwendung: /oneplayersleep <enable|disable|e|d>");
            return true;
        }

        String arg = args[0].toLowerCase();
        boolean enable;

        if (arg.equals("enable") || arg.equals("e")) {
            enable = true;
        } else if (arg.equals("disable") || arg.equals("d")) {
            enable = false;
        } else {
            sender.sendMessage("§cUngültiges Argument! Verwende: enable/disable oder e/d");
            return true;
        }

        getConfig().set("enabled", enable);
        saveConfig();

        applyConfig();

        sender.sendMessage("§aOnePlayerSleepX wurde " + (enable ? "§aaktiviert" : "§cdeaktiviert") + "§a!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> options = Arrays.asList("enable", "disable", "e", "d");
            List<String> result = new ArrayList<>();
            for (String option : options) {
                if (option.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(option);
                }
            }
            return result;
        }
        return null;
    }
}
