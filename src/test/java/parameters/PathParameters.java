package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;


public class PathParameters {

	@Test
	public void pathParameters() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		given().pathParam("pID", "TY_PROJ_2952")
		
		.when().get("/projects/{pID}")
		
		.then().log().all();

		
	}
	
}
