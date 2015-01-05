package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//WORKING WITH FILLER
public class MenuTeamManagement extends State {

	public MenuTeamManagement() {
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	//Initialise JComboBoxes
	String[] playerNames = null;
	for(int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
		if(StateManager.getLeague().getChosenTeam().equals(StateManager.getLeague().getTeams().get(i).getTeamName())) {
			playerNames = new String[StateManager.getLeague().getTeams().get(i).getPlayers().size()];
			for (int j = 0; j < StateManager.getLeague().getTeams().get(i).getPlayers().size(); j++) {
				playerNames[j] = StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName();
			}
		}
	}
	JComboBox position1 = new JComboBox(playerNames);
	JComboBox position2 = new JComboBox(playerNames);
	JComboBox position3 = new JComboBox(playerNames);
	JComboBox position4 = new JComboBox(playerNames);
	JComboBox position5 = new JComboBox(playerNames);
	JComboBox position6 = new JComboBox(playerNames);
	JComboBox position7 = new JComboBox(playerNames);
	JComboBox position8 = new JComboBox(playerNames);
	JComboBox position9 = new JComboBox(playerNames);
	JComboBox position10 = new JComboBox(playerNames);
	JComboBox position11 = new JComboBox(playerNames);
	JButton buttonBack = new JButton();

	
	//Position 1 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 1;
	layout.setConstraints(position1, c);
	position1.setPreferredSize(new Dimension(200,20));
	this.add(position1);
	position1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	//Position 2 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 2;
	layout.setConstraints(position2, c);
	position2.setPreferredSize(new Dimension(200,20));
	this.add(position2);
	position2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 3 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 3;
	layout.setConstraints(position3, c);
	this.add(position3);
	position3.setPreferredSize(new Dimension(200,20));
	position3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 4 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 4;
	layout.setConstraints(position4, c);
	this.add(position4);
	position4.setPreferredSize(new Dimension(200,20));
	position4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
		
	//Position 5 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 5;
	layout.setConstraints(position5, c);
	this.add(position5);
	position5.setPreferredSize(new Dimension(200,20));
	position5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 6 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 6;
	layout.setConstraints(position6, c);
	this.add(position6);
	position6.setPreferredSize(new Dimension(200,20));
	position6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 7 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 7;
	layout.setConstraints(position7, c);
	this.add(position7);
	position7.setPreferredSize(new Dimension(200,20));
	position7.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 8 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 8;
	layout.setConstraints(position8, c);
	this.add(position8);
	position8.setPreferredSize(new Dimension(200,20));
	position8.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 9 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 9;
	layout.setConstraints(position9, c);
	this.add(position9);
	position9.setPreferredSize(new Dimension(200,20));
	position9.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Position 10 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 10;
	layout.setConstraints(position10, c);
	this.add(position10);
	position10.setPreferredSize(new Dimension(200,20));
	position10.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});

	//Position 11 JComboBox
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 11;
	layout.setConstraints(position11, c);
	this.add(position11);
	position11.setPreferredSize(new Dimension(200,20));
	position11.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuTeamManagement.backButton(position1, position2, position3, position4, position5, position6, position7, position8, position9, position10, position11, buttonBack);
		}
	});
	
	//Prompt position 1
	JTextField prompt1 = new JTextField();
	prompt1.setOpaque(true);
	prompt1.setPreferredSize(new Dimension(200, 20));
	prompt1.setEditable(false);
	prompt1.setText("Forward 1: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	layout.setConstraints(prompt1, c);
	this.add(prompt1);
	
	//Prompt position 2
	JTextField prompt2 = new JTextField();
	prompt2.setOpaque(true);
	prompt2.setPreferredSize(new Dimension(200, 20));
	prompt2.setEditable(false);
	prompt2.setText("Forward 2: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	layout.setConstraints(prompt2, c);
	this.add(prompt2);
		
	//Prompt position 3
	JTextField prompt3 = new JTextField();
	prompt3.setOpaque(true);
	prompt3.setPreferredSize(new Dimension(200, 20));
	prompt3.setEditable(false);
	prompt3.setText("Forward 3: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
	layout.setConstraints(prompt3, c);
	this.add(prompt3);
	
	//Prompt position 4
	JTextField prompt4 = new JTextField();
	prompt4.setOpaque(true);
	prompt4.setPreferredSize(new Dimension(200, 20));
	prompt4.setEditable(false);
	prompt4.setText("Midfielder 1: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 4;
	layout.setConstraints(prompt4, c);
	this.add(prompt4);
	
	//Prompt position 5
	JTextField prompt5 = new JTextField();
	prompt5.setOpaque(true);
	prompt5.setPreferredSize(new Dimension(200, 20));
	prompt5.setEditable(false);
	prompt5.setText("Midfielder 2: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 5;
	layout.setConstraints(prompt5, c);
	this.add(prompt5);
	
	//Prompt position 6
	JTextField prompt6 = new JTextField();
	prompt6.setOpaque(true);
	prompt6.setPreferredSize(new Dimension(200, 20));
	prompt6.setEditable(false);
	prompt6.setText("Midfielder 3: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 6;
	layout.setConstraints(prompt6, c);
	this.add(prompt6);
	
	//Prompt position 7
	JTextField prompt7 = new JTextField();
	prompt7.setOpaque(true);
	prompt7.setPreferredSize(new Dimension(200, 20));
	prompt7.setEditable(false);
	prompt7.setText("Defender 1: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 7;
	layout.setConstraints(prompt7, c);
	this.add(prompt7);
	
	//Prompt position 8
	JTextField prompt8 = new JTextField();
	prompt8.setOpaque(true);
	prompt8.setPreferredSize(new Dimension(200, 20));
	prompt8.setEditable(false);
	prompt8.setText("Defender 2: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 8;
	layout.setConstraints(prompt8, c);
	this.add(prompt8);
	
	//Prompt position 9
	JTextField prompt9 = new JTextField();
	prompt9.setOpaque(true);
	prompt9.setPreferredSize(new Dimension(200, 20));
	prompt9.setEditable(false);
	prompt9.setText("Defender 3: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 9;
	layout.setConstraints(prompt9, c);
	this.add(prompt9);
	
	//Prompt position 10
	JTextField prompt10 = new JTextField();
	prompt10.setOpaque(true);
	prompt10.setPreferredSize(new Dimension(200, 20));
	prompt10.setEditable(false);
	prompt10.setText("Defender 4: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 10;
	layout.setConstraints(prompt10, c);
	this.add(prompt10);
	
	//Prompt position 11
	JTextField prompt11 = new JTextField();
	prompt11.setOpaque(true);
	prompt11.setPreferredSize(new Dimension(200, 20));
	prompt11.setEditable(false);
	prompt11.setText("Goalkeeper: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 11;
	layout.setConstraints(prompt11, c);
	this.add(prompt11);

	//Go back
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 12;
	createButton(buttonBack, "Back", c, layout);
	buttonBack.setPreferredSize(new Dimension(130, 40));
	buttonBack.setEnabled(false);
	attachStateChanger(buttonBack, new MenuBetweenRounds());
	
	
	
	
//	for (j=0;j<zipcodeList.length;j++)
	//	  for (k=j+1;k<zipcodeList.length;k++)
//		    if (k!=j && zipcodeList[k] == zipcodeList[j])
//		      duplicates=true;
    }
    
    @SuppressWarnings("rawtypes")
	public static void backButton(JComboBox position1, JComboBox position2, JComboBox position3, JComboBox position4, JComboBox position5, JComboBox position6, JComboBox position7, JComboBox position8, JComboBox position9, JComboBox position10, JComboBox position11, JButton buttonBack) {
		String[] selectedPlayers = new String[11];
		selectedPlayers[0] = (String) position1.getSelectedItem();
		selectedPlayers[1] = (String) position2.getSelectedItem();
		selectedPlayers[2] = (String) position3.getSelectedItem();
		selectedPlayers[3] = (String) position4.getSelectedItem();
		selectedPlayers[4] = (String) position5.getSelectedItem();
		selectedPlayers[5] = (String) position6.getSelectedItem();
		selectedPlayers[6] = (String) position7.getSelectedItem();
		selectedPlayers[7] = (String) position8.getSelectedItem();
		selectedPlayers[8] = (String) position9.getSelectedItem();
		selectedPlayers[9] = (String) position10.getSelectedItem();
		selectedPlayers[10] = (String) position11.getSelectedItem();
		
		//Back Button Logic
		boolean duplicates = false;
		for(int i = 0; i < selectedPlayers.length; i++) {
			for (int j = i + 1; j < selectedPlayers.length;j++) {
				if (j != i && selectedPlayers[i].equals(selectedPlayers[j])) {
					duplicates = true;
				}
			}
		}
		if(duplicates == false) {
			System.out.println("You can go back");
			buttonBack.setEnabled(true);
		}
		if(duplicates == true) {
			System.out.println("You can't go back");
			buttonBack.setEnabled(false);
		}
	}
}
