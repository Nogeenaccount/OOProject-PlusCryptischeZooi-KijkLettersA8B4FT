/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class LeagueTestRead {
    
    League testleague;
    
    @Before
    public void before(){
    testleague = League.readResources("src/TestInput.xml");
    }
    

    @Test
    public void leagueNameTest() {
    assertEquals(testleague.getLeagueName(), "Barclays Premier League");
    }
    
    @Test
    public void leagueTeamstest(){
   	 assertEquals(testleague.getRounds(), 38);
   	 assertNotEquals(testleague.getRounds(), 36);    
    }
    
    @Test
    public void numberOfTeamsTest(){
   	 assertEquals(testleague.getTeams().size(), 20);
    }
    
    @Test
    public void numberOfPlayersTest(){
   	 assertEquals(testleague.getTeams().get(5).getPlayers().size(), 22);
    }
    
    @Test
    public void deRobinVanPersieTest(){
   	 assertEquals(testleague.getTeams().get(10).getPlayers().get(16).getPlayerName(), "Robin van Persie");
    }
    
    @Test
    public void getEnduranceTest(){
   	 assertNotEquals(testleague.getTeams().get(8).getPlayers().get(8).getEndurance(), 100);
   	 assertEquals(testleague.getTeams().get(8).getPlayers().get(8).getEndurance(), 91);
    }
    
    @Test
    public void doekoeTest(){
   	 assertEquals(testleague.getTeams().get(8).getBudget(), 37166000);
    }
    
    @Test
    public void stadiumTest(){
   	 assertEquals(testleague.getTeams().get(11).getStadiumName(), "St. James' Park");
    }
    
    @Test
    public void christianEriksen(){
   	 assertEquals(testleague.getTeams().get(17).getPlayers().get(21).getPlayerName(), "Christian Eriksen");
   	 assertEquals(testleague.getTeams().get(17).getPlayers().get(21).getShirtNumber(), 22);
    }
    
    @Test
    public void priceTest(){
   	 assertEquals(testleague.getTeams().get(14).getPlayers().get(5).getPrice(),10400000 );
    }
    
}
