package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassToCreateProject.ProjectLibrary;

public class Post_Put {

	@Test
	public void PostPutTest() {
		JavaUtility jutil= new JavaUtility();
		
		ProjectLibrary pojo= new ProjectLibrary("amr", "nml_hms_"+jutil.getRandomNumber(100), "completed", 3);
	
		baseURI="http://192.168.0.146";
		port=8084;
		
		Response response = given().body(pojo).contentType(ContentType.JSON)
		.when().post("/addProject");
		
		String pId = response.jsonPath().get("projectId");
		
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Amr");
		jObj.put("projectName", "ans"+jutil.getRandomNumber(100));
		jObj.put("status", "Created");
		jObj.put("teamSize", 3);
		
		given().body(jObj).contentType(ContentType.JSON).pathParam("projectID", pId)
		.when().put("/projects/{projectID}")
		.then().log().all();
	}
}
