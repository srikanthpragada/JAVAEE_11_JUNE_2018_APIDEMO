package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangeLastname2 {

	public static void main(String[] args) throws SQLException {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Scanner s = new Scanner(System.in);
			System.out.print("Enter employee id : ");
			int empid = s.nextInt();
			s.nextLine();  // Read and throw content of buffer 
			System.out.print("Enter last name   : ");
			String lastname   = s.nextLine();

			PreparedStatement ps = con.prepareStatement
					("update employees set last_name = ? where employee_id = ?");
            
            ps.setString(1, lastname);
            ps.setInt(2, empid);
            
			int count = ps.executeUpdate();

			if (count == 1)
				System.out.println("Updated Successfully!");
			else
				System.out.println("Sorry! Employee Id Not Found!");
		}

	}

}
