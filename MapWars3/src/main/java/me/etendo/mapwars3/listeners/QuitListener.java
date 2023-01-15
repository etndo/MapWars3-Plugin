package me.etendo.mapwars3.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.http.WebSocket;

public class QuitListener implements WebSocket.Listener, Listener {
    @Override
    public void onOpen(WebSocket webSocket) {
        WebSocket.Listener.super.onOpen(webSocket);
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.GREEN + player.getName() + " hat MapWars verlassen!");
    }
}
