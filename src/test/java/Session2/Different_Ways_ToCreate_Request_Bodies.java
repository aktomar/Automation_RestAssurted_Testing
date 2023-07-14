package Session2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

/*Th ways to create a request Body
 1 - Hashmap
 2 - using org.json
 3 - using POJO (plain old java object)
 4 - using external json file 
 */


public class Different_Ways_ToCreate_Request_Bodies {
	
	
	//Type 01 : Using hashmap create a request body...
	//@Test(priority=1)
	public void CreateRequestBodyByHashmap() {
		
			HashMap data = new HashMap();
			data.put("id","2");
			data.put("name", "Akshay");
			data.put("location", "Bareilly");
			
			String coursesarr[] = {"java","c++"};
			data.put("courses", coursesarr);
			
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post(" http://localhost:3000/std")
		
		
		.then()
			.statusCode(201)
			.body("id", equalTo("2"))
			.body("name", equalTo("Akshay"))
			.body("location", equalTo("Bareilly"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("c++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
		
	}
	
//****************************************************************************************************
	
	//Type 02 : Using  org.json create a request body...
//	@Test(priority=1)
	public void CreatePOSTRequestBodyByOrgJson() {
		
		
		
		JSONObject data = new JSONObject();
				
		data.put("id","2");
		data.put("name", "Akshay");
		data.put("location", "Bareilly");
		String coursesarr[] = {"java","c++"};
		data.put("courses", coursesarr);
		
		
	given()
		.contentType("application/json")
		.body(data.toString())
	
	.when()
		.post(" http://localhost:3000/std")
	
	
	.then()
		.statusCode(201)
		.body("id", equalTo("2"))
		.body("name", equalTo("Akshay"))
		.body("location", equalTo("Bareilly"))
		.body("courses[0]", equalTo("java"))
		.body("courses[1]", equalTo("c++"))
		.header("Content-Type", "application/json; charset=utf-8");
		
	}
	
	
//****************************************************************************************************
	//Type 03 : Using  org.json create a request body...
	//	@Test(priority=1)
		public void CreatePostRequestBodyByPOGOClass() {
			
			
			PostRequestPOGOClass data = new PostRequestPOGOClass();
			
			data.setId("2");
			data.setName("Akshay");
			data.setLocation("Bareilly");
			
			String coursesarr[] = {"java","c++"};
			data.setCourses(coursesarr);
			
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post(" http://localhost:3000/std")
		
		
		.then()
			.statusCode(201)
			.body("id", equalTo("2"))
			.body("name", equalTo("Akshay"))
			.body("location", equalTo("Bareilly"))
			.body("courses[0]", equalTo("java"))
			.body("courses[1]", equalTo("c++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
			
		}
	
//****************************************************************************************************	

		//Type 04 : Using  external JSON file to create a POST request body...
				@Test(priority=1)
				public void CreatePostClass() throws FileNotFoundException {
					
					
					File fs = new File(".\\JSON Files\\Sample.json");
			
					FileReader fr = new FileReader(fs);
					
					JSONTokener jt = new JSONTokener(fr);
					
					JSONObject data = new JSONObject(jt);
					
					
					
					
				given()
					.contentType("application/json")
					.body(data.toString())
				
				.when()
					.post(" http://localhost:3000/std")
				
				
				.then()
					.statusCode(201)
					.body("id", equalTo("2"))
					.body("name", equalTo("Akshay"))
					.body("location", equalTo("Bareilly"))
					.body("courses[0]", equalTo("java"))
					.body("courses[1]", equalTo("c++"))
					.header("Content-Type", "application/json; charset=utf-8")
					.log().all();
					
				}
	
	
	
	
	
	
//****************************************************************************************************	
				//Simulteneously deleting the content.....
	@Test(priority=2)
	public void DeleteRequestContent() {
		
		
		given()
		
		.when()
		.when().delete("http://localhost:3000/std/2")

		.then().statusCode(200).log().all();
		
		
		
		
	}

}
