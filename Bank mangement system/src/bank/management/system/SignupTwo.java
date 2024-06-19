package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {

	JTextField pan, aadhar;
	JButton next;
	String formno;

	JRadioButton syes, sno, eyes, eno;

	JComboBox religion, income, category, occupation, education;

	SignupTwo(String formno) {
		this.formno = formno;

		JLabel additonalDetail = new JLabel("Page 2: Additonal Detail");
		additonalDetail.setFont(new Font("Railway", Font.BOLD, 22));
		additonalDetail.setBounds(290, 80, 600, 40);
		add(additonalDetail);

		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Railway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		String[] valreligion = { "Hindu", "Muslim", "sikh", "parsi", "other" };
		religion = new JComboBox(valreligion);
		religion.setBounds(300, 140, 400, 30);
		add(religion);

		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Railway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		fname.setBackground(Color.white);
		add(fname);

		String[] valcategory = { "General", "OBC", "SC", "ST", "other" };
		category = new JComboBox(valcategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.white);
		add(category);

		JLabel dob = new JLabel("Income");
		dob.setFont(new Font("Railway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		String[] valincome = { "null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000" };
		income = new JComboBox(valincome);
		income.setBounds(300, 240, 200, 30);
		income.setBackground(Color.white);
		add(income);

		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Railway", Font.BOLD, 20));
		gender.setBounds(100, 290, 300, 40);
		add(gender);

		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Railway", Font.BOLD, 20));
		email.setBounds(100, 310, 300, 40);
		add(email);

		String[] valeducation = { "Non Graduate", "Graduate", "post-graduate", "Doctrate", "Other" };
		education = new JComboBox(valeducation);
		education.setBounds(300, 310, 300, 30);
		education.setBackground(Color.white);
		add(education);

		JLabel marital = new JLabel("Occupation");
		marital.setFont(new Font("Railway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);

		String[] valoccupation = { "Salried", "Self-employeed", "Bussiness", "Student", "Retired", "House Wife",
				"Other" };
		occupation = new JComboBox(valoccupation);
		occupation.setBounds(300, 390, 300, 30);
		occupation.setBackground(Color.white);
		add(occupation);

		JLabel address = new JLabel("Pan No:");
		address.setFont(new Font("Railway", Font.BOLD, 20));
		address.setBounds(100, 440, 200, 30);
		add(address);

		pan = new JTextField();
		pan.setFont(new Font("Railway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);

		JLabel city = new JLabel("Aadhar No:");
		city.setFont(new Font("Railway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		aadhar = new JTextField();
		aadhar.setFont(new Font("Railway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);

		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Railway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		syes = new JRadioButton("YES");
		syes.setBounds(300, 540, 50, 30);
		syes.setBackground(Color.white);

		sno = new JRadioButton("NO");
		sno.setBounds(370, 540, 50, 30);
		sno.setBackground(Color.white);
		add(syes);
		add(sno);

		ButtonGroup marriedGroup = new ButtonGroup();
		marriedGroup.add(syes);
		marriedGroup.add(sno);

//		stateTextField = new JTextField();
//		stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
//		stateTextField.setBounds(300, 540, 400, 30); // Fixed bounds issue
//		add(stateTextField);

		JLabel pincode = new JLabel("Exisiting Account:");
		pincode.setFont(new Font("Railway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		eyes = new JRadioButton("YES");
		eyes.setBounds(300, 590, 50, 30);
		eyes.setBackground(Color.white);

		eno = new JRadioButton("NO");
		eno.setBounds(370, 590, 50, 30);
		eno.setBackground(Color.white);
		add(eyes);
		add(eno);

		ButtonGroup emarriedGroup = new ButtonGroup();
		emarriedGroup.add(eyes);
		emarriedGroup.add(eno);

//		pincodeTextField = new JTextField();
//		pincodeTextField.setFont(new Font("Railway", Font.BOLD, 14));
//		pincodeTextField.setBounds(300, 590, 400, 30);
//		add(pincodeTextField);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway", Font.BOLD, 14));
		next.setBounds(400, 650, 100, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.white);
		setLayout(null);
		setTitle("New Account Application form- page2");
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupTwo("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();

		String seniorcitizen = null;

		if (syes.isSelected()) {
			seniorcitizen = "YES";
		} else if (sno.isSelected()) {
			seniorcitizen = "NO";
		}

		String existingAccount = null;

		if (eyes.isSelected()) {
			existingAccount = "YES";
		} else if (eno.isSelected()) {
			existingAccount = "NO";
		}

		String span = pan.getText();
		String saadhar = aadhar.getText();

		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '"
					+ sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '"
					+ seniorcitizen + "', '" + existingAccount + "')";

			c.s.executeUpdate(query);
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			;

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
