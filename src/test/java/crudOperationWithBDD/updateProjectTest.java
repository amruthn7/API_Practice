package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class updateProjectTest {

	@Test
	public void updateProject() {
		
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "amr");
		jObj.put("projectName", "hms_Nmedo");
		jObj.put("status", "onGoing");
		jObj.put("teamSize", 3);
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		
		given().body(jObj).contentType(ContentType.JSON)
		
		.when().put("/projects/TY_PROJ_2745")
		
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
	}
}
