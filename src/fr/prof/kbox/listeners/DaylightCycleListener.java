package fr.prof.kbox.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.prof.kbox.api.modules.AbstractModule;

public class DaylightCycleListener implements Listener {

	private final AbstractModule module;

	public DaylightCycleListener(AbstractModule module) {
		this.module = module;
	}

	@EventHandler
	public void onWeatherChange(final WeatherChangeEvent event) {
		if (this.module.isEnable()) {
			event.setCancelled(true);
		}
	}
}
