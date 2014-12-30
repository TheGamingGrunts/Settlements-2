package me.projectx.settlements.interfaces;

import java.util.List;

import me.projectx.settlements.models.Settlement;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.entity.Player;

public interface SettlementManagerLayout {

	//TODO Want this reviewed by Daniel :P

	/**
	 * Get a Settlement by its name
	 *
	 * @param name : The name of the Settlement to get
	 * @return The designated Settlement. If the Settlement doesn't exist, then returns null.
	 */
	public Settlement getSettlement(String name);

	/**
	 * Get a Settlement by its ID
	 *
	 * @param name : The ID of the Settlement to get
	 * @return The designated Settlement. If the Settlement doesn't exist, then returns null.
	 */
	public Settlement getSettlement(long id);

	/**
	 * Gets a list of all existing Settlements
	 *
	 * @return A list of all existing Settlements
	 */
	public List<Settlement> getSettlements();

	/**
	 * Creates a Settlement
	 *
	 * @param name Name of Settlement
	 * @param player Creator of Settlement
	 */
	public void createSettlement(String name, SettlementPlayer player);

	/**
	 * "Deletes" a Settlement
	 *
	 * Note: Does not permanently delete a Settlement
	 *
	 * @param set Settlement to delete
	 */
	public void deleteSettlement(Settlement set);

	/**
	 * Checks if a Settlement exists
	 *
	 * @param name Name of Settlement to check
	 * @return Weather or not Settlement exists
	 */
	public boolean settlementExists(String name);

	/**
	 * Checks if a Settlement exists
	 *
	 * @param id Id of Settlement to check
	 * @return Weather or not Settlement exists
	 */
	public boolean settlementExists(long id);

	/**
	 * Gets the Settlement player belongs to. Returns null if none.
	 *
	 * @param player SettlementPlayer to check
	 * @return Settlement of player
	 */
	public Settlement getPlayerSettlement(SettlementPlayer player);

	/**
	 * Gets the Settlement player belongs to. Returns null if none.
	 *
	 * @param player Player to check
	 * @return Settlement of player
	 */
	public Settlement getPlayerSettlement(Player player);

	/**
	 * Loads Settlements from database
	 */
	public void loadSettlements();

}
