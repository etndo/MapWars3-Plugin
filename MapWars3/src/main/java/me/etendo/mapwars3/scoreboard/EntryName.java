package me.etendo.mapwars3.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {

    ENTRY_0(0, ChatColor.RED.toString()),
    ENTRY_1(1, ChatColor.GREEN.toString()),
    ENTRY_2(2, ChatColor.UNDERLINE.toString()),
    ENTRY_3(3, ChatColor.AQUA.toString()),
    ENTRY_4(4, ChatColor.BLACK.toString()),
    ENTRY_5(5, ChatColor.DARK_AQUA.toString()),
    ENTRY_6(6, ChatColor.DARK_BLUE.toString()),
    ENTRY_7(7, ChatColor.YELLOW.toString()),
    ENTRY_8(8, ChatColor.WHITE.toString()),
    ENTRY_9(9, ChatColor.STRIKETHROUGH.toString()),
    ENTRY_10(10, ChatColor.MAGIC.toString()),
    ENTRY_11(11, ChatColor.DARK_PURPLE.toString());


    private final int entry;
    private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}

