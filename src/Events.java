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
		// check, enable this function or no
		Boolean s = plugin.getConfig().getBoolean("EnableDropPlayerHeads");
		if(s == true) {
			// trying give killer, player head
			try {
				Player player = e.getEntity();
				Player killer = player.getKiller();
				String killername = killer.getName(); String playerhead = player.getName();
				api.givehead(killername, playerhead);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + killer.getName() + " player_head{SkullOwner: " + "\"" + player.getName() + "\"" + "}");
			} catch (Exception ignore) { }
		}
	}	
}
