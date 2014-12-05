import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//VERWIJDER NOOIT GROENE TEKST EN/OF ONGEIMPLEMENTEERDE CODE

public class OwnConverter implements ActionListener, ListSelectionListener{
	private JFrame frame;
	@SuppressWarnings("rawtypes")
	private JList list1;
	private JButton button4;
	private JTextField textfield1;
	
	public OwnConverter(String title) {
		JFrame basicframe = new JFrame(title);
		basicframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = basicframe;
	}
	
	public static void main(String[] args) {
		OwnConverter basicframe = new OwnConverter("Soccer Manager");
		basicframe.createAndShowGUI();
    }
	
	public void createAndShowGUI() {
		this.HomeScreen(this.frame);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	public void HomeScreen(JFrame basicframe) {
		JButton button1 = new JButton();
		button1.setOpaque(true);
		button1.setPreferredSize(new Dimension(400, 100));;
		button1.setBorder(BorderFactory.createRaisedBevelBorder());
		button1.setText("NEW GAME");
		
		button1.setActionCommand("newgame");
		button1.addActionListener(this);
		
		JButton button2 = new JButton();
		button2.setOpaque(true);
		button2.setPreferredSize(new Dimension(400, 100));
		button2.setBorder(BorderFactory.createRaisedBevelBorder());
		button2.setText("CONTINUE");
		
		button2.setActionCommand("continue");
		button2.addActionListener(this);
		
		JButton button3 = new JButton();
		button3.setOpaque(true);
		button3.setPreferredSize(new Dimension(400, 100));
		button3.setBorder(BorderFactory.createRaisedBevelBorder());
		button3.setText("EXIT");
		
		button3.setActionCommand("exit");
		button3.addActionListener(this);
		
		JPanel contentpane1 = new JPanel(new FlowLayout());
		contentpane1.add(button1, BorderLayout.NORTH);
		contentpane1.add(button2, BorderLayout.CENTER);
		contentpane1.add(button3, BorderLayout.SOUTH);
		
		basicframe.setContentPane(contentpane1);
	}
	
	public void NewGame(JFrame basicframe) {
		//LIST INPUT
		Object[] array1 = new Object[20];
		for(int i = 0; i < 20; i++) {
			array1[i] = "team" + i;
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list1 = new JList(array1);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list1.setVisibleRowCount(-1);
		
		list1.addListSelectionListener(this);
		this.list1 = list1;
		
		JScrollPane listscroller1 = new JScrollPane(list1);
		listscroller1.setPreferredSize(new Dimension(400, 400));
		
		JTextField textfield1 = new JTextField();
		textfield1.setOpaque(true);
		textfield1.setPreferredSize(new Dimension(200, 20));
		
		textfield1.setActionCommand("NewGameName");
		this.textfield1 = textfield1;
		
		JButton button4 = new JButton();
		button4.setOpaque(true);
		button4.setPreferredSize(new Dimension(400, 100));;
		button4.setBorder(BorderFactory.createRaisedBevelBorder());
		button4.setText("ADVANCE");
		
		button4.setActionCommand("NewGameAdvance");
		button4.addActionListener(this);
		button4.setEnabled(false);
		this.button4 = button4;
		
		JPanel contentpane2 = new JPanel(new FlowLayout());
		contentpane2.add(textfield1, BorderLayout.NORTH);
		contentpane2.add(listscroller1, BorderLayout.CENTER);
		contentpane2.add(button4, BorderLayout.SOUTH);

		basicframe.setContentPane(contentpane2);
	}
	
	public void BetweenRounds(JFrame basicframe) {
		JButton button5 = new JButton();
		button5.setOpaque(true);
		button5.setPreferredSize(new Dimension(200, 100));
		button5.setBorder(BorderFactory.createRaisedBevelBorder());
		button5.setText("NEXT MATCH");
		
		button5.setActionCommand("BetweenRoundsNextMatch");
		button5.addActionListener(this);
		
		JButton button6 = new JButton();
		button6.setOpaque(true);
		button6.setPreferredSize(new Dimension(200, 100));
		button6.setBorder(BorderFactory.createRaisedBevelBorder());
		button6.setText("TRANSFERS");
		
		button6.setActionCommand("BetweenRoundsTransfers");
		button6.addActionListener(this);
		
		JButton button7 = new JButton();
		button7.setOpaque(true);
		button7.setPreferredSize(new Dimension(200, 100));
		button7.setBorder(BorderFactory.createRaisedBevelBorder());
		button7.setText("TEAM MANAGEMENT");
		
		button7.setActionCommand("BetweenRoundsTeamManagement");
		button7.addActionListener(this);
		
		JButton button8 = new JButton();
		button8.setOpaque(true);
		button8.setPreferredSize(new Dimension(200, 100));
		button8.setBorder(BorderFactory.createRaisedBevelBorder());
		button8.setText("TOURNEY OVERVIEW");
		
		button8.setActionCommand("BetweenRoundsToureyOverview");
		button8.addActionListener(this);
		
		JButton button9 = new JButton();
		button9.setOpaque(true);
		button9.setPreferredSize(new Dimension(200, 100));
		button9.setBorder(BorderFactory.createRaisedBevelBorder());
		button9.setText("SAVE");
		
		button9.setActionCommand("BetweenRoundsSave");
		button9.addActionListener(this);
		
		JButton button10 = new JButton();
		button10.setOpaque(true);
		button10.setPreferredSize(new Dimension(200, 100));
		button10.setBorder(BorderFactory.createRaisedBevelBorder());
		button10.setText("HOME SCREEN");
		
		button10.setActionCommand("BetweenRoundsHomeScreen");
		button10.addActionListener(this);
		
		JTextField textfield2 = new JTextField();
		textfield2.setOpaque(true);
		textfield2.setPreferredSize(new Dimension(150, 20));
		//TEMPORARY TEXT
		String string1 = "Budget: 1000000";
		textfield2.setText(string1);
		textfield2.setEditable(false);
		//NO SET ACTION COMMAND OR LISTENER FOR UNEDITIBLE TEXT FIELD?
		
		JTextField textfield3 = new JTextField();
		textfield3.setOpaque(true);
		textfield3.setPreferredSize(new Dimension(150, 20));
		//TEMPORARY TEXT
		String string2 = "Last result: some result";
		textfield3.setText(string2);
		textfield3.setEditable(false);
		
		JTextField textfield4 = new JTextField();
		textfield4.setOpaque(true);
		textfield4.setPreferredSize(new Dimension(150, 20));
		//TEMPORARY TEXT
		String string3 = "Next opponent: someone";
		textfield4.setText(string3);
		textfield4.setEditable(false);
		
		JPanel contentpane3 = new JPanel(new FlowLayout());
		contentpane3.add(button5);
		contentpane3.add(button6);
		contentpane3.add(button7);
		contentpane3.add(button8);
		contentpane3.add(button9);
		contentpane3.add(button10);
		contentpane3.add(textfield2);
		contentpane3.add(textfield3);
		contentpane3.add(textfield4);
		
		basicframe.setContentPane(contentpane3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("newgame".equals(e.getActionCommand())) {
			//Press New Game on HomeScreen
			this.NewGame(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		else if ("continue".equals(e.getActionCommand())) {
			//Press Continue on HomeScreen
			//Load safe file:
			this.BetweenRounds(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		else if ("exit".equals(e.getActionCommand())) {
			//Press Exit on HomeScreen
			//Save state to safe file
			this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
		}
		else if ("NewGameAdvance".equals(e.getActionCommand())) {
			//Press Advance on NewGame
			//Copy resource file to save file + add team + add save file name
			this.BetweenRounds(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		else if ("BetweenRoundsNextMatch".equals(e.getActionCommand())) {
			//Press Next Match on BetweenRounds
			//this.NextMatch(this.frame);
			//this.frame.pack();
			//this.frame.setVisible(true);
		}
		else if ("BetweenRoundsTransfers".equals(e.getActionCommand())) {
			//Press Transfers on BetweenRounds
			//this.Transfers(this.frame);
			//this.frame.pack();
			//this.frame.setVisible(true);
		}
		else if ("BetweenRoundsTeamManagement".equals(e.getActionCommand())) {
			//Press Team Management on BetweenRounds
			//this.TeamManagement(this.frame);
			//this.frame.pack();
			//this.frame.setVisible(true);
		}
		else if ("BetweenRoundsToureyOverview".equals(e.getActionCommand())) {
			//Press Tourney Overview on BetweenRounds
			//this.TourneyOverview(this.frame);
			//this.frame.pack();
			//this.frame.setVisible(true);
		}
		else if ("BetweenRoundsSave".equals(e.getActionCommand())) {
			//Press Save on BetweenRounds
			//Save state to save file
		}
		else if ("BetweenRoundsHomeScreen".equals(e.getActionCommand())) {
			//Press Home Screen on BetweenRounds
			this.HomeScreen(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		//else if (this.list1.getSelectedIndex() != -1 && this.textfield1.getText().equals("") != true && "NewGameName".equals(e.getActionCommand())) {
		//	System.out.println("Test");
		//	this.button4.setEnabled(true);
		//	this.frame.pack();
		//	this.frame.setVisible(true);
		//}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting() == false) {
			if(this.list1.getSelectedIndex() != -1 && this.textfield1.getText().equals("") != true) {
				this.button4.setEnabled(true);
				this.frame.pack();
				this.frame.setVisible(true);
			}
			else {
				this.button4.setEnabled(false);
				this.frame.pack();
				this.frame.setVisible(true);
			}
		}
	}
}