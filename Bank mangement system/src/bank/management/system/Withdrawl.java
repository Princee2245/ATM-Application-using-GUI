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
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {

	JButton withdraw, back;
	JTextField amount;
	String pinnumber;

	public Withdrawl(String pinnumber) {
		this.pinnumber = pinnumber;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);

		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Enter the amount you want withdraw");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);

		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

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
		new Withdrawl("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == withdraw) {

			String number = amount.getText();
			Date date = new Date();

			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount you want yo withdraw");

			} else {

				try {
					Conn con = new Conn();
					ResultSet rs = con.s.executeQuery("select * from balance where pin= '" + pinnumber + "'");
					int amount;
					if (rs.next()) {
						amount = rs.getInt("amount");
					} else {
						JOptionPane.showMessageDialog(null, "No record found for the given PIN.");
						amount = -1;
					}
					if (Integer.parseInt(number) > amount) {
						JOptionPane.showMessageDialog(null, "Insufficent Balance");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
						return;
					}
					String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'withdrawal', '"
							+ number + "')";
					con.s.executeUpdate(query);

					String updateQuery = "UPDATE balance SET amount = amount - ? WHERE pin = ?";

					PreparedStatement pstmt = con.c.prepareStatement(updateQuery);
					pstmt.setInt(1, Integer.parseInt(number));
					pstmt.setString(2, pinnumber);

					pstmt.executeUpdate();

					JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawed succesfully");
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
