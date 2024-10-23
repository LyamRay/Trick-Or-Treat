package me.lyamray.trickortreat.modules.scoreboard;

import me.lyamray.trickortreat.modules.Module;
import me.lyamray.trickortreat.modules.scoreboard.listeners.PlayerJoinListener;
import me.lyamray.trickortreat.modules.scoreboard.listeners.PlayerLeaveListener;

public class ScoreboardModule extends Module {

    /**
     * Enables the module by registering its listeners and commands.
     * This method registers the following listeners:
     * - {@link PlayerJoinListener}
     * - {@link PlayerLeaveListener}
     * It also registers the following command:
     */
    @Override
    public void enable() {
        registerListener(new PlayerJoinListener());
        registerListener(new PlayerLeaveListener());

    }

    /**
     * Not used.
     */
    @Override
    public void disable() {

    }
}