package bank.management.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {

	JRadioButton r1, r2, r3, r4;

	JCheckBox c1, c2, c3, c4, c5, c6, c7;

	JButton submit, cancel;
	String formno;

	public SignupThree(String formno) {
		this.formno = formno;
		JLabel l1 = new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Railway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);

		JLabel type = new JLabel("Account type");
		type.setFont(new Font("Railway", Font.BOLD, 22));
		type.setBounds(100, 140, 200, 30);
		add(type);

		r1 = new JRadioButton("Savings");
		r1.setBounds(100, 180, 150, 20);
		add(r1);

		r2 = new JRadioButton("Fixed Deposit");
		r2.setBounds(350, 180, 200, 30);
		add(r2);

		r3 = new JRadioButton("current");
		r3.setBounds(100, 220, 250, 30);
		add(r3);

		r4 = new JRadioButton("Recurring Deposit account");
		r4.setBounds(350, 220, 250, 30);
		add(r4);

		ButtonGroup accounttype = new ButtonGroup();
		accounttype.add(r1);
		accounttype.add(r2);
		accounttype.add(r3);
		accounttype.add(r4);

		JLabel card = new JLabel("Card No");
		card.setFont(new Font("Railway", Font.BOLD, 22));
		card.setBounds(100, 300, 200, 30);
		add(card);

		JLabel number = new JLabel("XXXX-XXXX-XXXX-4134");
		number.setFont(new Font("Railway", Font.BOLD, 22));
		number.setBounds(330, 300, 300, 30);
		add(number);

		JLabel cardDetail = new JLabel("This is your 16 Digit card number");
		cardDetail.setFont(new Font("Railway", Font.BOLD, 12));
		cardDetail.setBounds(100, 330, 300, 20);
		add(cardDetail);

		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Railway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		add(pin);

		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Railway", Font.BOLD, 22));
		pnumber.setBounds(330, 370, 300, 30);
		add(pnumber);

		JLabel pindeatils = new JLabel("This is your 4 Digit Password");
		pindeatils.setFont(new Font("Railway", Font.BOLD, 12));
		pindeatils.setBounds(100, 400, 300, 20);
		add(pindeatils);

		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Railway", Font.BOLD, 22));
		services.setBounds(100, 450, 200, 30);
		add(services);

		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Railway", Font.BOLD, 16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);

		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Railway", Font.BOLD, 16));
		c1.setBounds(100, 500, 200, 30);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Railway", Font.BOLD, 16));
		c2.setBounds(350, 500, 200, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Railway", Font.BOLD, 16));
		c3.setBounds(100, 550, 230, 30);
		add(c3);

		c4 = new JCheckBox("Email Alerts");
		c4.setFont(new Font("Railway", Font.BOLD, 16));
		c4.setBounds(350, 500, 200, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Railway", Font.BOLD, 16));
		c5.setBounds(100, 600, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Railway", Font.BOLD, 16));
		c6.setBounds(350, 600, 200, 30);
		add(c6);

		c7 = new JCheckBox("I herby declares the above entred details are correct");
		c7.setFont(new Font("Railway", Font.BOLD, 16));
		c7.setBounds(100, 680, 600, 30);
		add(c7);

		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Railway", Font.BOLD, 14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);

		submit = new JButton("Submit");
		submit.setFont(new Font("Railway", Font.BOLD, 14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);

		add(cancel);
		add(submit);

		setLayout(null);
		setSize(850, 820);
		setLocation(350, 0);
		setVisible(true);

	}

	public static void main(String[] args) {
		new SignupThree("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			String accountType = null;

			if (r1.isSelected()) {
				accountType = "Saving Account";
			} else if (r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if (r3.isSelected()) {
				accountType = "Current Account";
			} else if (r4.isSelected()) {
				accountType = "Recurring Account";
			}

			Random random = new Random();

			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			String pinnumber = "" + Math.abs(random.nextLong() % 9000L) + 1000L;

			String facility = "";

			if (c1.isSelected()) {
				facility += "ATM CARD";
			} else if (c2.isSelected()) {
				facility += " Internet Banking";
			} else if (c3.isSelected()) {
				facility += " Mobile Banking";
			} else if (c4.isSelected()) {
				facility += " EMAIL ALERTS";
			} else if (c5.isSelected()) {
				facility += " Cheque Book";
			} else if (c6.isSelected()) {
				facility += " E-StateMent";
			}

			try {

				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account type is required");

				} else {
					Conn con = new Conn();
					String query1 = "insert into signupthree values('" + formno + "', '" + accountType + "', '"
							+ cardnumber + "', '" + pinnumber + "', '" + facility + "')";

					String query2 = "insert into login values('" + formno + "', '" + cardnumber + "', '" + pinnumber
							+ "')";

					String insertQuery = "INSERT INTO balance (pin, amount) VALUES (?, ?)";
					PreparedStatement pstmt = con.c.prepareStatement(insertQuery);
					pstmt.setString(1, pinnumber);
					pstmt.setInt(2, 0);
					pstmt.executeUpdate();
					con.s.executeUpdate(query1);
					con.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPin Number: " + pinnumber);
				}
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);

			} catch (Exception ex) {
				System.out.println(ex);
			}

		} else if (e.getSource() == cancel) {
			setVisible(true);
			new Login().setVisible(true);

		}
	}

}
