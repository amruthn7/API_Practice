package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class FormParameters1 {

	@Test
	public void formParameters() {
	baseURI="http://192.168.0.146";
	port=8084;
	
	given().formParam("createdBy", "amr")
			.formParam("projectName", "nml_hms_777")
			.formParam("status", "created")
			.formParam("teamSize", 4)
	
	.when().post("/addProject")
	
	.then().log().all();

	}
}
