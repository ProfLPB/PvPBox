package fr.prof.kbox.modules.events;

import org.bukkit.plugin.java.JavaPlugin;

import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.listeners.DaylightCycleListener;

public class DailyCycleModule extends AbstractModule {

	public DailyCycleModule(JavaPlugin javaPlugin) {
		super(javaPlugin, "WeatherChange");
		registerListener(new DaylightCycleListener(this));
	}

}
