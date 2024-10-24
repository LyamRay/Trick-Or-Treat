package me.lyamray.trickortreat.modules.npc.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import me.lyamray.trickortreat.modules.utils.Colors;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@CommandAlias("tot|trickortreat")
public class SpawnNpcCommand extends BaseCommand {

    @CommandAlias("spawnnpc|spawn")
    @CommandCompletion("@spawnnpc")
    @CommandPermission("tot.spawn")
    @Description("Spawn the main NPC from this plugin.")
    public void onSpawnNpcCommand(Player player) {
        player.sendMessage(Colors.chat("&7The &6NPC &7has spawned on &6your &7location!"));
        Location loc = player.getLocation();
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, Colors.chat("&6Micheal Myers"));
        npc.spawn(loc);
    }
}
