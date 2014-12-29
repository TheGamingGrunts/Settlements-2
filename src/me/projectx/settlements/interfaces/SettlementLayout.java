package me.projectx.settlements.interfaces;

public interface SettlementLayout {
	
	/**
	 * Set the name of the Settlement.
	 * 
	 * @param name : The name of the Settlement
	 */
	public void setName(String name);
	
	/**
	 * Get the name of the Settlement
	 * 
	 * @return The name of the Settlement
	 */
	public String getName();
	
	/**
	 * Set the ID of the Settlement.
	 * 
	 * @param id : The ID of the Settlement
	 */
	public void setId(long id);
	
	/**
	 * Get the ID of the Settlement
	 * 
	 * @return The Settlement's ID
	 */
	public long getId();
	
	/**
	 * Set the balance of the Settlement
	 * 
	 * @param balance : The amount to set the balance
	 */
	public void setBalance(double balance);
	
	/**
	 * Get the balance of the Settlement
	 * 
	 * @return The balance of the Settlement
	 */
	public double getBalance();
	
}
