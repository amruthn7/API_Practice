package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassToCreateProject.ProjectLibrary;

public class Put_Delete {
	
	@Test
	public void putDelete() {
	JavaUtility jutil= new JavaUtility();

	baseURI="http://192.168.0.146";
	port=8084;
	
	ProjectLibrary pojo= new ProjectLibrary("ruth", "Ans_"+jutil.getRandomNumber(100), "onGoing", 4);
	
	Response response = given().body(pojo).contentType(ContentType.JSON)
	.when().put("/projects/TY_PROJ_3399");
	
	String pId = response.jsonPath().get("projectId");
	
	//delete
	given().pathParam("projectID",pId)
	.when().delete("/projects/{projectID}")
	.then().assertThat().statusCode(204).log().all();
	
	}
}
