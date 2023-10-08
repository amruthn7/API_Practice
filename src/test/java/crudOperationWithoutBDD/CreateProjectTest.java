package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void addProject() {
		
		//creating json object
		JSONObject j=new JSONObject();
		j.put("createdBy", "Amruth");
		j.put("projectName", "hms_001");
		j.put("status", "Created");
		j.put("teamSize", 3);

		//precondition
		RequestSpecification reqSec = RestAssured.given();
		reqSec.body(j);
		reqSec.contentType(ContentType.JSON);

		//action
		Response resp = reqSec.post("http://192.168.0.146:8084/addProject");
		String contentType = resp.getContentType();
		System.out.println(contentType);

		//validation
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();

	}
}
