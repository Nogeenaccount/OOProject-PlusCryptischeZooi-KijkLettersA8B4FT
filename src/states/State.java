/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public abstract class State extends JPanel {	
	JFrame frame;
    GridBagConstraints c = null;
    GridBagLayout layout = null;
    
    protected void createButton(JButton button, String label, 
        GridBagConstraints constraints, GridBagLayout layout){
        button.setText(label);
        button.setPreferredSize(new Dimension(400,100));
        layout.setConstraints(button, constraints);
        this.add(button);
    }
    
    
    protected void attachStateChanger(JButton button, State newState){
	button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.ChangeState(newState);
            }
        });
    }
    
    abstract void createGUI();
}
