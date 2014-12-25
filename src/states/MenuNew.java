/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import rest.Launcher;
import rest.League;

/**
 *
 * @author user
 */
public class MenuNew extends State {

    JTextField input = new JTextField();
    JList teamList;
    JButton buttonAdvance = new JButton();
    JButton buttonBack = new JButton();


    public MenuNew() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	String[] array1 = new String[20];
	League league1 = League.readResources("ResourceV6.xml");
	for(int i = 0; i < league1.getTeams().size(); i++) {
	    array1[i] = league1.getTeams().get(i).getTeamName();
	}
	input.setOpaque(true);
	input.setPreferredSize(new Dimension(200, 20));
	input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons();
            }
        });
	
	c.gridx = 1;
	c.gridy = 0;
	layout.setConstraints(input, c);
	//input.setActionCommand("NewGameName");
	this.add(input);

	//create teamlist
	teamList = new JList(array1);
	teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	teamList.setVisibleRowCount(-1);
	JScrollPane teamScroller = new JScrollPane(teamList);
	teamScroller.setPreferredSize(new Dimension(200, 200));
	c.gridx = 1;
	c.gridy = 1;
	layout.setConstraints(teamScroller, c);
	this.add(teamScroller);
	teamList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                enableButtons();
            }
        });
	
	
	//create advancebutton
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	createButton(buttonAdvance, "Advance", c, layout);
	attachStateChanger(buttonAdvance, new MenuMain());
	
	//create backbutton
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
	createButton(buttonBack, "Back", c, layout);
	attachStateChanger(buttonBack, new MenuMain());
    }
    
    public void enableButtons(){
	if(teamList.isSelectionEmpty() == false && input.getText().equals("") == false) {
	    buttonAdvance.setEnabled(true);
	}
	else{
	    buttonAdvance.setEnabled(false);
	}
    }
    
}
