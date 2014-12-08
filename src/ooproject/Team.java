import java.util.ArrayList;
import java.util.List;

public class Team {

	private String teamName;
	private List<Player> players = new ArrayList<Player>();
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
	private int overalScore; // for determing match outcome

	/**
	 * All the scores from the players added to each other + bonuses 
	 * @return
	 */
	public int getOveralScore() {
		return overalScore;
	}

	public void setOveralScore(int overalScore) {
		this.overalScore = overalScore;
	}

	/**
	 * Team: constructor
	 * 
	 * @param name
	 * @param stadium
	 * @param budget
	 */
	public Team(String name, String stadium, int budget) {
		teamName = name;
		stadiumName = stadium;
		this.budget = budget;

		players = new ArrayList<Player>();
		winStreak = 0;
		leagueScore = 0;
		played = 0;
		wins = 0;
		draws = 0;
		losses = 0;
		goalsMade = 0;
		goalsAgainst = 0;
		goalDifference = 0;
	}

	/**
	 * add: adds player to the team
	 * 
	 * @param player
	 */
	public void add(Player player) {
		if (!players.contains(player))
			players.add(player);
	}

	/**
	 * toString: turns Team into a printable String
	 * 
	 * @return String
	 */
	public String toString() {
		String str = "<Team(";
		str += teamName + ", ";
		for (int i = 0; i < players.size(); i++) {
			str += players.get(i).toString();
			if (i < players.size() - 1)
				str += ", ";

		}
		str += stadiumName + ", " + winStreak + ", " + budget + ", "
				+ leagueScore + ", " + played + ", " + wins + ", " + draws
				+ ", " + losses + ", " + goalsMade + ", " + goalsAgainst + ", "
				+ goalDifference;
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

	public List<Player> getPlayers() {
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

	public void sellPlayer(Player x) {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getPlayerName()
					.equalsIgnoreCase(x.getPlayerName())) {
				this.players.remove(i);
				int newBudget = this.budget + x.getPrice();
				this.setBudget(newBudget);
			}

		}
	}

	public void buyPlayer(Player x) {
		this.add(x);
		this.setBudget(x.getPrice());
		if (this.shirtnumberFree(x) != true) {
			x.setShirtNumber(this.availableShirtnumber());

		}
	}

	public int availableShirtnumber() {
		int counter = 1;
		while (this.shirtnumberTaken(counter) == true) {
			counter++;

		}
		
			return counter;

	}

	public boolean shirtnumberTaken(int number) {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getShirtNumber() == number)
				return true;
		}
		return false;
	}

	public boolean shirtnumberFree(Player x) {
		int shirtNumber = x.getShirtNumber();

		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getShirtNumber() == shirtNumber)
				return false;

		}
		return true;
	}

	// transfers player x from team y to team this
	public void transferPlayer(Team y, Player x) {
		y.sellPlayer(x);
		this.buyPlayer(x);

	}
	
	public void calculatePoints() {
		int sum = 0;
		for (int i =0; i < this.players.size(); i++) {
			sum += this.players.get(i).getAttributes();
			}
		this.setOveralScore(sum);
	}

}
