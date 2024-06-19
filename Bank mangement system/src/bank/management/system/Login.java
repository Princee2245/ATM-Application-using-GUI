package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

	// buttons are declared globally because we want to use globally
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;

	Login() {
		setTitle("ATM");

		setLayout(null); // otherwise it will have by default frame

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);

		// jLabel is used to write a content on frame
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 30));
		text.setBounds(200, 40, 400, 40);
		add(text);

		JLabel cardno = new JLabel("Card No.");
		cardno.setFont(new Font("Railway", Font.BOLD, 20));
		cardno.setBounds(120, 150, 130, 40);
		add(cardno);

		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 250, 40);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
		add(cardTextField);

		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Railway", Font.BOLD, 20));
		pin.setBounds(120, 220, 250, 40);
		add(pin);

		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 250, 40);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 16));
		add(pinTextField);

		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);

		clear = new JButton("CLEAR");
		clear.setBounds(410, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);

		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 210, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);

		getContentPane().setBackground(Color.white);

		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clear) {
			pinTextField.setText("");
			cardTextField.setText("");

		} else if (e.getSource() == login) {

			Conn con = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();

			String query = "select * from login where cardnumber= '" + cardnumber + "' and pin= '" + pinnumber + "'";

			try {
				ResultSet rs = con.s.executeQuery(query);

				if (rs.next()) {
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Incorrect pin or password");
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (e.getSource() == signup) {

			setVisible(false);
			new SignupOne().setVisible(true);

		}
	}

	public static void main(String[] args) {

		new Login();

	}

}
