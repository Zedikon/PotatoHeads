package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class givehead implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLine, String[] args) {
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage("This command just for player!");
			return true;
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("potatoheads.givehead")){
			
		
		
			if(args.length == 1) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " player_head{SkullOwner: " + "\"" + args[0] + "\"" + "}");
				return true;
			}
		
			else if(args.length == 0) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + p.getName() + " player_head{SkullOwner: " + "\"" + p.getName() + "\"" + "}");
				return true;
			}
			
			else {
				sender.sendMessage("You don't have permission!");
			}
		
		}
		else 
			return false;
		
		return false;
	}
}
