package com.max.levelsystem.playerdata;

import com.max.levelsystem.LevelSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {

    LevelSystem plugin;
    PlayerManager manager = new PlayerManager();
    UUID uuid;
    int xp;
    PreparedStatement ps;
    ResultSet rs;

    public CustomPlayer(LevelSystem plugin, UUID uuid) {
        this.plugin = plugin;

        // GETS PLAYER UUID
        this.uuid = uuid;

        try {
            ps = plugin.getDatabase().getConnection().prepareStatement(
                    "SELECT XP FROM players WHERE UUID = '" + uuid + "';");
            rs = ps.executeQuery();
            if (rs.next()) {

                // GETS PLAYER XP
                xp = rs.getInt("XP");

            } else {

                // REGISTERS NEW PLAYER
                xp = 0;
                ps = plugin.getDatabase().getConnection().prepareStatement(
                        "INSERT INTO players (ID, UUID, XP) VALUES (" + "default,'" + uuid + "'," + xp + ");");
                ps.executeUpdate();

            }
            manager.addCustomPlayer(uuid, this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setXp(int amount) {
        try {
            xp = amount;
            ps = plugin.getDatabase().getConnection().prepareStatement(
                    "UPDATE players SET XP = " + amount + "WHERE UUID = '" + uuid + "';");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getXp() { return xp; }

}
