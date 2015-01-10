package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import rest.ThreadTest;

@SuppressWarnings("serial")
//WORKING WITH FILLER
public class MenuMatchScreen extends State {
	private String ongoingMatchText;

	public MenuMatchScreen() {
    }
	
    public void createGUI() {
    layout = new GridBagLayout();
    this.setLayout(layout);
	c = new GridBagConstraints();
	
	//Prompt Matches
	JTextField progress = new JTextField();
	progress.setOpaque(true);
	progress.setPreferredSize(new Dimension(200, 20));
	progress.setEditable(false);
	progress.setText("There are matches in progress");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
	layout.setConstraints(progress, c);
	this.add(progress);
	
	//Prompt Your Match progress
	JTextArea matchProgress = new JTextArea();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	layout.setConstraints(matchProgress, c);
	matchProgress.setPreferredSize(new Dimension(400, 400));
	matchProgress.setEditable(false);
	String matchProgressTextPart1 = "Here is the progress of your match:\n\n";
	matchProgress.setText( matchProgressTextPart1);
	this.add(matchProgress);
	
	Thread t = new Thread(new ThreadTest());
	rest.ThreadTest.setWorkSpace(matchProgress);
	t.start();
	
	//Advance
    JButton buttonAdvance = new JButton();
  	c.weightx = 0.5;
  	c.gridx = 1;
  	c.gridy = 4;
  	createButton(buttonAdvance, "Advance", c, layout);
  	buttonAdvance.setEnabled(false);
  	attachStateChanger(buttonAdvance, new MenuAftermath());
  	
  	//Advance button logic
  	while(t.isAlive()) {
  		System.out.println("waiting...");
  	}
  	buttonAdvance.setEnabled(true);
  	System.out.println("Thread has finished, advance button has been enabled");
    }

	public String getOngoingMatchText() {
		return ongoingMatchText;
	}

	public void setOngoingMatchText(String ongoingMatchText) {
		this.ongoingMatchText = ongoingMatchText;
	}
    
}
