import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
		}
		else if ("exit".equals(e.getActionCommand())) {
			//Press Exit on HomeScreen
			this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
		}
		else if ("NewGameAdvance".equals(e.getActionCommand())) {
			//Press Exit on NewGame
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