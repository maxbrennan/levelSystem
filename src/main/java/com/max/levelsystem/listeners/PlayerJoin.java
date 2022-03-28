package com.max.levelsystem.listeners;

import com.max.levelsystem.LevelSystem;
import com.max.levelsystem.playerdata.CustomPlayer;
import com.max.levelsystem.playerdata.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    LevelSystem plugin;
    PlayerManager manager;
    public PlayerJoin(LevelSystem plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        CustomPlayer cp = new CustomPlayer(plugin, uuid);
        manager.addCustomPlayer(uuid, cp);
    }

}
