package fr.prof.kbox.enums;

public enum Messages {
	MODULE_OFF("§6§lModules §f§l» §fCe module est §edésactivé§f."),
	MODULE_CHANGE("§6§lModules §f§l» §fVous venez de modifier le §estatus §fdu module §e%name%§f. %status%"),
	DEATH("§6§l%death% §evient de se faire tuer par §6§l%killer%§e."),
	NIGHTVISION_ON("§6§lVision §f§l» §fVous avez §eactivé §fl'effet §eVision nocturne"),
	NIGHTVISION_OFF("§6§lVision §f§l» §fVous avez §edésactivé §fl'effet §eVision nocturne");

	private final String text;

	public String getText() {
		return this.text;
	}

	Messages(String text) {
		this.text = text;
	}
}