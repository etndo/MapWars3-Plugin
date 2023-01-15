package me.etendo.mapwars3.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.net.http.WebSocket;

public class DeathListener implements WebSocket.Listener, Listener {
    @Override
    public void onOpen(WebSocket webSocket) { WebSocket.Listener.super.onOpen(webSocket); }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();

        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage( ChatColor.RED + "Da du gestorben bist, wurdest du in den Beobachter-Modus gesetzt.");
    }
}
