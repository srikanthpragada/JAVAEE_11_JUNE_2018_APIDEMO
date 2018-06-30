package json;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CreateJobsArray {

	public static void main(String[] args) throws Exception {

		JsonArrayBuilder jobs = Json.createArrayBuilder();

		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();

			JsonObjectBuilder job = Json.createObjectBuilder();

			while (crs.next()) {
				job.add("id", crs.getString("job_id"));
				job.add("title", crs.getString("job_title"));
				jobs.add(job.build());
			}
			
			System.out.println(jobs.build());
		}

	}

}
