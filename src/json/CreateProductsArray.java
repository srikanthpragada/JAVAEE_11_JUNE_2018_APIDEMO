package json;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class CreateProductsArray {

	public static void main(String[] args) {
 
          JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
          
          JsonObjectBuilder builder = Json.createObjectBuilder();
          builder.add("name", "Dell Laptop");
          builder.add("price", 45000);
          
          arrayBuilder.add(builder.build());
          
          builder.add("name", "iPhone 8");
          builder.add("price", 75000);
          
          arrayBuilder.add(builder.build());
          
          System.out.println(arrayBuilder.build());
          
          
          
          
          
          
	}

}
