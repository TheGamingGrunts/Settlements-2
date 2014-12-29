package me.projectx.settlements.models;

import me.projectx.settlements.enums.ChunkType;
import me.projectx.settlements.interfaces.ClaimedChunkLayout;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class ClaimedChunk implements ClaimedChunkLayout {

	// TODO Add SettlementPlayer
	public ClaimedChunk(double x, double y, World world) {

	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOwner(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Settlement getSettlement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSettlement(Settlement set) {
		// TODO Auto-generated method stub

	}

	@Override
	public ChunkType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(ChunkType type) {
		// TODO Auto-generated method stub

	}

}
