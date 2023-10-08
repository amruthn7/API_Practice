package diffWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class UsingHaspMapTest {

	@Test
	public void createProjectUsingJsonHaspMap() {
		JavaUtility jLib= new JavaUtility();	
		
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("createdBy", "Amr");
		map.put("projectName", "hms_"+jLib.getRandomNumber(100));
		map.put("status", "Created");
		map.put("teamSize", 3);
		
		baseURI="http://192.168.0.146";
		port=8084;

		given().body(map).contentType(ContentType.JSON)

		.when().post("/addProject")

		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();

		
	}
}
