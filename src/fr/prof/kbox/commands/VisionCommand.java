package fr.prof.kbox.commands;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.prof.kbox.api.commands.Command;
import fr.prof.kbox.api.commands.CommandArgs;
import fr.prof.kbox.api.modules.AbstractModule;
import fr.prof.kbox.enums.Messages;

public class VisionCommand {

	private final AbstractModule module;

	public VisionCommand(AbstractModule module) {
		this.module = module;
	}

	@Command(name = "vision", inGameOnly = true)
	public void visionCommand(CommandArgs args) {

		final Player player = args.getPlayer();
		if (this.module.isEnable()) {
			if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				player.sendMessage(Messages.NIGHTVISION_OFF.getText());
			} else {
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
				player.sendMessage(Messages.NIGHTVISION_ON.getText());
			}
		} else {
			player.sendMessage(Messages.MODULE_OFF.getText());
		}
	}

}
