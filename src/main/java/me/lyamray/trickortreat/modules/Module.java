package me.lyamray.trickortreat.modules;

import co.aikar.commands.BaseCommand;
import me.lyamray.trickortreat.TOTMain;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class Module {

    public abstract void enable();

    public abstract void disable();

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, TOTMain.getInstance());
    }

    public void registerCommand(BaseCommand command) {
        TOTMain.getCommandManager().registerCommand(command);
    }
}