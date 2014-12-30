package me.projectx.settlements.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.projectx.settlements.enums.Rank;
import me.projectx.settlements.interfaces.SettlementLayout;
import me.projectx.settlements.managers.PlayerManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * The Settlement object, containing all Settlement-related methods.
 * 
 * @author Daniel
 */
public class Settlement implements SettlementLayout {
	
	private long id;
	private double balance;
	private String name, tagline;
	private UUID leader, queuedLeader; //Will update this to SettlementPlayer later
	private Location home;
	private List<Long> allies = new ArrayList<Long>();
	private List<SettlementPlayer> members = new ArrayList<SettlementPlayer>();
	
	public Settlement(String name) {
		this.name = name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}
	
	@Override
	public void setTagline(String tagline) {
		this.tagline = tagline;
		
	}
	
	@Override
	public String getTagline() {
		return tagline;
	}
	
	@Override
	public void giveCitizenship(SettlementPlayer player) {
		members.add(player);
		player.setRank(Rank.CITIZEN);
		player.setSettlement(this);
		/**
		 * TODO
		 * PlayerManager#updatePlayer(player) 
		 * 
		 * This will make a DB call that refreshes the player's settlement and rank
		 */
	} 
	
	@Override
	public void revokeCitizenship(SettlementPlayer player) {
		members.remove(player);
	}
	@Override
	public boolean hasMember(SettlementPlayer player) {
		return members.contains(player);
	}
	
	@Override
	public int memberSize() {
		return members.size();
	}
	
	@Override
	public void sendSettlementMessage(String message) {
		for (Player p : Bukkit.getOnlinePlayers()){
			for (SettlementPlayer sp : members){
				if (sp.getUniqueId().equals(p.getUniqueId())){
					p.sendMessage(message);
				}
			}
		}
	}
	
	@Override
	public void sendAllianceMessage(String message) {
		//for (Long l : allies){
			//TODO must create manager first
		//}
	}
	
	@Override
	public boolean hasAlly(long id) {
		return allies.contains(id);
	}
	
	@Override
	public void addAlly(long id) {
		allies.add(id);
	}
	
	@Override
	public void removeAlly(long id) {
		allies.remove(id);
	}
	
	@Override
	public Location getHome() {
		return null;
	}
	
	@Override
	public void setHome(Location location) {
		this.home = location;
	}
	
	@Override
	public boolean hasHome() {
		return home != null;
	}
	
	@Override
	public boolean hasOnlineMember() {
		for (Player p : Bukkit.getOnlinePlayers()){
			for (SettlementPlayer sp : members){
				if (sp.getUniqueId().equals(p.getUniqueId())){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void setQueuedLeader(UUID id) { //Will update this to SettlementPlayer later
		this.queuedLeader = id;
	}
	
	@Override
	public UUID getQueuedLeader() { //Will update this to SettlementPlayer later
		return queuedLeader;
	}

	@Override
	public void promote(SettlementPlayer player) {
		SettlementPlayer sp = PlayerManager.getManager().getPlayer(player);
		if (sp.getRank() == Rank.CITIZEN){
			sp.setRank(Rank.OFFICER);
			//PlayerManager#updatePlayer();
		}
	}

	@Override
	public SettlementPlayer getLeader() {
		for (SettlementPlayer sp : members){
			if (sp.getRank() == Rank.LEADER){
				return sp;
			}
		}
		return null;
	}
}
