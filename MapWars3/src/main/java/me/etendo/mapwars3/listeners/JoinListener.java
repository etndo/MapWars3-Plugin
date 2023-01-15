package me.etendo.mapwars3.listeners;

import me.etendo.mapwars3.scoreboard.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.http.WebSocket;
import java.util.Set;

public class JoinListener implements WebSocket.Listener, Listener {
    @Override
    public void onOpen(WebSocket webSocket) { WebSocket.Listener.super.onOpen(webSocket); }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.GREEN + player.getName() + " hat MapWars betreten!" );
        player.sendMessage( ChatColor.DARK_GREEN + "Wilkommen in MapWars 3, " + player.getName() + "!");

        new Scoreboard(player);
    }
}
