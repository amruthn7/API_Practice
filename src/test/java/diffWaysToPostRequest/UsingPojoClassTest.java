package diffWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import pojoClassToCreateProject.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class UsingPojoClassTest {

	@Test
	public void createProjectUsingPOJOclass() {
		JavaUtility jLib= new JavaUtility();
		
		ProjectLibrary pojo= new ProjectLibrary("amr", "nml_hms_"+jLib.getRandomNumber(100), "completed", 3);
		
		baseURI="http://192.168.0.146";
		port=8084;  

		given().body(pojo).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();
	}
}
