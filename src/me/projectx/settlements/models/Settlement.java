package me.projectx.settlements.models;

import java.util.ArrayList;
import java.util.List;

import me.projectx.settlements.enums.ChatChannel;
import me.projectx.settlements.enums.Rank;
import me.projectx.settlements.interfaces.SettlementLayout;
import me.projectx.settlements.managers.PlayerManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
	private SettlementPlayer leader, queuedLeader;
	private Location home;
	private List<Settlement> allies = new ArrayList<Settlement>();
	private List<Settlement> sentAllianceInvites = new ArrayList<Settlement>();
	private List<Settlement> receivedAllianceInvites = new ArrayList<Settlement>();
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
		sendSettlementMessage(ChatColor.RED + player.getName() + ChatColor.GREEN + " has joined the Settlement!");
		/**
		 * TODO
		 * PlayerManager#updatePlayer(player)
		 *
		 * This will make a DB call that refreshes the player's settlement and rank
		 */
	}

	@Override
	public void revokeCitizenship(SettlementPlayer player) {
		sendSettlementMessage(ChatColor.RED + player.getName() + ChatColor.GREEN + " has left the Settlement.");
		members.remove(player);
	}

	public List<SettlementPlayer> getCitizens() {
		return members;
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
		for (SettlementPlayer sp : members){
			Player p = Bukkit.getPlayer(sp.getUniqueId());
			p.sendMessage(message);
		}
	}

	@Override
	public void sendAllianceMessage(String message) {
		for (Settlement set : allies) {
			for (SettlementPlayer sp : set.getCitizens()) {
				if (sp.getChatChannel() == ChatChannel.ALLIANCE) {
					Player p = Bukkit.getPlayer(sp.getUniqueId());
					p.sendMessage(message);
				}
			}
		}
	}

	@Override
	public boolean hasAlly(Settlement set) {
		return allies.contains(set);
	}

	@Override
	public void addAlly(Settlement set) {
		allies.add(set);
	}

	@Override
	public void removeAlly(Settlement set) {
		allies.remove(set);
	}

	public List<Settlement> getAllies() {
		return allies;
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
	public void setQueuedLeader(SettlementPlayer player) {
		this.queuedLeader = player;
	}

	@Override
	public SettlementPlayer getQueuedLeader() {
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
		return leader;
	}

	@Override
	public void addMember(SettlementPlayer player) {
		if (player.getRank() == Rank.LEADER) {
			leader = player;
		}
		members.add(player);

	}
}
