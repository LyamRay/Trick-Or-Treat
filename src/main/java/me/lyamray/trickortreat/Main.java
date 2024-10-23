package me.lyamray.trickortreat;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import lombok.Setter;
import me.lyamray.trickortreat.modules.ModuleManager;
import me.lyamray.trickortreat.modules.core.CoreModule;
import me.lyamray.trickortreat.modules.database.Database;
import me.lyamray.trickortreat.modules.scoreboard.ScoreboardModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    @Getter
    @Setter
    public static Database database;

    @Getter
    @Setter
    public static ModuleManager moduleManager;

    @Getter
    @Setter
    public static PaperCommandManager commandManager;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        moduleManager =  new ModuleManager();
        commandManager = new PaperCommandManager(this);
        moduleManager.register(new ScoreboardModule(), new CoreModule());
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

    /**
     * Ensures that the data folder exists and establishes a connection to the database.
     * If the data folder does not exist, this method attempts to create it. If folder creation fails,
     * it disables the plugin. Next, it attempts to establish an SQLite database connection within the data folder.
     */
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