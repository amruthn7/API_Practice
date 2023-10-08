package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import org.testng.Assert;

import io.restassured.response.Response;

public class DynamicResponseValidationTest {

	@Test
	public void dynamicResponse() {
		
		//precondition
		String expData = "06/01/2023";
		baseURI="http://192.168.0.146";
		port=8084;

		//action
		Response resp = when().get("/projects");

		//validation
		boolean flag=false;
		 List<String> pIDs = resp.jsonPath().get("projectId");
		
		for (String projectId : pIDs) {
			if(projectId.equalsIgnoreCase(expData))
				flag=true;
		}
		
		Assert.assertTrue(flag);
		System.out.println("Data verified");

		resp.then().log().all();
	}
}
