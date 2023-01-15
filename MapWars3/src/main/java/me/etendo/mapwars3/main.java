package me.etendo.mapwars3;

import me.etendo.mapwars3.commands.TimerCommands;
import me.etendo.mapwars3.listeners.DeathListener;
import me.etendo.mapwars3.listeners.JoinListener;
import me.etendo.mapwars3.listeners.QuitListener;
import me.etendo.mapwars3.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    private static main instance;

    private Timer timer;
    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(),  this);
        manager.registerEvents(new QuitListener(),  this);
        manager.registerEvents(new DeathListener(),  this);

        getCommand("timer").setExecutor( new TimerCommands());
        timer = new Timer(false,0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}
