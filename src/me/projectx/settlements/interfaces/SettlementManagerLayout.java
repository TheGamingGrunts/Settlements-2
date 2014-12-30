package me.projectx.settlements.interfaces;

import me.projectx.settlements.models.Settlement;

public interface SettlementManagerLayout {
	
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
}
