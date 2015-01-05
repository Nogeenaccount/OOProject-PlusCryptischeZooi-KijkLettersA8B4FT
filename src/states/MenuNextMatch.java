package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JTable;

//WORKING WITH FILLER
@SuppressWarnings("serial")
public class MenuNextMatch extends State {

	public MenuNextMatch() {
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
    
    //Next matches table Initialize
    String[] array2 = new String[20];
    for(int i = 0; i < array1.length; i++) {
    	if(array1[i].equals(StateManager.getLeague().getChosenTeam()) == false) {
    		array2[i] = array1[i];
    	}
    	else {
    		array2[i] = array1[i].toUpperCase();
    	}
    }
    System.out.println("Next round matches determined by: array2 //filler");
    String[][] data = new String[10][];
    for(int i = 0; i < 20; i = i + 2) {
    	data[i/2] = new String[]{array2[i], "vs", array2[i+1]};
    }
    String[] columnNames = {"First team", "vs", "Second team"};
    
    //Next matches table
    JTable table = new JTable(data, columnNames);
    c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 3;
    layout.setConstraints(table, c);
    table.setPreferredSize(new Dimension(400, 160));
    table.setEnabled(false);
    this.add(table);

    //Advance
    JButton buttonAdvance = new JButton();
  	c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 4;
  	createButton(buttonAdvance, "Advance", c, layout);
  	attachStateChanger(buttonAdvance, new MenuMatchScreen());
    
    //Go back
  	JButton buttonBack = new JButton();
  	c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 5;
  	createButton(buttonBack, "Back", c, layout);
  	attachStateChanger(buttonBack, new MenuBetweenRounds());
    }
}
