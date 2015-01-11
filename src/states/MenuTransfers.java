package states;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
//WORKING WITH FILLER

	public MenuTransfers() {
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void createGUI() {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints();
	
	//Initialise
	String[] array1 = new String[20];
	rest.League league1 = rest.League.readResources("SaveGame.xml");
    for(int i = 0; i < league1.getTeams().size(); i++) {
    	array1[i] = league1.getTeams().get(i).getTeamName();
    }
    ArrayList<String> playerArray = new ArrayList();
	JTextField teamPrompt = new JTextField();
	JList playerList = new JList();
	JTextField playerPrompt = new JTextField();
	JTextField attemptPricePrompt = new JTextField();
	String[] buyOrSell = {"Buy", "Sell"};
	JList buyOrSellList = new JList(buyOrSell);
	JList teamList = new JList(array1);
	JTextField attemptPrice = new JTextField();
	JButton buttonAttempt = new JButton();
	ArrayList<String> alreadyTried = new ArrayList();
	
	//Prompt Budget
	int yourBudget = 0;
	String yourTeam = StateManager.getLeague().getChosenTeam();
	for (int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
	    if (StateManager.getLeague().getTeams().get(i).getTeamName().equals(yourTeam)) {
		yourBudget = StateManager.getLeague().getTeams().get(i).getBudget();
	    }
	}
	String budgetDisplayText = "Your budget: " + yourBudget;
	JTextField budgetDisplay = new JTextField();
	budgetDisplay.setOpaque(true);
	budgetDisplay.setPreferredSize(new Dimension(400, 20));
	budgetDisplay.setEditable(false);
	budgetDisplay.setText(budgetDisplayText);
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 0;
	layout.setConstraints(budgetDisplay, c);
	this.add(budgetDisplay);
	
	//Prompt Buying or selling
	JTextField buyOrSellPrompt = new JTextField();
	buyOrSellPrompt.setOpaque(true);
	buyOrSellPrompt.setPreferredSize(new Dimension(400, 20));
	buyOrSellPrompt.setEditable(false);
	buyOrSellPrompt.setText("Please choose whether to buy or sell a player: ");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	layout.setConstraints(buyOrSellPrompt, c);
	this.add(buyOrSellPrompt);
	
	//Buy or Sell list
	buyOrSellList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	buyOrSellList.setVisibleRowCount(-1);
	buyOrSellList.setPreferredSize(new Dimension(400, 40));
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 2;
	layout.setConstraints(buyOrSellList, c);
	this.add(buyOrSellList);
	buyOrSellList.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(buyOrSellList.getValueIsAdjusting() && buyOrSellList.getSelectedValue().equals("Buy") && teamList.isSelectionEmpty() == false) {
				playerArray.clear();
				for(int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
					if(teamList.getSelectedValue().equals(StateManager.getLeague().getTeams().get(i).getTeamName())) {
						playerPrompt.setText("Please select a player from this team:");
						for(int j = 0; j < StateManager.getLeague().getTeams().get(i).getPlayers().size(); j++) {
							playerArray.add(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							//System.out.println(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							String[] playerArrayNotList = new String[playerArray.size()];
							for(int m = 0; m < playerArray.size(); m++) {
								playerArrayNotList[m] = playerArray.get(m);
							}
							playerList.setListData(playerArrayNotList);
							attemptPricePrompt.setText("---");
							attemptPrice.setEditable(false);
							buttonAttempt.setEnabled(false);
						}
					}
				}
			}
			
			if(buyOrSellList.getValueIsAdjusting() && buyOrSellList.getSelectedValue().equals("Sell") && teamList.isSelectionEmpty() == false) {
				playerArray.clear();
				for(int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
					if(StateManager.getLeague().getChosenTeam().equals(StateManager.getLeague().getTeams().get(i).getTeamName())) {
						playerPrompt.setText("Please select a player from your team:");
						for(int j = 0; j < StateManager.getLeague().getTeams().get(i).getPlayers().size(); j++) {
							playerArray.add(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							String[] playerArrayNotList = new String[playerArray.size()];
							for(int m = 0; m < playerArray.size(); m++) {
								playerArrayNotList[m] = playerArray.get(m);
							}
							playerList.setListData(playerArrayNotList);
							attemptPricePrompt.setText("---");
							attemptPrice.setEditable(false);
							buttonAttempt.setEnabled(false);
						}
					}
				}
			}
			if(buyOrSellList.getSelectedIndex() == 0 && buyOrSellList.getValueIsAdjusting()) {
				teamPrompt.setText("Please choose a team to buy a player from: ");
				System.out.println(buyOrSellList.getSelectedValue());
			}
			if(buyOrSellList.getSelectedIndex() == 1 && buyOrSellList.getValueIsAdjusting()) {
				teamPrompt.setText("Please choose a team to sell a player to: ");
				System.out.println(buyOrSellList.getSelectedValue());
			}
			if(teamList.isSelectionEmpty() == false && buyOrSellList.isSelectionEmpty() == false && playerList.isSelectionEmpty() == false) {
				attemptPricePrompt.setText("For what price would you like to try this?");
				attemptPrice.setEditable(true);
				buttonAttempt.setEnabled(true);
			}
		}
	});
	
	//Prompt choosing a team
	teamPrompt.setOpaque(true);
	teamPrompt.setPreferredSize(new Dimension(400, 20));
	teamPrompt.setEditable(false);
	teamPrompt.setText("---");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
	layout.setConstraints(teamPrompt, c);
	this.add(teamPrompt);
	
	//Choosing a team to buy/sell with
	teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	teamList.setVisibleRowCount(-1);
	JScrollPane teamScroller = new JScrollPane(teamList);
	teamScroller.setPreferredSize(new Dimension(400, 200));
	c.gridx = 1;
	c.gridy = 4;
	layout.setConstraints(teamScroller, c);
	this.add(teamScroller);
	teamList.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			//exception occurs here
			if(teamList.getValueIsAdjusting() && buyOrSellList.getSelectedValue().equals("Buy")) {
				playerArray.clear();
				for(int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
					if(teamList.getSelectedValue().equals(StateManager.getLeague().getTeams().get(i).getTeamName())) {
						playerPrompt.setText("Please select a player from this team:");
						for(int j = 0; j < StateManager.getLeague().getTeams().get(i).getPlayers().size(); j++) {
							playerArray.add(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							//System.out.println(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							String[] playerArrayNotList = new String[playerArray.size()];
							for(int m = 0; m < playerArray.size(); m++) {
								playerArrayNotList[m] = playerArray.get(m);
							}
							playerList.setListData(playerArrayNotList);
							attemptPricePrompt.setText("---");
							attemptPrice.setEditable(false);
							buttonAttempt.setEnabled(false);
						}
					}
				}
			}
			if(teamList.getValueIsAdjusting() && buyOrSellList.getSelectedValue().equals("Sell")) {
				playerArray.clear();
				for(int i = 0; i < StateManager.getLeague().getTeams().size(); i++) {
					if(StateManager.getLeague().getChosenTeam().equals(StateManager.getLeague().getTeams().get(i).getTeamName())) {
						playerPrompt.setText("Please select a player from your team:");
						for(int j = 0; j < StateManager.getLeague().getTeams().get(i).getPlayers().size(); j++) {
							playerArray.add(StateManager.getLeague().getTeams().get(i).getPlayers().get(j).getPlayerName());
							String[] playerArrayNotList = new String[playerArray.size()];
							for(int m = 0; m < playerArray.size(); m++) {
								playerArrayNotList[m] = playerArray.get(m);
							}
							playerList.setListData(playerArrayNotList);
							attemptPricePrompt.setText("---");
							attemptPrice.setEditable(false);
							buttonAttempt.setEnabled(false);
						}
					}
				}
			}
			if(teamList.isSelectionEmpty() == false && buyOrSellList.isSelectionEmpty() == false && playerList.isSelectionEmpty() == false) {
				attemptPricePrompt.setText("For what price would you like to try this?");
				attemptPrice.setEditable(true);
				buttonAttempt.setEnabled(true);
			}
		}
	});
	
	//Prompt choosing a player
	playerPrompt.setOpaque(true);
	playerPrompt.setPreferredSize(new Dimension(400, 20));
	playerPrompt.setEditable(false);
	playerPrompt.setText("---");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 5;
	layout.setConstraints(playerPrompt, c);
	this.add(playerPrompt);
	
	
	//Choosing a player to buy/sell
	playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	playerList.setVisibleRowCount(-1);
	JScrollPane playerScroller = new JScrollPane(playerList);
	playerScroller.setPreferredSize(new Dimension(400, 200));
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 6;
	layout.setConstraints(playerScroller, c);
	this.add(playerScroller);
	playerList.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(teamList.isSelectionEmpty() == false && buyOrSellList.isSelectionEmpty() == false && playerList.isSelectionEmpty() == false) {
				attemptPricePrompt.setText("For what price would you like to try this?");
				attemptPrice.setEditable(true);
				buttonAttempt.setEnabled(true);
			}
		}
	});
	
	//Prompt price attempt
	attemptPricePrompt.setOpaque(true);
	attemptPricePrompt.setPreferredSize(new Dimension(400, 20));
	attemptPricePrompt.setEditable(false);
	attemptPricePrompt.setText("---");
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 7;
	layout.setConstraints(attemptPricePrompt, c);
	this.add(attemptPricePrompt);
	
	//Price for attempt
	attemptPrice.setOpaque(true);
	attemptPrice.setPreferredSize(new Dimension(400, 20));
	attemptPrice.setEditable(false);
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 8;
	layout.setConstraints(attemptPrice, c);
	this.add(attemptPrice);
	
	//Attempt action
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 9;
	createButton(buttonAttempt, "Attempt", c, layout);
	buttonAttempt.setEnabled(false);
	buttonAttempt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(alreadyTried.contains(playerList.getSelectedValue()) == false) {
				System.out.println("Attempt to buy or sell made: " + buyOrSellList.getSelectedValue() + ", "+ playerList.getSelectedValue() + " from/to " + teamList.getSelectedValue());
				alreadyTried.add((String) playerList.getSelectedValue());
				System.out.println(alreadyTried);
			}
		}
	});
	
	//Go back
	JButton buttonBack = new JButton();
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 10;
	createButton(buttonBack, "Back", c, layout);
	buttonBack.setPreferredSize(new Dimension(400, 50));
	attachStateChanger(buttonBack, new MenuBetweenRounds());
	
    }
}
