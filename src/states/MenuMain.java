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
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class MenuMain extends State {

    public MenuMain() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();

	JButton buttonNew = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
	createButton(buttonNew, "New game", c, layout);
	attachStateChanger(buttonNew, new MenuNew());

	JButton buttonContinue = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	createButton(buttonContinue, "Continue game", c, layout);
	attachStateChanger(buttonContinue, new MenuBetweenRounds());

	JButton buttonExit = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	createButton(buttonExit, "Exit", c, layout);
	attachStateChanger(buttonExit, new Exit());
    }
}
