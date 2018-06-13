package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListEmpByDept2 {

	public static void main(String[] args) throws SQLException {

		try (Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Scanner s = new Scanner(System.in);
			System.out.print("Enter department id : ");
			int deptid = s.nextInt();

			PreparedStatement ps = con.prepareStatement
					("select first_name, salary from employees where department_id = ?");
			ps.setInt(1, deptid);
			ResultSet rs = ps.executeQuery();

			while( rs.next()) {
				System.out.printf("%-15s %d\n", rs.getString("first_name"), 
						   rs.getInt("salary") );
			}
			rs.close();
		}

	}

}
