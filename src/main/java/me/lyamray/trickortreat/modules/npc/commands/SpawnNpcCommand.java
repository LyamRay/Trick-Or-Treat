package me.lyamray.trickortreat.modules.npc.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.lyamray.trickortreat.modules.utils.NPCCreation;
import org.bukkit.entity.Player;

@CommandAlias("tot|trickortreat")
public class SpawnNpcCommand extends BaseCommand {

    @Subcommand("spawnnpc")
    @CommandCompletion("@spawnnpc")
    @CommandPermission("tot.spawn")
    @Description("Spawn the main NPC from this plugin.")
    public void onSpawnNpcCommand(Player player) {
        player.sendMessage("Lul 1!");
        new NPCCreation().createNPC(player);
        player.sendMessage("Lul 2!");
    }
}
