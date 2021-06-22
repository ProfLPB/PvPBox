package fr.prof.kbox.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.prof.kbox.api.modules.AbstractModule;

public class DeathListener implements Listener {

	private final AbstractModule module;

	public DeathListener(AbstractModule module) {
		this.module = module;
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent event) {
		if (this.module.isEnable()) {
			if (event.getEntity().getKiller() != null) {
				Bukkit.broadcastMessage("§6§l" + event.getEntity().getName() + " §evient de se faire tuer par §6§l"
						+ event.getEntity().getKiller().getName() + "§e.");
			}
		}
	}
}
