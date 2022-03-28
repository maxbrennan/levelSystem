package com.max.levelsystem;

import com.max.levelsystem.commands.LevelCommand;
import com.max.levelsystem.commands.LevelTab;
import com.max.levelsystem.listeners.PlayerJoin;
import com.max.levelsystem.playerdata.Database;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class LevelSystem extends JavaPlugin {

    public boolean level;
    public Database database = new Database();

    @Override
    public void onEnable() {
        System.out.println(Color.GREEN + "===========================================");
        System.out.println(Color.GREEN + "|                                         |");
        System.out.println(Color.GREEN + "|          Level system started!          |");
        System.out.println(Color.GREEN + "|                                         |");
        System.out.println(Color.GREEN + "===========================================");

        // CONFIG
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        level = getConfig().getBoolean("plugin-enabled");

        // COMMANDS
        getCommand("level").setExecutor(new LevelCommand(this));
        getCommand("level").setTabCompleter(new LevelTab());

        // DATABASE
        database.connect();

        // EVENTS
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println(Color.RED + "===========================================");
        System.out.println(Color.RED + "|                                         |");
        System.out.println(Color.RED + "|           Level system ended!           |");
        System.out.println(Color.RED + "|                                         |");
        System.out.println(Color.RED + "===========================================");

        // CONFIG
        getConfig().set("plugin-enabled", level);
        saveConfig();
    }

    public Database getDatabase() { return database; }

}
