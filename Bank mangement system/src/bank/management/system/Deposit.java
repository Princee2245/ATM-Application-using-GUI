package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {

	JButton deposit, back;
	JTextField amount;
	String pinnumber;

	public Deposit(String pinnumber) {
		this.pinnumber = pinnumber;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);

		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Enter the amount you want deposit");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);

		deposit = new JButton("Deposit");
		deposit.setBounds(355, 485, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);

		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setLayout(null);
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Deposit("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == deposit) {

			String number = amount.getText();
			Date date = new Date();

			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount you want yo deposit");

			} else {

				try {
					Conn con = new Conn();
					String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + number
							+ "')";

					String updateQuery = "UPDATE balance SET amount = amount + ? WHERE pin = ?";

					PreparedStatement pstmt = con.c.prepareStatement(updateQuery);
					pstmt.setInt(1, Integer.parseInt(number));
					pstmt.setString(2, pinnumber);

					pstmt.executeUpdate();

					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs " + number + " deposited succesfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);

				} catch (Exception exc) {
					System.out.println(exc);
				}
			}

		} else if (e.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);

		}

	}
}
