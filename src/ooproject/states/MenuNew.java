/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooproject.states;

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

/**
 *
 * @author user
 */
public class MenuNew extends State{
    public MenuNew(){
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();
	
	Object[] array1 = new Object[20];
	    for(int i = 0; i < 20; i++) {
		array1[i] = "team" + i;
	    }
	
//		@SuppressWarnings({ "rawtypes", "unchecked" })
//		JList list1 = new JList(array1);
//		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		//list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//		list1.setVisibleRowCount(-1);
//		
//		list1.addListSelectionListener(this);
//		this.list1 = list1;
//		
//		JScrollPane listscroller1 = new JScrollPane(list1);
//		listscroller1.setPreferredSize(new Dimension(400, 400));
		
		
        
		JTextField input = new JTextField();
		input.setOpaque(true);
		input.setPreferredSize(new Dimension(200, 20));
		
		c.gridx = 1;
		c.gridy = 0;
		layout.setConstraints(input, c);
		//input.setActionCommand("NewGameName");
		this.add(input);
		
		JList teamList = new JList(array1);
		teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		teamList.setVisibleRowCount(-1);
		//input.setActionCommand("NewGameName");
		JScrollPane teamScroller = new JScrollPane(teamList);
		teamScroller.setPreferredSize(new Dimension(200, 200));
		c.gridx = 1;
		c.gridy = 1;
		layout.setConstraints(teamScroller, c);
		this.add(teamScroller);
		
		JButton buttonAdvance = new JButton();
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		createButton(buttonAdvance, "Advance", c, layout, StateManager.States.TOURNAMENT_VIEW);
		
		//JPanel contentpane2 = new JPanel(new FlowLayout());
		//contentpane2.add(textfield1, BorderLayout.NORTH);
		//contentpane2.add(listscroller1, BorderLayout.CENTER);
		//contentpane2.add(button4, BorderLayout.SOUTH);

		//basicframe.setContentPane(contentpane2);
    }
}
