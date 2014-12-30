package me.projectx.settlements.managers;

import java.util.ArrayList;
import java.util.List;

import me.projectx.settlements.interfaces.SettlementManagerLayout;
import me.projectx.settlements.models.Settlement;

public class SettlementManager implements SettlementManagerLayout {
	
	private static SettlementManager sm = new SettlementManager();
	private List<Settlement> settlements = new ArrayList<Settlement>();

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
}
