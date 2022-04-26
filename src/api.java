package main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class api extends JavaPlugin{
	// give player head
	public static void givehead(String PlayerWhomGiveHead, String PlayerHead) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + PlayerWhomGiveHead + " player_head{SkullOwner: " + "\"" + PlayerHead + "\"" + "}");
	}

}