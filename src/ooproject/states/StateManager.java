/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooproject.states;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout.Constraints;

/**
 *
 * @author user
 */
public class StateManager {

    static State currentState;
    static JFrame guiFrame = new JFrame();
    //public static StateManager statemanager = new StateManager();
    
    public enum States {
	MAIN_MENU, NEW_GAME, TOURNAMENT_VIEW, EXIT;
    }

    public StateManager() {
	currentState = new MenuMain();	
	guiFrame.add(currentState);
	guiFrame.setSize(1200, 800);
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Soccer Manager");
	guiFrame.setVisible(true);
    }

    public static void ChangeState(States requestedState){
	State newState = null;
	switch(requestedState){
            case MAIN_MENU:
            	newState = new MenuMain();
            break;
	    case NEW_GAME:
            	newState = new MenuNew();
            break;
	    case TOURNAMENT_VIEW:
            	newState = new TournamentOverview();
            break;
	    case EXIT:
            	System.exit(0);
            break;
	}
	guiFrame.remove(currentState);
	guiFrame.add(newState);
	guiFrame.validate();
    }
    
    public static void main(String[] args) {
	StateManager sm = new StateManager();
    }
}