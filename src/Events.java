package main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Events implements Listener{
	main plugin;
	
	public Events(main main){
		this.plugin = main;
	}
	
	@EventHandler
	public void pd(PlayerDeathEvent e) {
		Boolean s = plugin.getConfig().getBoolean("EnableDropPlayerHeads");
		int chance = plugin.getConfig().getInt("DropPlayerHeadChance");
		// check enable this function or no
		if(s == true) {
			// check chance, if chance > 100, return warning
			if(chance > 100) {
				Bukkit.getLogger().warning("[PotatoHeads] Chance of drop player head > 100. Edit it in config.");
			}
				//check chance, if chance < 0, return warning
			if(chance < 0) {
				Bukkit.getLogger().warning("[PotatoHeads] Chance of drop player head < 0. Edit it in config.");
			}else {
			// trying give killer player head
				try {
					// chance for giving killer player head
					int a = 0;
					int b = 100;
					int random_res = a + (int) (Math.random() * b);
					
					// give info about killer and player
					Player player = e.getEntity();
					Player killer = player.getKiller();
					String killername = killer.getName(); String playerhead = player.getName();
					
					
					if(random_res <= chance) {
						api.givehead(killername, playerhead);
					}
					
				} catch (Exception ignore) { }
			}
		}	
	}
}
