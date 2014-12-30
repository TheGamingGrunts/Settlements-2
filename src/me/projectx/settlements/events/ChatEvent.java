package me.projectx.settlements.events;

import me.projectx.settlements.managers.PlayerManager;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		SettlementPlayer sp = PlayerManager.getManager().getPlayer(e.getPlayer().getUniqueId());
		switch(sp.getChatChannel()){
		case ALLIANCE:
			//Wait for alliance implementation
			break;
		case SETTLEMENT:
			e.setCancelled(true);
			sp.getSettlement().sendSettlementMessage(ChatColor.GREEN + "[" + e.getPlayer().getDisplayName() + 
					ChatColor.GREEN + "] " + e.getMessage()); //TODO Possible formatting usinf Fanciful (player stats maybe?)
			break;
		default:
			break;
		}
		//TODO format chat using Fanciful
	}
}
