package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
//WORKING
public class MenuTourneyOverview extends State {

	public MenuTourneyOverview() {
    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();
	
	//Next matches table Initialise
    String[][] data = new String[20][];
    int roundsPlayed = 38 - StateManager.getLeague().getRounds();
    for(int i = 0; i < 20; i++) {
    	data[i] = new String[]{StateManager.getLeague().getTeams().get(i).getTeamName(),
    			Integer.toString(roundsPlayed),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getWins()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getDraws()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getLosses()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getGoalsMade()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getGoalsAgainst()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getGoalDifference()),
    			Integer.toString(StateManager.getLeague().getTeams().get(i).getLeagueScore())
    			};
    }
	
	
    String[] columnNames = {"Team Name", "Played", "Wins", "Draws", "Losses",
    		"Goals Scored", "Goals Against", "Goal Difference", "Points"};
    
    //Next matches table
    JTable table = new JTable(data, columnNames);
    c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 2;
    layout.setConstraints(table, c);
    //table.setPreferredSize(new Dimension(400, 160));
    table.setEnabled(false);
    this.add(table);
    
    //Column width
    TableColumn column = null;
    for (int i = 0; i < 9; i++) {
        column = table.getColumnModel().getColumn(i);
        if (i == 0) {
            column.setPreferredWidth(150); //third column is bigger
        } else {
            column.setPreferredWidth(60);
        }
    }
    
    //Table header
    JTableHeader tableHeader = table.getTableHeader();
    c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 1;
  	layout.setConstraints(tableHeader, c);
  	tableHeader.setEnabled(false);
	this.add(tableHeader);
	
	//Go back
	JButton buttonBack = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
	createButton(buttonBack, "Back", c, layout);
	attachStateChanger(buttonBack, new MenuBetweenRounds());
	
    }
    
}
