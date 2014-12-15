public class MatchResultTest {
	public static void main(String[] args) {
		League league = League.readResources("resource.xml");
		
		System.out.println("test");
		int team1ID = 0;
		int team2ID = 2;
		
		String res = MatchResult.getResult(league.getTeams().get(team1ID), league.getTeams().get(team2ID), 90);
		
		System.out.println(league.getTeams().get(team1ID).getTeamName() + " vs " + league.getTeams().get(team2ID).getTeamName() + "\n" + res);
		
	}
}
