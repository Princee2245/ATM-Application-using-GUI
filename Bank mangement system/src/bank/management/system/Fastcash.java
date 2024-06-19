package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener {

	JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
	String pinnumber;

	Fastcash(String pinnumber) {
		this.pinnumber = pinnumber;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);

		JLabel text = new JLabel("select withdrwal amount");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		deposit = new JButton("Rs 100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);

		withdrawl = new JButton("Rs 500");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);

		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);

		ministatement = new JButton("Rs 2000");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);

		balanceenquiry = new JButton("Rs 10000");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);

		exit = new JButton("Back");
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

		new Fastcash("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exit) {
			setVisible(true);
			new Transaction(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton) e.getSource()).getText().substring(3);

			Conn c = new Conn();

			try {

				ResultSet rs = c.s.executeQuery("select * from balance where pin= '" + pinnumber + "'");
				int balance;
				if (rs.next()) {
					balance = rs.getInt("amount");
				} else {
					JOptionPane.showMessageDialog(null, "No record found for the given PIN.");
					balance = -1;
				}

				if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficent balance");
					return;
				}

				String updateQuery = "UPDATE balance SET amount = amount - ? WHERE pin = ?";

				PreparedStatement pstmt = c.c.prepareStatement(updateQuery);
				pstmt.setInt(1, Integer.parseInt(amount));
				pstmt.setString(2, pinnumber);

				pstmt.executeUpdate();

				Date date = new Date();
				String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'withdrawl', '" + amount
						+ "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Sucessfull");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);

			} catch (Exception ae) {
				System.out.println("ae");
			}

		}

	}

}
