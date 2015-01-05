package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//WORKING WITH FILLER
public class MenuAftermath extends State {

	public MenuAftermath() {
    }
	
    public void createGUI() {
    layout = new GridBagLayout();
    this.setLayout(layout);
	c = new GridBagConstraints();
	
	//Initialise
		String[] array1 = new String[20];
		rest.League league1 = rest.League.readResources("SaveGame.xml");
	    for(int i = 0; i < league1.getTeams().size(); i++) {
	    	array1[i] = league1.getTeams().get(i).getTeamName();
	    }
	
	//Prompt Round Results
	JTextArea matchResults = new JTextArea();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	layout.setConstraints(matchResults, c);
	matchResults.setPreferredSize(new Dimension(400, 400));
	matchResults.setEditable(false);
	
	String yourRoundResult = "Your team 2 - 2 Opponents";
	
	String roundBookings = "";
	for(int i = 0; i < 3; i++) {
		roundBookings = roundBookings + i + "th booking" + "\n";
	}
	
	String roundInjuries = "";
	for(int i = 0; i < 3; i++) {
		roundInjuries = roundInjuries + i + "th injury" + "\n";
	}
	
	String otherMatches = "";
	for(int i = 0; i < 20; i = i + 2) {
		if (array1[i].equals(StateManager.getLeague().getChosenTeam()) == false && array1[i+1].equals(StateManager.getLeague().getChosenTeam()) == false) {
			otherMatches = otherMatches + array1[i] + "  vs  " + array1[i+1] + "\n";
		}
	}
	
	System.out.println("Set by filler: 'yourRoundResult' + 'roundBookings' + 'roundInjuries' + 'otherMatches'");	
	String roundResults =
	
	"Here is the result of your match:" +"\n" +
	yourRoundResult + "\n" + "\n" +
			
	"Bookings:" + "\n" +
	roundBookings + "\n" +	"\n" +
	
	"Injuries:" + "\n" +
	roundInjuries +"\n" + "\n" +
	
	"And here are the results of the other matches:" + "\n" +
	otherMatches;
	;
	
	matchResults.setText(roundResults);
	this.add(matchResults);
	
	//Advance
    JButton buttonAdvance = new JButton();
  	c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 4;
  	createButton(buttonAdvance, "Advance", c, layout);
  	attachStateChanger(buttonAdvance, new MenuBetweenRounds());
    }
}
