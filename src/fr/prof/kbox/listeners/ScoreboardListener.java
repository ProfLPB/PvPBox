package fr.prof.kbox.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.prof.kbox.KBoxPlugin;
import fr.prof.kbox.api.fastboard.FastBoard;

public class ScoreboardListener implements Listener {

	private final KBoxPlugin kBoxPlugin;

	public ScoreboardListener(final KBoxPlugin kBoxPlugin) {
		this.kBoxPlugin = kBoxPlugin;
	}

	@EventHandler
	public void onJoin(final PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		final FastBoard board = new FastBoard(player);

		board.updateTitle("§f§l◆ §6§lPvPBox §f§l◆");

		this.kBoxPlugin.getBoards().put(player.getUniqueId(), board);
	}

	@EventHandler
	public void onQuit(final PlayerQuitEvent event) {
		final Player player = event.getPlayer();

		final FastBoard board = this.kBoxPlugin.getBoards().remove(player.getUniqueId());

		if (board != null) {
			board.delete();
		}

	}

}
