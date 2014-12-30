package me.projectx.settlements.interfaces;

import java.util.List;

import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.entity.Player;

public interface PlayerManagerLayout {

	/**
	 * Adds SettlementPlayer to PlayerManager
	 *
	 * @param player
	 *            SettlemetPlayer to add
	 */
	public void addPlayer(SettlementPlayer player);

	/**
	 * Removes player from PlayerManager
	 *
	 * @param player
	 *            Player to remove from SettlementPlayer
	 */
	public void removePlayer(SettlementPlayer player);

	/**
	 * Checks to see if a SettlementPlyer is part of PlayerManager
	 *
	 * @param player
	 *            SettlementPlayer to check
	 * @return Weather or not a SettlementPlayer is part of PlayerManager
	 */
	public boolean containsPlayer(SettlementPlayer player);

	/**
	 * Checks to see if a Player is a part of SettlementPlayer
	 *
	 * @param player
	 *            Player to check
	 * @return Weather or not a player has a SettlementPlayer
	 */
	public boolean containsPlayer(Player player);

	/**
	 * Gets SettlementPlayer from Player object
	 *
	 * @param player
	 *            Player to check
	 * @return SettlementPlayer of Player object
	 */
	public SettlementPlayer getPlayer(Player player);

	/**
	 * Gets a list of all SettlementPlayers
	 *
	 * @return List of all SettlementPlayers
	 */
	public List<SettlementPlayer> getPlayers();

}
