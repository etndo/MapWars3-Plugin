package me.etendo.mapwars3.scoreboard;

import me.etendo.mapwars3.main;
import me.etendo.mapwars3.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Time;

public class Scoreboard extends ScoreboardBuilder {


    public Scoreboard(Player player) {
        super(player, ChatColor.GOLD.toString() + ChatColor.BOLD + "MapWars " + ChatColor.WHITE + ChatColor.BOLD + "3");

        run();
    }

    @Override
    public void createScoreboard(Player player) {

        setScore(ChatColor.RED.toString() + "Der Tag ist vorbei...", 0);
        setScore(ChatColor.GREEN.toString() + "Deine Leben:" , 1);
        setScore(ChatColor.DARK_GRAY.toString() + "Wilkommen, " + ChatColor.WHITE.toString() + player.getName() + ChatColor.DARK_GRAY.toString() +  " !" , 2);

    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                if (!Timer.isRunning()) {
                    setScore(ChatColor.RED.toString() + "Der Tag ist vorbei...", 0);
                } else {

                    if (Timer.getTime() < 60) {
                        setScore(ChatColor.DARK_RED.toString() + "Tagesende: " + Timer.getTime() + "S", 0);
                    } else {
                        setScore(ChatColor.DARK_GRAY.toString() + "Tagesende: " + Timer.getTime() / 60 + "M", 0);
                    }
                }

                if(true) {
                    setScore(ChatColor.GREEN.toString() + "Deine Leben: " + ChatColor.RED.toString() + "❤❤", 1);
                }
                if(true) {
                    setScore(ChatColor.GREEN.toString() + "Deine Leben: " + ChatColor.RED.toString() + "❤" + ChatColor.DARK_GRAY.toString() + "❤" , 1);
                }
                if(true) {
                    setScore(ChatColor.GREEN.toString() + "Deine Leben: " + ChatColor.DARK_GRAY.toString() + "❤❤" , 1);
                }
            }
        }.runTaskTimer(main.getInstance(),20 , 20);
    }
}
