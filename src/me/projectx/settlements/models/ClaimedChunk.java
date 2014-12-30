package me.projectx.settlements.models;

import me.projectx.settlements.enums.ChunkType;
import me.projectx.settlements.interfaces.ClaimedChunkLayout;

import org.bukkit.World;

public class ClaimedChunk implements ClaimedChunkLayout {

	private SettlementPlayer player;
	private double x;
	private double z;
	private World world;
	private Settlement set;
	private ChunkType type = ChunkType.NORMAL;

	public ClaimedChunk(SettlementPlayer player, double x, double z, World world) {
		this.player = player;
		this.x = x;
		this.z = z;
		this.world = world;
		this.set = player.getSettlement();
	}

	public ClaimedChunk(SettlementPlayer player, double x, double z,
			World world, ChunkType type) {
		this.player = player;
		this.x = x;
		this.z = z;
		this.world = world;
		this.set = player.getSettlement();
		this.type = type;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public SettlementPlayer getOwner() {
		return player;
	}

	@Override
	public void setOwner(SettlementPlayer player) {
		this.player = player;
	}

	@Override
	public Settlement getSettlement() {
		return set;
	}

	@Override
	public void setSettlement(Settlement set) {
		this.set = set;

	}

	@Override
	public ChunkType getType() {
		return type;
	}

	@Override
	public void setType(ChunkType type) {
		this.type = type;

	}

}
