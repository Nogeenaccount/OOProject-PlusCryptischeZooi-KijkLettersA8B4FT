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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MenuMain extends State {

    JButton buttonNew = new JButton();
    JButton buttonContinue = new JButton();
    JButton buttonExit = new JButton();

    public MenuMain() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	//new game button
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
	createButton(buttonNew, "New game", c, layout);
	attachStateChanger(buttonNew, new MenuNew());

	//continue game button
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	createButton(buttonContinue, "Continue game", c, layout);
	attachStateChanger(buttonContinue, new MenuBetweenRounds());
	
	//exitbutton
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	createButton(buttonExit, "Exit", c, layout);
	attachStateChanger(buttonExit, new Exit());
    }

    public void enableButtons() {
	try {
	    BufferedReader br = new BufferedReader(new FileReader("SaveGame.xml"));
	    String tonton = br.readLine();
	    //System.out.println(tonton);
	    if (tonton == null) {
		//System.out.println(tonton);
		buttonContinue.setEnabled(false);
	    }
	    br.close();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
    }
}
