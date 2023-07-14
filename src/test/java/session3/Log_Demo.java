package session3;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Log_Demo {
	
	 @Test(priority=1)
		public void TestLogMethods() {

			given().when().get("https://reqres.in/api/users?page=2&id=5")

					.then()
				//	.log().body();     //Print only body content on consol....
				//	.log().headers();	//Print only headers content on consol....
				//	.log().cookies();		//Print only cookies content on consol....
					.log().all();		//print all the content....
	 
	 }
	 
	 
}
