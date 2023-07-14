package session3;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HandleCookies {

	// Checking weather cookies is generating or not.......

	// @Test(priority=1)
	public void TestCookies() {

		given().when().get("https://www.google.com/")

				// If it's fail which meansa cookies is generation but with different value.....
				.then().cookie("AEC", "Ad49MVEOXW5hrEOm65ybiRpZSDEhxesSoMTpXYVua3mqoQWtippYUIoMWmc").log().all();

	}
	
//*********************************************************************************************************
	
	
	//How handles all the cookies info.....
	@Test(priority = 1)
	public void GetCookiesDynamically() {

		Response res = given()

				.when().get("https://www.google.com/");

		// getting single cookie....
//			String cookie_values = res.getCookie("AEC");
//			System.out.println("Value of the cookie is ==> "+cookie_values);

		// Getting all the cookies information......

		Map<String, String> cookies_values = res.getCookies();

		System.out.println(cookies_values.keySet());

		for (String k : cookies_values.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.println(k + " == " + cookie_value);

		}

	}

}
