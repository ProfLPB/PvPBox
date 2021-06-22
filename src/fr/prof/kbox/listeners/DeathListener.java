package fr.prof.kbox.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.enums.Messages;

public class DeathListener implements Listener {

	private final AbstractModule module;

	public DeathListener(AbstractModule module) {
		this.module = module;
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent event) {
		if (this.module.isEnable()) {
			if (event.getEntity().getKiller() != null) {
				Bukkit.broadcastMessage(Messages.DEATH.getText().replace("%death%", event.getEntity().getName())
						.replace("%killer%", event.getEntity().getKiller().getName()));
			}
		}
	}
}
