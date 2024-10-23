package me.lyamray.trickortreat.modules.npc;

import me.lyamray.trickortreat.modules.Module;
import me.lyamray.trickortreat.modules.npc.listeners.NPCClickListener;

public class NPCModule extends Module {


    /**
     * Enables the NPCModule by registering necessary event listeners.
     * Specifically, this method registers an instance of NPCClickListener
     * to handle NPC click events.
     */
    @Override
    public void enable() {
        registerListener(new NPCClickListener());
    }

    /**
     * Not used.
     */
    public void disable() {}
}
