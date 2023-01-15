package me.etendo.mapwars3.commands;

import me.etendo.mapwars3.main;
import me.etendo.mapwars3.timer.Timer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.DARK_GREEN + "Verwendung: /timer (time <Zeit> | pause | resume | reset)");
            return false;
        }

        switch (args[0].toLowerCase()) {

            case "time": {
                if (args.length != 2) {
                    sender.sendMessage(ChatColor.DARK_GREEN + "Verwendung: /timer (time <Zeit> | pause | resume | reset)");
                    break;
                }

                try {
                    Timer timer = main.getInstance().getTimer();
                    timer.setRunning(true);
                    timer.setTime(Integer.parseInt(args[1]) * 60);
                    sender.sendMessage(ChatColor.GREEN + "Der Timer wurde auf " + (args[1] + " Minuten gesetzt."));
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.DARK_GREEN + "Verwendung: /timer (time <Zeit> | pause | resume | reset)");
                }
                break;
            }

            case "pause": {

                Timer timer = main.getInstance().getTimer();

                if (!timer.isRunning()) {
                    sender.sendMessage(ChatColor.DARK_GREEN + "Der Timer läuft nicht.");
                    break;
                }

                timer.setRunning(false);
                sender.sendMessage(ChatColor.GREEN + "Der Timer wurde pausiert.");
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent
                            (ChatColor.RED.toString() + ChatColor.BOLD + "Der Timer wurde pausiert."));
                }
                break;
            }

            case "resume": {

                Timer timer = main.getInstance().getTimer();

                if (timer.isRunning()) {
                    sender.sendMessage(ChatColor.DARK_GREEN + "Der Timer läuft bereits.");
                    break;
                }

                timer.setRunning(true);
                sender.sendMessage(ChatColor.GREEN + "Der Timer wurde fortgesetzt.");
                break;
            }

            case "reset": {

                Timer timer = main.getInstance().getTimer();

                timer.setRunning(false);
                timer.setTime(0);
                sender.sendMessage(ChatColor.GREEN + "Der Timer wurde zurückgesetzt.");
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent
                            (ChatColor.RED.toString() + ChatColor.BOLD + "Der Timer wurde zurückgesetzt."));
                }
                break;
            }

            default:
                sender.sendMessage(ChatColor.DARK_GREEN + "Verwendung: /timer (time <Zeit> | pause | resume | reset)");
                break;
        }
        return false;

    }
}
