package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoClassToCreateProject.ProjectLibrary;

public class Post_Delete {

	@Test
	public void postDeleteTest() {
		JavaUtility jutil= new JavaUtility();
		
		ProjectLibrary pojo= new ProjectLibrary("amr", "nml_hms_"+jutil.getRandomNumber(100), "completed", 3);


		baseURI="http://192.168.0.146";
		port=8084;
		
		Response response = given().body(pojo).contentType(ContentType.JSON)
							.when().post("/addProject");

		 String pID = response.jsonPath().get("projectId");
		 System.out.println(pID);
		 
		given().pathParam("projectID",pID)
		.when().delete("/projects/{projectID}")
		.then().log().all();

	}
}
