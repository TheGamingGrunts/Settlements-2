package me.projectx.settlements.models;

import me.projectx.settlements.enums.ChatChannel;
import me.projectx.settlements.enums.MemberRank;
import me.projectx.settlements.interfaces.SettlementPlayerLayout;
import me.projectx.settlements.manager.PlayerManager;

import org.bukkit.entity.Player;

public class SettlementPlayer implements SettlementPlayerLayout {

	private Player player;
	private Settlement set;
	private int money;
	private ChatChannel channel = ChatChannel.GLOBAL;
	private MemberRank rank;

	public SettlementPlayer(Player player) {
		this.player = player;
		this.rank = MemberRank.NONE;
		PlayerManager.getInstance().addPlayer(this);
	}

	public SettlementPlayer(Player player, Settlement set, int money,
			MemberRank rank) {
		this.player = player;
		this.set = set;
		this.money = money;
		this.channel = ChatChannel.GLOBAL;
		this.rank = rank;
		PlayerManager.getInstance().addPlayer(this);
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
	public int getMoney() {
		return money;
	}

	@Override
	public void setMoney(int money) {
		this.money = money;

	}

	@Override
	public ChatChannel getChatChannel() {
		return channel;
	}

	@Override
	public void setChatChannel(ChatChannel channel) {
		this.channel = channel;

	}

	@Override
	public MemberRank getRank() {
		return rank;
	}

	@Override
	public void setRank(MemberRank rank) {
		this.rank = rank;

	}

	@Override
	public Player getPlayer() {
		return player;
	}

}
