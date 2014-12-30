package me.projectx.settlements.enums;

/**
 * The various ranks for members of Settlements
 *
 * TODO add permission controls?
 * @author Daniel
 */
public enum Rank {

	CITIZEN("Citizen"),
	OFFICER("Officer"),
	LEADER("Leader");

	private String name;

	Rank(String name){
		this.name = name;
	}

	/**
	 * Get the string representation of the rank
	 */
	public String toString(){
		return name;
	}

	public static Rank valueOf(int rank) {
		switch (rank) {
		case 1:
			return Rank.CITIZEN;
		case 2:
			return Rank.OFFICER;
		case 3:
			return Rank.LEADER;
		}
		return null;
	}
}

