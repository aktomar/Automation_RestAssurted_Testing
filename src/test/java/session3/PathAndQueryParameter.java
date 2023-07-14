package session3;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PathAndQueryParameter {
	
	
	@Test(priority=1)
	public void TestPathAndQueryParameter() {
		
		// https ://reqres.in/api/users?page=2&id=5
		//users - considers as a path parameter...
		//page & id  - considers as a query Parameter....
		
		given()
			
			.pathParam("mypath", "users")  //pathparameter
			.queryParam("page", 2)  //Query parameter
			.queryParam("id", 5)	//Query parameter
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		
		.then().statusCode(200).log().all();
		
		
		
		
	}
	
	
	
	
	

}
