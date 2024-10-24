package me.lyamray.trickortreat.modules.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.lyamray.trickortreat.TOTMain;
import me.lyamray.trickortreat.modules.utils.Colors;
import org.bukkit.entity.Player;

@CommandAlias("tot|trickortreat")
public class MainCommand extends BaseCommand {

    @CommandAlias("help")
    @CommandCompletion("@help")
    @CommandPermission("tot.help")
    @Description("Get all the commands of the plugin.")
    public void onHelp(Player player) {
        String version = TOTMain.getInstance().getDescription().getVersion();
        String message =
                "&7---&6Trick-Or-Treat&7--- \n\n" +
                        "&8• &7/tot adddoor &8- &6Add a Trick-Or-Treat Door!\n" +
                        "&8• &7/tot removedoor &8- &6Remove a Trick-Or-Treat Door!\n" +
                        "&8• &7/tot infodoor &8- &6Get info about a Trick-Or-Treat Door!\n" +
                        "&8• &7/tot setcandy <player> <amount> &8- &6Sets the amount of candy a player has!\n" +
                        "&8• &7/tot getcandy <player> &8- &6Gets the amount of candy a player has!\n" +
                        "&8• &7/tot givecandy <player> <amount> &8- &6Gets the amount of candy a player has!\n" +
                        "&8• &7/tot spawnnpc  &8- &6Spawn the Trick-Or-Treat NPC at your current location! \n\n" +
                        "&8• &7This server uses the version &6" + version +" &7of Trick-Or-Treat!";

        player.sendMessage(Colors.chat(message));
    }

    @Default
    public void onCommand(Player player) {
        player.sendMessage(Colors.chat("&7Use &6/tot help &7for all the commands!"));
    }
}
