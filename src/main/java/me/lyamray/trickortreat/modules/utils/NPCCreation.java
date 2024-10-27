package me.lyamray.trickortreat.modules.utils;

import de.oliver.fancynpcs.api.FancyNpcsPlugin;
import de.oliver.fancynpcs.api.Npc;
import de.oliver.fancynpcs.api.NpcData;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NPCCreation {


    public void createNPC(Player player) {
        player.sendMessage("Debug: Class loaded!");
        Location location = player.getLocation();
        player.sendMessage("Debug: Location fetched!");
        NpcData data = new NpcData("&6Test", UUID.randomUUID(), location);
        player.sendMessage("Debug: Data created!");
        data.setType(EntityType.PLAYER);
        player.sendMessage("Debug: Type set!");
        player.sendMessage("Debug: Data skin set!");
        Npc npc = FancyNpcsPlugin.get().getNpcAdapter().apply(data);
        player.sendMessage("Debug: Npc created!");
        npc.create();
        player.sendMessage("Debug: NPC created 1!");
        FancyNpcsPlugin.get().getNpcManager().registerNpc(npc);
        player.sendMessage("Debug: Registered NPC!");
        npc.spawnForAll();
        player.sendMessage("Debug: Spawned NPC!");
    }
}
