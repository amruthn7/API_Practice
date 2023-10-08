package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getProjectTest {

	@Test
	public void getProject() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		when().get("/projects/TY_PROJ_1")
		
		.then().statusCode(200).and().contentType(ContentType.JSON).log().all();
		
	}
}
