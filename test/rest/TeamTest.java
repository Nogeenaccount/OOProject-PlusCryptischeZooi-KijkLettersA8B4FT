package rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import rest.League;
import rest.Player;
import rest.Team;

public class TeamTest {

    League Barclays = new League("Barclays", 36, "", "");
    Team a = new Team("Chelsea", "Arena", 10000);
    Team b = new Team("Arsenal", "Arena", 10000);
	// public Player(String name, int number, int price, int end, int off, int
    // def, String pos, int cc, int injured){

    Player p1 = new Player("p1", 1, 500, 99, 99, 99, "gk", 0, 0);
    Player p2 = new Player("p2", 2, 500, 99, 99, 99, "gk", 0, 0);
    Player p3 = new Player("p3", 3, 500, 99, 99, 99, "gk", 0, 0);
    Player p4 = new Player("p4", 4, 500, 99, 99, 99, "gk", 0, 0);
    Player p5 = new Player("p5", 5, 500, 99, 99, 99, "gk", 0, 0);
    Player p6 = new Player("p6", 1, 500, 99, 99, 99, "gk", 0, 0);
    Player p7 = new Player("p7", 2, 500, 99, 99, 99, "gk", 0, 0);
    Player p8 = new Player("p8", 3, 500, 99, 99, 99, "gk", 0, 0);
    Player p9 = new Player("p9", 4, 500, 99, 99, 99, "gk", 0, 0);
    Player p0 = new Player("p0", 5, 500, 99, 99, 99, "gk", 0, 0);

    @Test
	// A shirt number can't be negative or zero, so there is no need to test
    // negative values.
    public void testshirtnumberTaken1() {
	a.add(p1);
	assertTrue(a.shirtnumberTaken(1) == true);
	assertTrue(a.shirtnumberTaken(2) == false);
    }

    @Test
    public void testshirtnumberFree1() {
	a.add(p1);
	a.add(p2);
	a.add(p3);
	a.add(p4);

	assertTrue(a.shirtnumberFree(p1) == false);
	assertTrue(a.shirtnumberFree(p5) == true);

    }

    /**
     * First test, tests if numbers are 1 . 2 . 3 . ?
     */
    @Test
    public void testavailableShirtnumber1() {
	a.add(p1);
	a.add(p2);
	a.add(p3);
	a.add(p4);
	assertFalse(a.availableShirtnumber() == 4);
	assertTrue(a.availableShirtnumber() == 5);
    }

    /**
     * second test, test if there is a gap : 1. 3 .4
     */
    @Test
    public void testavailableShirtnumber2() {
	a.add(p1);
	a.add(p2);
	a.add(p3);
	a.add(p4);
	a.getPlayers().remove(2);
	assertFalse(a.availableShirtnumber() == 5);
	assertTrue(a.availableShirtnumber() == 3);
    }

    /**
     * first test, is the budget upgraded and the player added?
     */
    @Test
    public void testbuyPlayer1() {

	a.buyPlayer(p1); // budget is 10000 - 500

	assertTrue(a.getBudget() == 9500);
	assertFalse(a.getBudget() == 10000);
	assertTrue(a.getPlayers().get(0).equals(p1));

    }

    /**
     * second test, is the shirt number changed?
     */
    @Test
    public void testbuyPlayer2() {
	a.add(p1);
	a.add(p2);
	a.buyPlayer(p6);
	a.buyPlayer(p7);
	assertTrue(p6.getShirtNumber() == 3);
	assertTrue(p7.getShirtNumber() == 4);

    }

    /**
     * test 1, is the budget upgraded?
     */
    @Test
    public void testsellPlayer1() {
	a.add(p1);
	a.sellPlayer(p1);
	assertTrue(a.getBudget() == 10500);

    }

    /**
     * test 2, is the player removed and the list shifted to the left?
     */
    @Test
    public void testsellPlayer2() {
	a.add(p1);
	a.add(p2);
	a.sellPlayer(p1);
	assertTrue(a.getPlayers().get(0).equals(p2));
    }
}
