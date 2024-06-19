package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pinchange extends JFrame implements ActionListener {

	JPasswordField pin, repin;
	JButton change, back;
	String pinnumber;

	public Pinchange(String pinnumber) {

		this.pinnumber = pinnumber;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		setVisible(true);

		JLabel text = new JLabel("Change Your Pin");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(250, 280, 500, 35);
		image.add(text);

		JLabel pintext = new JLabel("New Pin");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setBounds(165, 320, 180, 25);
		image.add(pintext);

		JLabel repintext = new JLabel("Re-Enter Pin");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setBounds(165, 360, 180, 25);
		image.add(repintext);

		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(330, 320, 100, 25);
		image.add(pin);

		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(330, 360, 100, 25);
		image.add(repin);

		change = new JButton("Change");
		change.setBounds(355, 455, 150, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("Back");
		back.setBounds(355, 490, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		setLocation(300, 0);
	}

	public static void main(String[] args) {
		new Pinchange("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Pin does not matches");
					return;
				}

				if (npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter pin");

				}

				if (rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter pin");
				}

				Conn conn = new Conn();

				String bupdate = "update bank set pin=? where pin=?";
				PreparedStatement s2 = conn.c.prepareStatement(bupdate);
				s2.setString(1, npin);
				s2.setString(2, pinnumber);
				int r2 = s2.executeUpdate();

				String lupdate = "update login set pin=? where pin=?";
				PreparedStatement s1 = conn.c.prepareStatement(lupdate);
				s1.setString(1, npin);
				s1.setString(2, pinnumber);
				int r1 = s1.executeUpdate();

				String balanceupdate = "update balance set pin=? where pin=?";
				PreparedStatement s3 = conn.c.prepareStatement(balanceupdate);
				s3.setString(1, npin);
				s3.setString(2, pinnumber);
				int r3 = s3.executeUpdate();

				String supdate = "update signupthree set pin=? where pin=?";
				PreparedStatement s4 = conn.c.prepareStatement(supdate);
				s4.setString(1, npin);
				s4.setString(2, pinnumber);
				int r4 = s4.executeUpdate();

				setVisible(false);
				new Transaction(pinnumber).setVisible(true);

			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}

	}
}
