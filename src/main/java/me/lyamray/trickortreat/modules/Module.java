package me.lyamray.trickortreat.modules;

import co.aikar.commands.BaseCommand;
import me.lyamray.trickortreat.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class Module {

    public abstract void enable();

    public abstract void disable();

    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, Main.instance);
    }

    public void registerCommand(BaseCommand command) {
        Main.commandManager.registerCommand(command);
    }
}