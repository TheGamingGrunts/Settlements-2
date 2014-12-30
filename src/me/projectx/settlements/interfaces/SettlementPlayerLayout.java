package me.projectx.settlements.interfaces;

import me.projectx.settlements.enums.ChatChannel;
import me.projectx.settlements.enums.MemberRank;
import me.projectx.settlements.models.Settlement;

import org.bukkit.entity.Player;

public interface SettlementPlayerLayout {

	/**
	 * Gets Player's Settlement
	 *
	 * @return Player's Settlement
	 */
	public Settlement getSettlement();

	/**
	 * Sets player's Settlement
	 *
	 * @param set
	 *            Player's new Settlement
	 */
	public void setSettlement(Settlement set);

	/**
	 * Get player's money
	 *
	 * @return Player's money
	 */
	public int getMoney();

	/**
	 * Set's players money
	 *
	 * @param money
	 *            New amount of money
	 */
	public void setMoney(int money);

	/**
	 * Get's players current ChatChannel
	 *
	 * @return The player's current channel
	 */
	public ChatChannel getChatChannel();

	/**
	 * Sets player's current ChatChannel
	 *
	 * @param channel
	 *            The channel to change to
	 */
	public void setChatChannel(ChatChannel channel);

	/**
	 * Get's player's MemberRank
	 *
	 * @return Player's MemberRank
	 */
	public MemberRank getRank();

	/**
	 * Sets the player's MemberRank
	 *
	 * @param rank
	 *            New MemberRank of player
	 */
	public void setRank(MemberRank rank);

	/**
	 * Gets the Bukkit Player the SettlementPlayer is associated with
	 *
	 * @return Player that SettlementPlayer is associated with
	 */
	public Player getPlayer();

}
