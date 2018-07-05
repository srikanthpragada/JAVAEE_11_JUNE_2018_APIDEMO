package jaxws;

public class HelloClient {

	public static void main(String[] args)  throws Exception {
		 HelloProxy proxy = new HelloProxy();
		 System.out.println( proxy.getMessage());

	}

}
