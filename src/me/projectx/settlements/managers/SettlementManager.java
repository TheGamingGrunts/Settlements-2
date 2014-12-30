package me.projectx.settlements.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.projectx.settlements.enums.Rank;
import me.projectx.settlements.interfaces.SettlementManagerLayout;
import me.projectx.settlements.models.Settlement;
import me.projectx.settlements.models.SettlementPlayer;
import me.projectx.settlements.sql.SQLManager;

import org.bukkit.entity.Player;

public class SettlementManager implements SettlementManagerLayout {

	private static SettlementManager sm = new SettlementManager();

	private SQLManager sql = SQLManager.getManager();

	private List<Settlement> settlements = new ArrayList<Settlement>();
	private int lastId;

	public static SettlementManager getManager(){
		return sm;
	}

	public Settlement getSettlement(String name) {
		for (Settlement s : settlements){
			if (s.getName().equalsIgnoreCase(name)){
				return s;
			}
		}
		return null;
	}

	public Settlement getSettlement(long id){
		for (Settlement s : settlements){
			if (s.getId() == id){
				return s;
			}
		}
		return null;
	}

	public List<Settlement> getSettlements() {
		return settlements;
	}

	public void createSettlement(String name, SettlementPlayer player) {
		// TODO Auto-generated method stub

	}

	public void deleteSettlement(Settlement set) {
		// TODO Auto-generated method stub

	}

	public boolean settlementExists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean settlementExists(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Settlement getPlayerSettlement(SettlementPlayer player) {
		// TODO Auto-generated method stub
		return null;
	}

	public Settlement getPlayerSettlement(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadSettlements() {
		//TODO Untested
		try {
			ResultSet results = sql.query("SELECT * FROM settlements WHERE deleted = 0");

			while (results.next()) {
				Settlement set = new Settlement(results.getString("name"));
				set.setId(results.getLong("id"));
				ResultSet citizens = sql.query("SELECT * FROM CITIZENS WHERE settlement = ?", results.getLong("id"));
				while (citizens.next()) {
					SettlementPlayer player = new SettlementPlayer(UUID.fromString(citizens.getString("uuid")));
					player.setRank(Rank.valueOf(citizens.getInt("rank")));
					player.setSettlement(set);
					player.setName(citizens.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
