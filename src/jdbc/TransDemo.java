package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransDemo {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		try{
            con.setAutoCommit(false);
			Statement st = con.createStatement();
			int c = st.executeUpdate("update employees set salary = 12000 where employee_id = 150");
			if(c == 1)
                 throw new SQLException("Error");
			st.executeUpdate("update employees set salary = 9000 where employee_id = 150");
			con.commit();
		}
		catch(SQLException ex) {
			System.out.println("Error.. rolling back changes");
			con.rollback();
		}

	}

}
