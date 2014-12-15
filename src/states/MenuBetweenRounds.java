package states;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MenuBetweenRounds extends State {

    public MenuBetweenRounds() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	JButton buttonNextMatch = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
			//Reference to non-existent state
	//StateManager.States.NEXT_MATCH
	createButton(buttonNextMatch, "Next Match", c, layout);
	attachStateChanger(buttonNextMatch, new MenuMain());

	JButton buttonTransfers = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
			//Reference to non-existent state
	//StateManager.States.TRANSFERS
	createButton(buttonTransfers, "Transfers", c, layout);
	attachStateChanger(buttonTransfers, new MenuMain());

	JButton buttonTeamManagement = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
			//Reference to non-existent state
	//StateManager.States.TEAM_MANAGEMENT
	createButton(buttonTeamManagement, "Team Management", c, layout);
	attachStateChanger(buttonTeamManagement, new MenuMain());

	JButton buttonTourneyOverview = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
			//Reference to non-existent state
	//StateManager.States.TRANSFERS
	createButton(buttonTourneyOverview, "Tourney Overview", c, layout);
	attachStateChanger(buttonTourneyOverview, new MenuMain());

	JButton buttonSave = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 4;
	createButton(buttonSave, "Save", c, layout);
	//attachStateChanger(buttonSave, StateManager.States.BETWEEN_ROUNDS);
	buttonSave.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		StateManager.getLeague().writeToXML("SaveGame.xml");
	    }
	});

	JButton buttonHomeScreen = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 5;
			//Reference to non-existent state
	//StateManager.States.TRANSFERS
	createButton(buttonHomeScreen, "Back to Home Screen", c, layout);
	attachStateChanger(buttonHomeScreen, new MenuMain());

	JTextArea textFieldBudget = new JTextArea();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 6;

	textFieldBudget.setOpaque(true);
	textFieldBudget.setPreferredSize(new Dimension(300, 50));

	int yourBudget = 0;
	String yourTeam = StateManager.getLeague().getChosenTeam();
	for (int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
	    if (StateManager.getLeague().getTeams().get(i).getTeamName().equals(yourTeam)) {
		yourBudget = StateManager.getLeague().getTeams().get(i).getBudget();
	    }
	}

	//Get SomeResult and 
	String display = "Budget: " + yourBudget + "\n" + "Last Result: " + "++Some result++" + "\n" + "Next Opponent: " + "++Some opponent++";

	textFieldBudget.setText(display);
	textFieldBudget.setEditable(false);
	this.add(textFieldBudget);
	layout.setConstraints(textFieldBudget, c);
    }
}
