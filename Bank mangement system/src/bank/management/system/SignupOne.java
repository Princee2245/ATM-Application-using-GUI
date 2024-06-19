package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

	long num;
	JTextField nameTextField, fnameTextField, emailTextField;
	JTextField addressTextField, cityTextField, pincodeTextField, stateTextField;

	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;

	SignupOne() {

		Random ran = new Random();
		num = Math.abs((ran.nextLong() % 9000L) + 1000L);

		JLabel formno = new JLabel("Application Form no " + num);
		formno.setFont(new Font("Railway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);

		JLabel personDetail = new JLabel("Page 1: Personal Detail");
		personDetail.setFont(new Font("Railway", Font.BOLD, 22));
		personDetail.setBounds(290, 80, 600, 40);
		add(personDetail);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Railway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Railway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);

		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Railway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 200, 30);
		dateChooser.setForeground(Color.red);
		add(dateChooser);

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Railway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);

		female = new JRadioButton("Female");
		female.setBounds(370, 290, 70, 30);
		female.setBackground(Color.white);
		add(male);
		add(female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);

		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Railway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);

		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Railway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		married = new JRadioButton("married");
		married.setBounds(300, 390, 70, 30);
		married.setBackground(Color.white);

		unmarried = new JRadioButton("unmarried");
		unmarried.setBounds(370, 390, 90, 30);
		unmarried.setBackground(Color.white);
		add(married);
		add(unmarried);

		other = new JRadioButton("other");
		other.setBounds(460, 390, 100, 30);
		other.setBackground(Color.white);
		add(other);

		ButtonGroup marriedGroup = new ButtonGroup();
		marriedGroup.add(unmarried);
		marriedGroup.add(married);
		marriedGroup.add(other);

		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Railway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);

		JLabel city = new JLabel("City:");
		city.setFont(new Font("Railway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);

		JLabel state = new JLabel("State:");
		state.setFont(new Font("Railway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30); // Fixed bounds issue
		add(stateTextField);

		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Railway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Railway", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway", Font.BOLD, 14));
		next.setBounds(400, 650, 100, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupOne();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String formno = "" + num;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

		String gender = null;

		if (male.isSelected()) {
			gender = "Male";
		} else if (female.isSelected()) {
			gender = "Female";
		}

		String email = emailTextField.getText();
		String marital = null;

		if (married.isSelected()) {
			marital = "married";
		} else if (unmarried.isSelected()) {
			marital = "unmarried";
		} else if (other.isSelected()) {
			marital = "other";
		}

		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pincodeTextField.getText();

		try {

			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "name is required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob
						+ "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city
						+ "', '" + pin + "', '" + state + "')";

				c.s.executeUpdate(query);

				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
