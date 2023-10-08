package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getAllProjectsTest {

	@Test
	public void getAllProjects() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		when().get("/projects")
		
		.then().statusCode(200).and().contentType(ContentType.JSON).log().all();
	}
}

