package me.lyamray.trickortreat.modules.utils;
import org.bukkit.ChatColor;

/**
 * This class provides utility methods for handling color codes in chat messages.
 */
public class Colors {
    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
