package me.etendo.mapwars3.timer;

import me.etendo.mapwars3.main;
import me.etendo.mapwars3.scoreboard.Scoreboard;
import me.etendo.mapwars3.scoreboard.ScoreboardBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private static boolean running;
    private static int time;

    public Timer(boolean running, int time) {
        this.time = time;
        this.running = running;

        Run();
    }

    public static boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private void Run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!isRunning()) {
                    return;
                }
                setTime(getTime() - 1);
                if(getTime() < 1){
                    setRunning(false);
                }
            }
        }.runTaskTimer(main.getInstance(),20 , 20);
    }
}
