package com.max.levelsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelTab implements TabCompleter {

    List<String> pos = new ArrayList<>();
    List<String> arg0 = Arrays.asList("enable", "disable");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        pos.clear();
        if (!(sender instanceof Player)) {
            return null;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("levelsystem.commands.level")) {
            return null;
        }
        if (!args[0].equals("")) {
            for (String s : arg0) {
                if (s.startsWith(args[0])) {
                    pos.add(s);
                }
            }
        }
        return pos;
    }

}
