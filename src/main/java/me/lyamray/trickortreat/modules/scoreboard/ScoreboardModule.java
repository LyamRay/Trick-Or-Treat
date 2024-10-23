package me.lyamray.trickortreat.modules.scoreboard;

import me.lyamray.trickortreat.modules.Module;
import me.lyamray.trickortreat.modules.scoreboard.listeners.PlayerJoinListener;
import me.lyamray.trickortreat.modules.scoreboard.listeners.PlayerLeaveListener;

public class ScoreboardModule extends Module {

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
