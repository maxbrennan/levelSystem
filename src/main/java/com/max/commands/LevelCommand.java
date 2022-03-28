package com.max.levelsystem.commands;

import com.max.levelsystem.LevelSystem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Arrays;
import java.lang.String;
import java.util.List;

public class LevelCommand implements CommandExecutor {

    void red(Player player, String message) {
        player.sendMessage(ChatColor.RED + message);
    }
    void green(Player player, String message) {
        player.sendMessage(ChatColor.RED + message);
    }
    List<String> arg0 = Arrays.asList("enable", "disable");
    LevelSystem main;
    public LevelCommand(LevelSystem main) { this.main = main; }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println(Color.RED + "Only players can do that!");
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("levelsystem.commands.level")) {
            red(player, "You can't do that!");
            return false;
        }
        if (args.length != 1 || !arg0.contains(args[0])) {
            red(player, "Usage: /level <enable/disable>");
            return false;
        }
        if (args[0].equals("enable")) {
            main.level = true;
            green(player, "Level system enabled");
            return false;
        }
        if (args[0].equals("disable")) {
            green(player, "Level system disabled");
            return false;
        }
        return false;
    }

}
