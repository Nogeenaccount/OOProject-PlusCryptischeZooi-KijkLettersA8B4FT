/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import rest.League;

/**
 *
 * @author user
 */
//FINISHED
public class MenuMain extends State {

    public MenuMain() {

    }

    public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();
	
	JTextArea invisi2 = new JTextArea();
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 2;
	layout.setConstraints(invisi2, c);
	invisi2.setPreferredSize(new Dimension(200, 200));
	invisi2.setOpaque(false);
	invisi2.setEditable(false);
	invisi2.setMargin(new Insets(200, 0, 0, 0));
	this.add(invisi2);
	
	JButton buttonNew = new JButton(new ImageIcon("C:\\Users\\Stefan\\Desktop\\GUIFiles\\NewGameButton.png"));
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 3;
	createButton(buttonNew, "", c, layout);
	buttonNew.setMargin(new Insets(0, 0, 0, 0));
	buttonNew.setMaximumSize(new Dimension(400, 80));
	attachStateChanger(buttonNew, new MenuNew());

	JButton buttonContinue = new JButton(new ImageIcon("C:\\Users\\Stefan\\Desktop\\GUIFiles\\ContinueButton.png"));
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 4;
	
	try {
    	BufferedReader br = new BufferedReader(new FileReader("SaveGame.xml"));
    	String tonton = br.readLine();
		if (tonton == null) {
		    buttonContinue.setEnabled(false);
		}
		br.close();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	createButton(buttonContinue, "", c, layout);
	buttonContinue.setMargin(new Insets(0, 0, 0, 0));
	buttonContinue.setMaximumSize(new Dimension(400, 100));
	attachStateChanger(buttonContinue, new MenuBetweenRounds());
	buttonContinue.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		StateManager.setLeague(League.readResources("SaveGame.xml"));;
	    }
	});
	
	JButton buttonExit = new JButton(new ImageIcon("C:\\Users\\Stefan\\Desktop\\GUIFiles\\ExitButton.png"));
	c.weightx = 0.5;
	c.gridx = 2;
	c.gridy = 5;
	//"<html><font size='6'>Exit</font></html>"
	createButton(buttonExit, "", c, layout);
	buttonExit.setMargin(new Insets(0, 0, 0, 0));
	buttonExit.setMaximumSize(new Dimension(400, 100));
	attachStateChanger(buttonExit, new Exit());
	
	c.weightx = 0.5;
	c.gridheight = 6;
	c.gridwidth = 3;
	c.gridx = 2;
	c.gridy = 1;
	ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\Stefan\\Desktop\\GUIFiles\\FootbalStadiumSize.png").getImage(), c, layout);
	this.add(panel);
	
	//System.out.println(result());
    }
}
