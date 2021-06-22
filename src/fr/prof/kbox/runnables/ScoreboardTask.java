package fr.prof.kbox.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import fr.prof.kbox.KBoxPlugin;
import fr.prof.kbox.api.fastboard.FastBoard;

public class ScoreboardTask implements Runnable {

	private final KBoxPlugin kBoxPlugin;

	public ScoreboardTask(final KBoxPlugin kBoxPlugin) {
		this.kBoxPlugin = kBoxPlugin;
	}

	@Override
	public void run() {
		this.kBoxPlugin.getBoards().values().forEach(board -> this.updateBoard(board));
	}

	private void updateBoard(final FastBoard board) {
		final Player player = board.getPlayer();
		int kills = player.getStatistic(Statistic.PLAYER_KILLS);
		int deaths = player.getStatistic(Statistic.DEATHS);
		double ratio = (deaths > 0.0D) ? (kills / deaths) : kills;
		board.updateLines("§a§l§f", "§f§l§6§l" + player.getName(), " §e┃ §fGrade: §4§lAdmin",
				" §e┃ §fKills: §e" + kills, " §e┃ §fDeaths: §e" + deaths, " §e┃ §fRatio: §e" + ratio, "§a§l§f",
				"§f§l§6§lServeur", " §e┃ §fVoteParty: §d10/300§f",
				" §e┃ §fEn ligne: §e" + Bukkit.getOnlinePlayers().size(), "§a§l§f", "§7play.pvpbox.fr");
	}

}
