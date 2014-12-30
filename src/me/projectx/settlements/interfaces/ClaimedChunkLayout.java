package me.projectx.settlements.interfaces;

import me.projectx.settlements.enums.ChunkType;
import me.projectx.settlements.models.Settlement;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.World;

public interface ClaimedChunkLayout {

	/**
	 * Gets X coordinate
	 *
	 * @return X coordinate
	 */
	public double getX();

	/**
	 * Gets Z coordinate
	 *
	 * @return Z coordinate
	 */
	public double getZ();

	/**
	 * Gets world in which this chunk exists
	 *
	 * @return World where this chunk is
	 */
	public World getWorld();

	/**
	 * Gets the current owner
	 *
	 * @return Player that owns this
	 */
	public SettlementPlayer getOwner();

	/**
	 * Sets current owner
	 *
	 * @param p
	 *            Player to set owner to
	 */
	public void setOwner(SettlementPlayer player);

	/**
	 * Gets current Settlement
	 *
	 * @return Current Settlement
	 */
	public Settlement getSettlement();

	/**
	 * Changes ownership of Settlement.
	 *
	 * Note: This will not change the owner, see setOwner()
	 *
	 * @param set
	 *            Settlement to change to
	 */
	public void setSettlement(Settlement set);

	/**
	 * Gets the type of Chunk
	 *
	 * @return Current ChunkType
	 */
	public ChunkType getType();

	/**
	 * Change the type of chunk
	 *
	 * @param type
	 *            ChunkType to change to
	 */
	public void setType(ChunkType type);

}
