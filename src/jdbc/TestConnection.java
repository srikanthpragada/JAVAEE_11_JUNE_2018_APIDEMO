package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {

		try (Connection con =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			System.out.println("Connected!");
		}

	}

}
