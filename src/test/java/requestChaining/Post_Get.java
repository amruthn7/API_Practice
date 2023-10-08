package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassToCreateProject.ProjectLibrary;

public class Post_Get {

	@Test
	public void postGetTest() {
		JavaUtility jutil= new JavaUtility();

		ProjectLibrary pojo= new ProjectLibrary("amr", "nml_hms_"+jutil.getRandomNumber(100), "completed", 3);


		baseURI="http://192.168.0.146";
		port=8084;

		Response response = given().body(pojo).contentType(ContentType.JSON)
				.when().post("/addProject");

		String pID = response.jsonPath().get("projectId");
		System.out.println(pID);

		given().pathParam("projectID", pID)
		.when().get("/projects/{projectID}")
		.then().log().all();
	}
}
