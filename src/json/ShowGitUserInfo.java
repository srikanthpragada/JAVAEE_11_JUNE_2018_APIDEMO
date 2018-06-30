package json;

import java.io.FileReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ShowGitUserInfo {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://api.github.com/users/srikanthpragada");
		JsonReader reader = Json.createReader( url.openStream());
		
		JsonObject gituser  = reader.readObject();
		
		System.out.println(gituser.getString("name"));
		System.out.println(gituser.getString("location"));
		
		
		

	}

}
