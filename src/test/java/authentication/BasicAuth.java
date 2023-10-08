package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class BasicAuth {

	@Test
	public void basicAuth() {
		JavaUtility jLib= new JavaUtility();

		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Amr");
		jObj.put("projectName", "hms_"+jLib.getRandomNumber(100));
		jObj.put("status", "Created");
		jObj.put("teamSize", 3);

		//storing the uri and port no to inbuilt variables
		baseURI="http://localhost";
		port=8084;
		
		given().auth().basic("rmgyantra", "rmgy@9999").body(jObj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).log().all();

	}
}
