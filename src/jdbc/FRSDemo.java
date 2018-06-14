package jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;


class LessCostlyEmployees implements Predicate {

	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getInt("salary") < 5000;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
class CostlyEmployees implements Predicate {
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getInt("salary") > 10000;
		} catch (Exception ex) {
			return false;
		}
	}
	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

public class FRSDemo {

	public static void main(String[] args) throws Exception {
		FilteredRowSet rs = new OracleFilteredRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from employees");
		rs.execute();

		rs.setFilter(new CostlyEmployees());
   	    while(rs.next())
		{
			System.out.println( rs.getString("first_name") + " " +  rs.getInt("salary"));
		}
		
        rs.setFilter(new LessCostlyEmployees());
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println( rs.getString("first_name") + " " +  rs.getInt("salary"));
		}
		

	}

}
