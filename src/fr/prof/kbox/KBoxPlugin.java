package fr.prof.kbox;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.prof.kbox.api.fastboard.FastBoard;
import fr.prof.kbox.api.thread.MultiThreading;
import fr.prof.kbox.listeners.ScoreboardListener;
import fr.prof.kbox.modules.ModuleManager;
import fr.prof.kbox.modules.commands.VisionModule;
import fr.prof.kbox.modules.events.DailyCycleModule;
import fr.prof.kbox.modules.events.DeathModule;
import fr.prof.kbox.runnables.ScoreboardTask;

public class KBoxPlugin extends JavaPlugin {

	private final Map<UUID, FastBoard> boards = new HashMap<>();
	private static KBoxPlugin instance;

	@Override
	public void onEnable() {
		instance = this;
		this.registerModules();
		Bukkit.getPluginManager().registerEvents(new ScoreboardListener(this), this);
		MultiThreading.schedule(new ScoreboardTask(this), 0, 6, TimeUnit.SECONDS);
	}

	private final void registerModules() {
		final ModuleManager moduleManager = new ModuleManager(this);
		moduleManager.registerModule(new VisionModule(this));
		moduleManager.registerModule(new DeathModule(this));
		moduleManager.registerModule(new DailyCycleModule(this));
	}

	public final Map<UUID, FastBoard> getBoards() {
		return this.boards;
	}

	public static KBoxPlugin getInstance() {
		return instance;
	}

}
