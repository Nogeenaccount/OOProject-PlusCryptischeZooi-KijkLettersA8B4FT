package rest;

import java.util.Comparator;

public class positionComparator implements Comparator<Player> {

	public int compare(Player p1, Player p2) {

		return (p1.getPosition().compareToIgnoreCase(p2.getPosition()));
	}

}
