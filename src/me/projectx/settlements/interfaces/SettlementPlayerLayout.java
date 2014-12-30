package me.projectx.settlements.interfaces;

import java.util.UUID;

import me.projectx.settlements.enums.ChatChannel;
import me.projectx.settlements.enums.Rank;
import me.projectx.settlements.models.Settlement;

/**
 * A class that controls the layout for SettlementPlayer
 *
 * @author Daniel
 */
public interface SettlementPlayerLayout {

	/**
	 * Get the UUID of the Player
	 *
	 * @return The player's UUID
	 */
	public UUID getUniqueId();

	/**
	 * Get the player's Settlement
	 *
	 * @return The player's Settlement
	 */
	public Settlement getSettlement();

	/**
	 * Get the player's rank in their Settlement
	 *
	 * @return The player's rank in their Settlement
	 */
	public Rank getRank();

	/**
	 * Set the Settlement that this player belongs to
	 *
	 * @param settlement : The Settlement that the player belongs to
	 */
	public void setSettlement(Settlement settlement);

	/**
	 * Set the player's rank in their Settlement
	 *
	 * @param rank : The player's rank in their Settlement
	 */
	public void setRank(Rank rank);

	/**
	 * Get the channel that the player is currently chatting in
	 *
	 * @return The player's current chat channel
	 */
	public ChatChannel getChatChannel();

	/**
	 * Set the player's chat channel
	 *
	 * @param channel : The channel to set {@link me.projectx.settlements.enums.ChatChannel ChatChannel}
	 */
	public void setChatChannel(ChatChannel channel);

	/**
	 * Gets a player's last known name
	 *
	 * @return Player's last known name
	 */
	public String getName();

	/**
	 * Changes a player's name
	 *
	 * @param name New name
	 */
	public void setName(String name);
}
