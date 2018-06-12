package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HikeSalary {

	public static void main(String[] args) throws SQLException {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Scanner s = new Scanner(System.in);
			System.out.print("Enter employee id : ");
			int empid = s.nextInt();

			Statement st = con.createStatement();
			int count = st.executeUpdate
					("update employees set salary = salary * 1.1 where employee_id =" + empid);

			if (count == 1)
				System.out.println("Updated Successfully!");
			else
				System.out.println("Sorry! Employee Id Not Found!");
		}

	}

}
