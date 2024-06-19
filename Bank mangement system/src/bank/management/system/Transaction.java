package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Transaction extends JFrame implements ActionListener {

	JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
	String pinnumber;

	Transaction(String pinnumber) {
		this.pinnumber = pinnumber;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);

		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		deposit = new JButton("Deposit");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);

		withdrawl = new JButton("withdrawl");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

		fastcash = new JButton("fast cash");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);

		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);

		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);

		exit = new JButton("Exit");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);

		add(image);
		setSize(900, 900);
		setLayout(null);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Transaction("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		} else if (e.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		} else if (e.getSource() == fastcash) {
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);

		} else if (e.getSource() == pinchange) {
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);

		} else if (e.getSource() == balanceenquiry) {
			String amount;
			Conn con = new Conn();
			String query = "select amount from balance where pin=?";
			try {
				PreparedStatement s1 = con.c.prepareStatement(query);
				s1.setString(1, pinnumber);
				ResultSet rs = s1.executeQuery();

				if (rs.next()) {
					amount = rs.getString("amount");
				} else {
					amount = "";
				}
				JOptionPane.showMessageDialog(null, "Your current balance is: " + amount);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == ministatement) {

			Conn con = new Conn();
			StringBuilder sb = new StringBuilder();
			boolean isthere = false;

			String query = "select * from bank where pin=?";
			try {
				PreparedStatement s1 = con.c.prepareStatement(query);
				s1.setString(1, pinnumber);
				ResultSet rs = s1.executeQuery();

				while (rs.next()) {
					String date = rs.getString("date");
					String type = rs.getString("type");
					String amount = rs.getString("amount");
					String str = "Date:" + date + " | type: " + type + " | amount: " + amount + "\n";
					sb.append(str);
					isthere = true;
				}

				if (isthere) {
					JOptionPane.showMessageDialog(null, "Your Transactions are:\n" + sb);
				} else {
					JOptionPane.showMessageDialog(null, "No Transcations done");
				}

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}

}
