/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MatchResultTest {

    Team team;
    
    @Before
    public void before(){
	team = new Team("Chelsea", "Arena", 10000);
	team.add(new Player("p1", 1, 500, 10, 20, 30, "gk", 0, 0));
	team.add(new Player("p2", 2, 500, 20, 30, 40, "gk", 0, 0));
	team.add(new Player("p3", 3, 500, 30, 40, 50, "gk", 0, 0));
	team.add(new Player("p4", 4, 500, 10, 20, 30, "gk", 0, 0));
	team.add(new Player("p5", 5, 500, 20, 30, 40, "gk", 0, 0));
	team.add(new Player("p6", 6, 500, 30, 40, 50, "gk", 0, 0));
	team.add(new Player("p7", 7, 500, 10, 20, 30, "gk", 0, 0));
	team.add(new Player("p8", 8, 500, 20, 30, 40, "gk", 0, 0));
	team.add(new Player("p9", 9, 500, 30, 40, 50, "gk", 0, 0));
	team.add(new Player("p10", 10, 500, 10, 20, 30, "gk", 0, 0));
	team.add(new Player("p11", 11, 500, 20, 30, 40, "gk", 0, 0));
    }
    
    @Test
    public void testOffenceSum(){
	assertEquals(320.0/11*4.5,MatchResult.offenceSum(team),0.1);
    }
    
    @Test
    public void testDefenceSum(){
	assertEquals(430.0/11*5.5,MatchResult.defenceSum(team),0.1);
    }
    
    @Test
    public void testEnduranceSum(){
	assertEquals(210.0/11*11,MatchResult.enduranceSum(team),0.1);
    }
}
