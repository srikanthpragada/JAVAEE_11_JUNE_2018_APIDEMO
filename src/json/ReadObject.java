package json;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadObject {

	public static void main(String[] args) throws Exception {
		
		JsonReader reader = Json.createReader(new FileReader("e:\\classroom\\person.json"));
		
		JsonObject person = reader.readObject();
		
		System.out.println(person.getString("name"));
		System.out.println(person.getInt("age"));
		
		
		

	}

}
