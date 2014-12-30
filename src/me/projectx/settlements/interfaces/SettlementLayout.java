package me.projectx.settlements.interfaces;

import java.util.UUID;

import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.Location;

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
	
	/**
	 * Set a short description of the Settlement
	 * 
	 * @param tagline : The description
	 */
	public void setTagline(String tagline);
	
	/**
	 * Get the tagline of the Settlement
	 * 
	 * @return The Settlement's tagline
	 */
	public String getTagline();
	
	/**
	 * Give a player citizenship in the Settlement
	 * 
	 * @param player : The UUID of the player
	 */
	public void giveCitizenship(SettlementPlayer player);
	
	/**
	 * Revoke a player's citizenship (officer & citizens)
	 * 
	 * @param player : The UUID of the player
	 */
	public void revokeCitizenship(SettlementPlayer player);
	
	/**
	 * Promote a player in the Settlement
	 * 
	 * @param player : The player to promote
	 */
	public void promote(SettlementPlayer player);
	
	/**
	 * Get the leader of the Settlement
	 * 
	 * @return The leader of the Settlement
	 */
	public SettlementPlayer getLeader();
	
	/**
	 * Determine if the Settlement has a player
	 * 
	 * @param player : The UUID of the player
	 * @return True if the Settlement has the player, false if not.
	 */
	public boolean hasMember(SettlementPlayer player);
	
	/**
	 * Get the total number of members in the Settlement
	 * 
	 * @return The number of members in the Settlement
	 */
	public int memberSize();
	
	/**
	 * Send a message to all Settlement members
	 * 
	 * @param message : The message to send
	 */
	public void sendSettlementMessage(String message);
	
	/**
	 * Send a message to all members of allied Settlements
	 * 
	 * @param message : The message to send
	 */
	public void sendAllianceMessage(String message);
	
	/**
	 * Determine if a Settlement is in this Settlement's alliance
	 * 
	 * @param id : The ID of the Settlement to test
	 * @return True if the Settlement is an alliance member, false if not
	 */
	public boolean hasAlly(long id);
	
	/**
	 * Add a Settlement to this Settlement's alliance
	 * 
	 * @param id : The ID of the Settlement to add
	 */
	public void addAlly(long id);
	
	/**
	 * Remove a Settlement from this Settlement's alliance
	 * 
	 * @param id : The ID of the Settlement to remove
	 */
	public void removeAlly(long id);
	
	/**
	 * Get the Settlement's home
	 * 
	 * @return The location of the Settlement's home
	 */
	public Location getHome();
	
	/**
	 * Set the location of the Settlement's home
	 * 
	 * @param location : The location
	 */
	public void setHome(Location location);
	
	/**
	 * Determine if the Settlement has a home set
	 * 
	 * @return True if the home is set, false if not.
	 */
	public boolean hasHome();
	
	/**
	 * Determine if the Settlement has any online members
	 * 
	 * @return True if there is an online member, false if not
	 */
	public boolean hasOnlineMember();
	
	/**
	 * Set the leader who will take over once the current leader leaves
	 * 
	 * @param id : The ID of the next leader
	 */
	public void setQueuedLeader(UUID id);
	
	/**
	 * Get the next leader of the Settlement
	 * 
	 * @return The next leader
	 */
	public UUID getQueuedLeader();
}
