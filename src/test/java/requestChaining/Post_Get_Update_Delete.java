package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassToCreateProject.ProjectLibrary;

public class Post_Get_Update_Delete {

	@Test
	public void postGetUpdateDelete() {
		JavaUtility jutil= new JavaUtility();

		ProjectLibrary pojo= new ProjectLibrary("amr", "nml_hms_"+jutil.getRandomNumber(100), "completed", 3);


		baseURI="http://192.168.0.146";
		port=8084;

		//post
		Response response = given().body(pojo).contentType(ContentType.JSON)
				.when().post("/addProject");

		String pID = response.jsonPath().get("projectId");
		
		//get
		given().pathParam("projectID", pID)
		.when().get("/projects/{projectID}");
		
		//update
		ProjectLibrary pojo1= new ProjectLibrary("ruth", "Ans_"+jutil.getRandomNumber(100), "onGoing", 4);
		
		given().body(pojo1).contentType(ContentType.JSON).pathParam("projectID", pID)
		.when().put("/projects/{projectID}");
		
		//delete
		given().pathParam("projectID",pID)
		.when().delete("/projects/{projectID}")
		.then().assertThat().statusCode(204).log().all();
	}
}
