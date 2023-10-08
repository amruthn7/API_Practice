package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class createProjectTest {

	@Test
	public void createProject() {
		JavaUtility jLib= new JavaUtility();
		
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Amr");
		jObj.put("projectName", "hms_"+jLib.getRandomNumber(100));
		jObj.put("status", "Created");
		jObj.put("teamSize", 3);
		
		//storing the uri and port no to inbuilt variables
		baseURI="http://192.168.0.146";
		port=8084;
		
		//precodition
		given().body(jObj).contentType(ContentType.JSON)
		
		//peforming action
		.when().post("/addProject")
		
		//validation
		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();
	}
}
