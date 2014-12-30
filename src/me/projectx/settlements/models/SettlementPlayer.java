package me.projectx.settlements.models;

import java.util.UUID;

import me.projectx.settlements.enums.ChatChannel;
import me.projectx.settlements.enums.Rank;
import me.projectx.settlements.interfaces.SettlementPlayerLayout;
import me.projectx.settlements.managers.SettlementManager;

public class SettlementPlayer implements SettlementPlayerLayout {

	private String name;
	private UUID uuid;
	private long setId;
	private Rank rank;
	private ChatChannel channel;

	public SettlementPlayer(UUID uuid){
		this.uuid = uuid;
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

	@Override
	public Settlement getSettlement() {
		return SettlementManager.getManager().getSettlement(setId);
	}

	@Override
	public Rank getRank() {
		return rank;
	}

	@Override
	public void setSettlement(Settlement settlement) {
		settlement.addMember(this);
		this.setId = settlement.getId();
	}

	@Override
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public ChatChannel getChatChannel() {
		return channel;
	}

	@Override
	public void setChatChannel(ChatChannel channel) {
		this.channel = channel;
	}

	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}
}
