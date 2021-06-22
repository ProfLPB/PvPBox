package fr.prof.kbox.commands;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;

import fr.prof.kbox.api.ItemBuilder;
import fr.prof.kbox.api.commands.Command;
import fr.prof.kbox.api.commands.CommandArgs;
import fr.prof.kbox.api.inventory.FastInv;
import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.api.thread.MultiThreading;
import fr.prof.kbox.enums.Messages;
import fr.prof.kbox.modules.ModuleManager;

/**
 * @author TopeEstLa
 * @version 1.0.0
 */
public class ModuleCommand {

	private final ModuleManager moduleManager;

	public ModuleCommand(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}

	@Command(name = "module", permission = "core.module")
	public void moduleCommand(CommandArgs args) {

		MultiThreading.runAsync(() -> {
			FastInv moduleInv = new FastInv(InventoryType.CHEST, "§6§lModules");

			int i = 0;
			for (AbstractModule abstractModule : this.moduleManager.getModulesList()) {
				moduleInv
						.setItem(i,
								new ItemBuilder(Material.NAME_TAG)
										.setName("§6" + abstractModule.getName()
												+ (abstractModule.isEnable() ? " §8(§aON§8)" : " §8(§cOFF§8)"))
										.toItemStack(),
								e -> {
									abstractModule.setStatus(!abstractModule.isEnable());
									e.getWhoClicked().sendMessage(Messages.MODULE_CHANGE.getText()
											.replace("%name%", abstractModule.getName()).replace("%status%",
													abstractModule.isEnable() ? " §8(§aON§8)" : " §8(§cOFF§8)"));
									e.getWhoClicked().closeInventory();
								});
				i++;
			}
			moduleInv.open(args.getPlayer());
		});
	}
}
