package me.projectx.settlements;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Settlements extends JavaPlugin {

	private Plugin plugin;

	public void onEnable() {
		plugin = this;
	}

	public Plugin getPlugin() {
		return plugin;
	}

}
