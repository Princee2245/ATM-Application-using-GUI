package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

	Connection c;
	Statement s;

	public Conn() {
		try {
//			Class.forName(com.mysql.cj.jdbc.Driver);

			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "prince@123");
			s = c.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

/*
 * 1)register the driver 2)create the connection 3)create statement 4)Execute
 * Query 5)Close Connection
 * 
 */