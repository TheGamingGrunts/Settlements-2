package me.projectx.settlements.events;

import me.projectx.settlements.managers.PlayerManager;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if (!p.hasPlayedBefore()){
			PlayerManager.getManager().registerPlayer(p.getUniqueId());
			e.setJoinMessage(ChatColor.GRAY + "Welcome to Project-X, " + ChatColor.AQUA + p.getName());
		}else{
			SettlementPlayer sp = PlayerManager.getManager().loadPlayer(p.getUniqueId());
			sp.getSettlement().sendSettlementMessage(ChatColor.GREEN + "Settlement member " + ChatColor.RED + 
					p.getName() + ChatColor.GREEN + " has logged in.");
			//send alliance message
		}	
	}
}
