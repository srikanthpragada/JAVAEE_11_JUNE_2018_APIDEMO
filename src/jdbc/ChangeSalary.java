package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ChangeSalary {

	public static void main(String[] args) throws SQLException {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Scanner s = new Scanner(System.in);
			System.out.print("Enter employee id : ");
			int empid = s.nextInt();
			System.out.print("Enter new salary  : ");
			int salary  = s.nextInt();

			Statement st = con.createStatement();
			String cmd = "update employees set salary =" + salary + " where employee_id =" + empid;
			System.out.println(cmd);
			int count = st.executeUpdate(cmd);

			if (count == 1)
				System.out.println("Updated Successfully!");
			else
				System.out.println("Sorry! Employee Id Not Found!");
		}

	}

}
