package fr.prof.kbox.modules.commands;

import org.bukkit.plugin.java.JavaPlugin;

import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.commands.VisionCommand;

public class VisionModule extends AbstractModule {

	public VisionModule(JavaPlugin javaPlugin) {
		super(javaPlugin, "Vision");
		getCommandFramework().registerCommands(new VisionCommand(this));
	}

}
