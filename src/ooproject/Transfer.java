import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Screens for transfering a player
 * 
 * @author Dammeijer
 *
 */
public class Transfer implements ActionListener, ListSelectionListener {
	private JFrame frame;
	@SuppressWarnings("rawtypes")
	private JList list1;
	@SuppressWarnings("rawtypes")
	private JList list2;
	private JButton buy;
	private JLabel budget = new JLabel("budget");
	private JButton sell;

	public Transfer(String title) {
		JFrame transferFrame = new JFrame(title);
		transferFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = transferFrame;
	}

	public static void main(String[] args) {
		Transfer transferFrame = new Transfer("Transfer");
		transferFrame.createAndShowGUI();
	}

	/**
	 * main transferscreen
	 * 
	 * @param transferFrame
	 */
	public void TransferScreen(JFrame transferFrame) {
		JButton button1 = new JButton();
		button1.setOpaque(true);
		button1.setPreferredSize(new Dimension(400, 100));
		button1.setBorder(BorderFactory.createRaisedBevelBorder());
		button1.setText("Buy Player");

		button1.setActionCommand("buyplayer");
		button1.addActionListener(this);

		JButton button2 = new JButton();
		button2.setOpaque(true);
		button2.setPreferredSize(new Dimension(400, 100));
		button2.setBorder(BorderFactory.createRaisedBevelBorder());
		button2.setText("Sell Player");

		button2.setActionCommand("sellplayer");
		button2.addActionListener(this);

		JPanel contentpanel = new JPanel(new FlowLayout());
		contentpanel.add(budget, BorderLayout.NORTH);
		contentpanel.add(button1, BorderLayout.CENTER);
		contentpanel.add(button2, BorderLayout.SOUTH);

		transferFrame.setContentPane(contentpanel);

	}

	/**
	 * Screen if you want to sell a player
	 * 
	 * @param basicframe
	 */
	public void sellPlayer(JFrame basicframe) {
		Object[] array2 = new Object[20];
		for (int i = 0; i < 20; i++) {
			array2[i] = "player" + i;
		}

		/**
		 * the List should containts all the players in your team.
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list2 = new JList(array2);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setVisibleRowCount(-1);

		list2.addListSelectionListener(this);
		this.list2 = list2;

		JScrollPane listscroller2 = new JScrollPane(list2);
		listscroller2.setPreferredSize(new Dimension(400, 200));

		/**
		 * the comparator options, need to be linked with the SORT button and
		 * the Comparator
		 */
		String[] options = { "Position", "Price", "Overal stats" };
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox box = new JComboBox(options);

		JButton sort = new JButton();
		sort.setOpaque(true);
		sort.setPreferredSize(new Dimension(50, 50));
		sort.setBorder(BorderFactory.createRaisedBevelBorder());
		sort.setText("SORT");

		JButton sell = new JButton();
		sell.setOpaque(true);
		sell.setPreferredSize(new Dimension(50, 50));
		sell.setBorder(BorderFactory.createRaisedBevelBorder());
		sell.setText("Buy");
		sell.setEnabled(false);
		sell.setActionCommand("advance");
		sell.addActionListener(this);
		this.sell = sell;

		/**
		 * basic frame and set up.
		 */
		JPanel contentpanel2 = new JPanel(new FlowLayout());
		contentpanel2.add(box, BorderLayout.CENTER);
		contentpanel2.add(sort, BorderLayout.NORTH);
		contentpanel2.add(listscroller2, BorderLayout.SOUTH);
		contentpanel2.add(sell, BorderLayout.EAST);
		contentpanel2.add(budget, BorderLayout.NORTH);

		basicframe.setContentPane(contentpanel2);

	}

	/**
	 * Screen if you want to buy a player
	 * 
	 * @param basicframe
	 */
	public void BuyPlayer(JFrame basicframe) {

		// input league
		Object[] array1 = new Object[20];
		for (int i = 0; i < 20; i++) {
			array1[i] = "player" + i;
		}

		/**
		 * the list should contain all buyable players in the league
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list1 = new JList(array1);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setVisibleRowCount(-1);

		list1.addListSelectionListener(this);
		this.list1 = list1;

		JScrollPane listscroller1 = new JScrollPane(list1);
		listscroller1.setPreferredSize(new Dimension(400, 200));

		/**
		 * the options to sort the list using the comparators.
		 */
		String[] options = { "Team", "Postion", "Price", "Offense", "Defence",
				"Overal stats" };
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox box = new JComboBox(options);

		JButton sort = new JButton();
		sort.setOpaque(true);
		sort.setPreferredSize(new Dimension(50, 50));
		sort.setBorder(BorderFactory.createRaisedBevelBorder());
		sort.setText("SORT");

		JButton buy = new JButton();
		buy.setOpaque(true);
		buy.setPreferredSize(new Dimension(50, 50));
		buy.setBorder(BorderFactory.createRaisedBevelBorder());
		buy.setText("Buy");
		buy.setEnabled(false);
		buy.setActionCommand("advance");
		buy.addActionListener(this);
		this.buy = buy;

		/**
		 * basic panel
		 */
		JPanel contentpanel2 = new JPanel(new FlowLayout());
		contentpanel2.add(box, BorderLayout.CENTER);
		contentpanel2.add(sort, BorderLayout.NORTH);
		contentpanel2.add(listscroller1, BorderLayout.SOUTH);
		contentpanel2.add(buy, BorderLayout.EAST);
		contentpanel2.add(budget, BorderLayout.NORTH);

		basicframe.setContentPane(contentpanel2);

	}

	public void createAndShowGUI() {
		this.TransferScreen(this.frame);
		this.frame.pack();
		this.frame.setVisible(true);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (this.list1.getSelectedIndex() != -1) { // if there is anything
													// selected you can buy, but
													// there must be a budget
													// check also!!
			this.buy.setEnabled(true);
			this.frame.pack();
			this.frame.setVisible(true);
		} else {
			this.buy.setEnabled(false);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		if (this.list2.getSelectedIndex() != -1) {// if there is anything
													// selected you can buy, but
													// there must be a budget
													// check also!!
			this.sell.setEnabled(true);
			this.frame.pack();
			this.frame.setVisible(true);
		} else {
			this.sell.setEnabled(false);
			this.frame.pack();
			this.frame.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("buyplayer".equals(e.getActionCommand())) {
			// Press Buy Player on screen
			this.BuyPlayer(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		if ("advance".equals(e.getActionCommand())) {
			// after you bought or sold a player returns to main transfer
			// screen, Would be better to have a pop-up asking:do you want to
			// buy/sell a nother player!
			this.TransferScreen(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);
		}
		if ("sellplayer".equals(e.getActionCommand())) {
			// Press sell player on screen
			this.sellPlayer(this.frame);
			this.frame.pack();
			this.frame.setVisible(true);

		}

	}
}
