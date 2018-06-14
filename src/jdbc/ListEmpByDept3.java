package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class ListEmpByDept3 {

	public static void main(String[] args) throws SQLException {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter department id : ");
		int deptid = s.nextInt();
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from employees where department_id = ?");
		crs.setInt(1, deptid);
		crs.execute();
		while (crs.next()) {
			System.out.printf("%-15s %d\n", crs.getString("first_name"), crs.getInt("salary"));
		}
		crs.close();
	}
}
