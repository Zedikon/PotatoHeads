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
		if(s == true) {
			try {
				Player player = e.getEntity();
				Player killer = player.getKiller();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + killer.getName() + " player_head{SkullOwner: " + "\"" + player.getName() + "\"" + "}");
			} catch (Exception ignore) { }
		}
	}	
}
