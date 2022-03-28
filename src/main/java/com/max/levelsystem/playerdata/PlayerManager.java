package com.max.levelsystem.playerdata;

import com.max.levelsystem.LevelSystem;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    HashMap<UUID, CustomPlayer> map = new HashMap<>();

    public void addCustomPlayer(UUID uuid, CustomPlayer player) {
        map.put(uuid, player);
    }

    public CustomPlayer getCustomPlayer(UUID uuid) {
        return map.get(uuid);
    }

}
