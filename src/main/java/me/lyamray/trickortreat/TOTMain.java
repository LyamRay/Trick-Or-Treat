package me.lyamray.trickortreat;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import lombok.Setter;
import me.lyamray.trickortreat.modules.ModuleManager;
import me.lyamray.trickortreat.modules.core.CoreModule;
import me.lyamray.trickortreat.modules.database.Database;
import me.lyamray.trickortreat.modules.npc.NPCModule;
import me.lyamray.trickortreat.modules.scoreboard.ScoreboardModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class TOTMain extends JavaPlugin {

    @Getter
    private static TOTMain instance;

    @Getter
    private static Database database;

    @Getter
    @Setter
    private static ModuleManager moduleManager;

    @Getter
    @Setter
    private static PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        moduleManager = new ModuleManager();
        commandManager = new PaperCommandManager(this);
        moduleManager.register(
                new ScoreboardModule(),
                new CoreModule(),
                new NPCModule(),
                new ScoreboardModule());
        checkFolderAndConnect();
    }

    /**
     * @throws RuntimeException if a SQLException occurs while closing the database connection.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            database.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to disable the plugin properly. " + e);
        }
    }

    public void checkFolderAndConnect() {
        try {
            if (!getDataFolder().exists()) {
                if (!getDataFolder().mkdirs()) {
                    System.err.println("Failed to create the data folder!");
                    Bukkit.getPluginManager().disablePlugin(this);
                    return;
                }
            }
            database = new Database(getDataFolder().getAbsolutePath() + "/database.db");
            System.out.println("Connected successfully to the database!");
        } catch (SQLException exception) {
            Bukkit.getPluginManager().disablePlugin(this);
            throw new RuntimeException("Failed to connect to the database. " + exception);
        }
    }
}