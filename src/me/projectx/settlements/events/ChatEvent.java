package me.projectx.settlements.events;

import me.projectx.settlements.manager.PlayerManager;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

	PlayerManager pm = PlayerManager.getInstance();

	public void onChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		if (pm.containsPlayer(p)) {
			SettlementPlayer sp = pm.getPlayer(p);
			switch (sp.getChatChannel()) {

			// TODO Make the chat channels do stuffs, waiting for the Settlement
			// class :P
			case GLOBAL:
				break;
			case ALLIANCE:
				break;
			case LOCAL:
				break;
			case SETTLEMENT:
				break;
			default:
				break;

			}
		}
	}

}
