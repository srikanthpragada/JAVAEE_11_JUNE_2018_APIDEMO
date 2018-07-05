package rest;

import java.net.URL;
import java.util.Scanner;

public class HelloClient {

	public static void main(String[] args) throws Exception {
		 URL url = new URL("http://localhost:8888/webdemo/rest/hello");
		 Scanner s = new Scanner(url.openStream());
		 System.out.println(s.nextLine());

	}

}
