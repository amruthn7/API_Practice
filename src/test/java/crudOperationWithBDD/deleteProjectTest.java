package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class deleteProjectTest {

	@Test
	public void deleteProject() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		when().delete("/projects/TY_PROJ_2745")
		
		.then().statusCode(204).and().contentType(ContentType.JSON).log().all();
		
	}
}
