package session3;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Handle_Headers {
	
	
	//Here we are testing the headers.....
	//@Test(priority=1)
	public void TestHaeders() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");
	}
	
//*****************************************************************************************************
	
	//Getting all the headers values......
	
	@Test(priority=1)
	public void GetHeaders() 
	{
		
		Response res =given()
		
		.when()
			.get("https://www.google.com/");
		
		//Get single header value...
		
		// String header = res.getHeader("Content-type");
		// System.out.println("The values of header is ==> "+header);
		
		//Get all header information....
		
		Headers Myheader = res.getHeaders();
		
		for(Header hd:Myheader) {
		System.out.println(hd.getName()+ " == "+hd.getValue());
		}
		
		
		
		
		
		
		
		
	}

}
