package me.projectx.settlements.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.projectx.settlements.models.SettlementPlayer;

public class PlayerManager {
	
	private static PlayerManager pm = new PlayerManager();
	private List<SettlementPlayer> players = new ArrayList<SettlementPlayer>();
	
	public static PlayerManager getManager(){
		return pm;
	}
	
	public SettlementPlayer getPlayer(SettlementPlayer player){
		for (SettlementPlayer sp : players){
			if (sp.equals(player)){
				return sp;
			}
		}
		return null;
	}
	public SettlementPlayer getPlayer(UUID uuid){
		for (SettlementPlayer sp : players){
			if (sp.getUniqueId().equals(uuid)){
				return sp;
			}
		}
		return null;
	}
}
