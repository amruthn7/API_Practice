package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class deleteProject {

	@Test
	public void getAllProjects() {
		
		RequestSpecification reqSec = RestAssured.given();
		Response resp = reqSec.delete("http://192.168.0.146:8084/projects/TY_PROJ_2708");
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(204).and().contentType(ContentType.JSON).log().all();
	}
}
