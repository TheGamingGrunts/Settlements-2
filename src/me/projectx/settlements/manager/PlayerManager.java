package me.projectx.settlements.manager;

import java.util.ArrayList;
import java.util.List;

import me.projectx.settlements.interfaces.PlayerManagerLayout;
import me.projectx.settlements.models.SettlementPlayer;

import org.bukkit.entity.Player;

public class PlayerManager implements PlayerManagerLayout {

	private static PlayerManager pm;

	private List<SettlementPlayer> players = new ArrayList<SettlementPlayer>();

	private PlayerManager() {
		pm = this;
	}

	public static PlayerManager getInstance() {
		if (pm != null) {
			return pm;
		}
		return new PlayerManager();
	}

	@Override
	public void addPlayer(SettlementPlayer player) {
		players.add(player);

	}

	@Override
	public void removePlayer(SettlementPlayer player) {
		players.remove(player);

	}

	@Override
	public boolean containsPlayer(SettlementPlayer player) {
		return players.contains(player);
	}

	@Override
	public boolean containsPlayer(Player player) {
		for (SettlementPlayer sp : players) {
			if (sp.getPlayer() == player) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<SettlementPlayer> getPlayers() {
		return players;
	}

	@Override
	public SettlementPlayer getPlayer(Player player) {
		for (SettlementPlayer sp : players) {
			if (sp.getPlayer() == player) {
				return sp;
			}
		}
		return null;
	}

}
