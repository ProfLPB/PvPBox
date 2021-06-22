package fr.prof.kbox.modules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import fr.prof.kbox.api.commands.CommandFramework;
import fr.prof.kbox.api.inventory.FastInvManager;
import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.commands.ModuleCommand;

/**
 * @author TopeEstLa
 * @version 1.0.0
 */
public class ModuleManager {

	private final List<AbstractModule> modulesList;

	public ModuleManager(JavaPlugin javaPlugin) {
		this.modulesList = new ArrayList<>();
		CommandFramework commandFramework = new CommandFramework(javaPlugin);

		FastInvManager.register(javaPlugin);
		commandFramework.registerCommands(new ModuleCommand(this));
	}

	public List<AbstractModule> getModulesList() {
		return this.modulesList;
	}

	public void registerModule(AbstractModule module) {
		this.modulesList.add(module);
	}

	public void clearAllModule() {
		this.modulesList.clear();
	}
}
