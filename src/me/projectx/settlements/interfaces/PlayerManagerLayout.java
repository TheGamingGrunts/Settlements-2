package me.projectx.settlements.interfaces;

import java.util.UUID;

import me.projectx.settlements.models.SettlementPlayer;

public interface PlayerManagerLayout {
	
	/**
	 * Get a SettlementPlayer
	 * 
	 * @param player : The player to get
	 * @return The SettlementPlayer
	 */
	public SettlementPlayer getPlayer(SettlementPlayer player);
	
	/**
	 * Get a SettlementPlayer by UUID
	 * 
	 * @param id : The UUID of the player to get
	 * @return The SettlementPlayer associated with the UUID
	 */
	public SettlementPlayer getPlayer(UUID id);
	
	/**
	 * Register a new server player
	 * 
	 * @param uuid : The UUID of the player
	 */
	public void registerPlayer(UUID uuid);
}
