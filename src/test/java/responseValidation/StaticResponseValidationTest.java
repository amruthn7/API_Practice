package responseValidation;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class StaticResponseValidationTest {

	@Test
	public void StaticResponseValidation() {
		
		//precondition
		String expData = "06/01/2023";
		baseURI="http://192.168.0.146";
		port=8084;
		
		//action
		Response resp = when().get("/projects");
			
		//validation
		String actData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("Data verified");
		
		resp.then().log().all();
	}
	
}
