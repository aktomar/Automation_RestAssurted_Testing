package Session1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

//Given() : content-type, set cookies, add auth,add param, set header info etc...
//when()  : get, post,put,delete..
//then()  : validate status code, extract response,extract headers cookies & response body....

public class HttpRequests {

	int id;

	// Testcase 01 : How we can get the content from Get method....
	 @Test(priority = 1)
	public void GetRequest() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2));//.log().all();

	}

	// ***************************************************************************************

	// Testcase 02 : To create a user through post request....
	@Test(priority = 2)
	public void CreateUser() {

		HashMap data = new HashMap();
		data.put("name", "akshay");
		data.put("age", "26");

		// fatching id to update the content..
		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		// .then().log().all();

	}

	// ****************************************************************************************
	// Testcase 03 : To update the existing content on server through put method

	@Test(priority = 3, dependsOnMethods = { "CreateUser" })
	public void UpdateUser() {

		HashMap data = new HashMap();
		data.put("name", "aman");
		data.put("age", "25");

		// fatching id to update the content..
		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200);//.log().all();

	}

	// **********************************************************************************
	// Testcase 03 : To delete the existing content on server through deleteMethod

	@Test(priority = 4)
	public void DeleteRequest() {

		given()

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();

	}

}
