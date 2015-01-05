/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author user
 */
//WORKING
public class MenuNew extends State {

    public MenuNew() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	//Initialise
	String[] array1 = new String[20];
	rest.League league1 = rest.League.readResources("ResourceV6.xml");
    for(int i = 0; i < league1.getTeams().size(); i++) {
    	array1[i] = league1.getTeams().get(i).getTeamName();
    }
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList teamList = new JList(array1);
	JButton buttonAdvance = new JButton();
	
	//Prompt name
	JTextField gameName = new JTextField();
	gameName.setOpaque(true);
	gameName.setPreferredSize(new Dimension(200, 20));
	gameName.setEditable(false);
	gameName.setText("Please enter your name:");
	c.gridx = 1;
	c.gridy = 0;
	layout.setConstraints(gameName, c);
	this.add(gameName);
	
	//Enter your name
	JTextField input = new JTextField();
	input.setOpaque(true);
	input.setPreferredSize(new Dimension(200, 20));
	c.gridx = 1;
	c.gridy = 1;
	layout.setConstraints(input, c);
	this.add(input);
	input.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(teamList.isSelectionEmpty() == false && input.getText().equals("") == false) {
				buttonAdvance.setEnabled(true);
			}
			if(teamList.isSelectionEmpty() || input.getText().equals("")) {
				buttonAdvance.setEnabled(false);
			}
		}
	});
	
	//Prompt team
	JTextField teamName = new JTextField();
	teamName.setOpaque(true);
	teamName.setPreferredSize(new Dimension(200, 20));
	teamName.setEditable(false);
	teamName.setText("Please choose your team:");
	c.gridx = 1;
	c.gridy = 2;
	layout.setConstraints(teamName, c);
	this.add(teamName);
	
	//Team list
	teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	teamList.setVisibleRowCount(-1);
	JScrollPane teamScroller = new JScrollPane(teamList);
	teamScroller.setPreferredSize(new Dimension(200, 200));
	c.gridx = 1;
	c.gridy = 3;
	layout.setConstraints(teamScroller, c);
	this.add(teamScroller);
	teamList.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (teamList.isSelectionEmpty() == false && input.getText().equals("") == false) {
				buttonAdvance.setEnabled(true);
		      }
			if(teamList.isSelectionEmpty() || input.getText().equals("")) {
				buttonAdvance.setEnabled(false);
			}
		}
	    });
	
	//Advance
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 4;
	createButton(buttonAdvance, "Advance", c, layout);
	attachStateChanger(buttonAdvance, new MenuBetweenRounds());
	buttonAdvance.setEnabled(false);
	buttonAdvance.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			PrintWriter writer;
			try {
				writer = new PrintWriter("SaveGame.xml");
				writer.print("");
				writer.close();
			} catch (FileNotFoundException error) {
				error.printStackTrace();
			}
			
			StateManager.setLeague(rest.League.readResources("ResourceV6.xml"));
			StateManager.getLeague().setGameName(input.getText());
			StateManager.getLeague().setChosenTeam(teamList.getSelectedValue().toString());
			StateManager.getLeague().writeToXML("SaveGame.xml");
		}
	});
	
	//Go back
	JButton buttonBack = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 5;
	createButton(buttonBack, "Back", c, layout);
	attachStateChanger(buttonBack, new MenuMain());
    }
}
