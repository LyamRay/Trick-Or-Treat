package me.lyamray.trickortreat.modules.npc;

import me.lyamray.trickortreat.modules.Module;
import me.lyamray.trickortreat.modules.npc.commands.SpawnNpcCommand;

public class NPCModule extends Module {


    /**
     * Enables the NPCModule by registering necessary event listeners.
     * Specifically, this method registers an instance of NPCClickListener
     * to handle NPC click events.
     */
    @Override
    public void enable() {
        registerCommand(new SpawnNpcCommand());
    }

    /**
     * Not used.
     */
    public void disable() {}
}
