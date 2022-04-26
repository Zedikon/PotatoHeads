package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new Events(this), this);
		Bukkit.getServer().getPluginCommand("givehead").setExecutor(new givehead());
		Bukkit.getLogger().info("PotatoHeads enable!");
	
	}
	
	public void onDisable() {
		Bukkit.getLogger().info("PotatoHeads enable!");
	}
}
