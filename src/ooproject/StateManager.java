/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooproject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout.Constraints;

/**
 *
 * @author user
 */
public class StateManager {

    public enum States {

	TOURNAMENT_VIEW
    }

    public static void main(String[] args) {
	StateManager sm = new StateManager();
    }

    public StateManager() {
	//State state = new State();
	State state = new TournamentOverview();
	JFrame guiFrame = new JFrame();
	
	guiFrame.add(state);
	guiFrame.setSize(1200, 800);
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Soccer Manager");
	guiFrame.setVisible(true);
    }

}
