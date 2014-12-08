/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooproject.states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class State extends JPanel {
    
    GridBagConstraints c = null;
    GridBagLayout layout = null;
    
    protected void createButton(JButton button, String label, 
            GridBagConstraints constraints, GridBagLayout layout, StateManager.States newState){
        button.setText(label);
        button.setPreferredSize(new Dimension(200,50));
        layout.setConstraints(button, constraints);
	
	button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.ChangeState(newState);
            }
        });
	
        this.add(button);
    }
    
}
