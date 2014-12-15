package rest;

	import java.util.ArrayList;
	
	
	public class Team {
	
		private String teamName;
		private ArrayList<Player> players;
		private LineUp lineUp;
		private String stadiumName;
		private int winStreak;
		private int budget;
		
		private int leagueScore;
		private int played;
		private int wins;
		private int draws;
		private int losses;
		private int goalsMade;
		private int goalsAgainst;
		private int goalDifference;
		
		/**
		 * Team: constructor
		 * @param name
		 * @param stadium
		 * @param budget
		 */
		public Team(String name, String stadium, int budget){
			teamName = name;
			stadiumName = stadium;
			this.budget = budget;
			
			players = new ArrayList<Player>();
			lineUp  = new LineUp();
			winStreak      = 0;
			leagueScore    = 0;
			played         = 0;
			wins           = 0;
			draws          = 0;
			losses         = 0;
			goalsMade      = 0;
			goalsAgainst   = 0;
			goalDifference = 0;
		}
		
		/**
		 * add: adds player to the team
		 * @param player
		 */
		public void add(Player player){
			if (!players.contains(player))
				players.add(player);
		}
		
		/**
		 * toString: turns Team into a printable String
		 * @return String
		 */
		public String toString(){
			String str = "<Team(";
			str += 	teamName +", ";
			for (int i = 0; i<players.size(); i++){
				str+= players.get(i).toString();
				if (i<players.size()-1)
					str += ", ";
	
			}
			str +=  stadiumName +", "+winStreak +", "+budget +", "+leagueScore +", "+played +", "+wins +", "+draws +", "+losses +", "+goalsMade +", "+goalsAgainst +", "+goalDifference;
			str += ")>";
			return str;
		}
	
		
		
		// getters/setters
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public ArrayList<Player> getPlayers() {
			return players;
		}
		public void setPlayers(ArrayList<Player> players) {
			this.players = players;
		}
		public String getStadiumName() {
			return stadiumName;
		}
		public void setStadiumName(String stadiumName) {
			this.stadiumName = stadiumName;
		}
		public int getWinStreak() {
			return winStreak;
		}
		public void setWinStreak(int winStreak) {
			this.winStreak = winStreak;
		}
		public int getBudget() {
			return budget;
		}
		public void setBudget(int budget) {
			this.budget = budget;
		}
		public int getLeagueScore() {
			return leagueScore;
		}
		public void setLeagueScore(int leagueScore) {
			this.leagueScore = leagueScore;
		}
		public int getPlayed() {
			return played;
		}
		public void setPlayed(int played) {
			this.played = played;
		}
		public int getWins() {
			return wins;
		}
		public void setWins(int wins) {
			this.wins = wins;
		}
		public int getDraws() {
			return draws;
		}
		public void setDraws(int draws) {
			this.draws = draws;
		}
		public int getLosses() {
			return losses;
		}
		public void setLosses(int losses) {
			this.losses = losses;
		}
		public int getGoalsMade() {
			return goalsMade;
		}
		public void setGoalsMade(int goalsMade) {
			this.goalsMade = goalsMade;
		}
		public int getGoalsAgainst() {
			return goalsAgainst;
		}
		public void setGoalsAgainst(int goalsAgainst) {
			this.goalsAgainst = goalsAgainst;
		}
		public int getGoalDifference() {
			return goalDifference;
		}
		public void setGoalDifference(int goalDifference) {
			this.goalDifference = goalDifference;
		}

		public LineUp getLineUp() {
			return lineUp;
		}

		public void setLineUp(LineUp lineUp) {
			this.lineUp = lineUp;
		}	
	}
