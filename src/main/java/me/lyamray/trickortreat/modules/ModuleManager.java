package me.lyamray.trickortreat.modules;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModuleManager {


    private final Map<Class<? extends Module>, Module> modules = new LinkedHashMap<>();

    public void register(Module... module) {
        for (Module modules : module) {
            this.modules.put(modules.getClass(), modules);
            modules.enable();
        }
    }

    public void enable() {
        this.modules.values().forEach(Module::enable);
    }

    public void disable() {
        this.modules.values().stream().toList().reversed().forEach(Module::disable);
    }

    public <M> M getModule(Class<M> clazz) {
        return clazz.cast(modules.get(clazz));
    }
}