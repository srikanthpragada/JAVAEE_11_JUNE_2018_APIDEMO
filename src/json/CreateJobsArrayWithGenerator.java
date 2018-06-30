package json;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CreateJobsArrayWithGenerator {

	public static void main(String[] args) throws Exception {

		JsonGenerator gen = Json.createGenerator(System.out);
		gen.writeStartArray();
		
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			while (crs.next()) {
				gen.writeStartObject();
				gen.write("id", crs.getString("job_id"));
				gen.write("title", crs.getString("job_title"));
				gen.writeEnd();  // end of object
			}

			gen.writeEnd();  // end of array
     	}
		gen.close();
	}

}
