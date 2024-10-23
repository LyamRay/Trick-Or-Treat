package me.lyamray.trickortreat.modules.core;

import me.lyamray.trickortreat.modules.Module;
import me.lyamray.trickortreat.modules.core.commands.MainCommand;

public class CoreModule extends Module {

    @Override
    public void enable() {
        registerCommand(new MainCommand());
    }
    /**
     * Not used.
     */
    @Override
    public void disable() {

    }
}