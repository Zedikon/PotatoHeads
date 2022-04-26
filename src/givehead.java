package main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class givehead implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLine, String[] args) {
		// if send from console
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("This command just for player!");
			return true;
		}
		
		// give player nick
		Player p = (Player) sender;
		if(p.hasPermission("potatoheads.givehead")){
			
		
			// give head of player, whom nick in args.
			if(args.length == 1) {
				
				String playername = p.getName(); String playerhead = args[0];
				api.givehead(playername, playerhead);
				// Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " player_head{SkullOwner: " + "\"" + args[0] + "\"" + "}");
				return true;
			}
			// give player him head
			else if(args.length == 0) {
				String playername = p.getName();
				api.givehead(playername, playername);
				return true;
			}
			// if player don't have permission
			else {
				sender.sendMessage("You don't have permission!");
			}
		
		}
		else 
			return false;
		
		return false;
	}
}
