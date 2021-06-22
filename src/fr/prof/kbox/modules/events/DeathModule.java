package fr.prof.kbox.modules.events;

import org.bukkit.plugin.java.JavaPlugin;

import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.listeners.DeathListener;

public class DeathModule extends AbstractModule {

	public DeathModule(JavaPlugin javaPlugin) {
		super(javaPlugin, "Death Message");
		registerListener(new DeathListener(this));
	}

}
