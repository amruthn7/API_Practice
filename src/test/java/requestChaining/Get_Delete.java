package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Get_Delete {

	@Test
	public void getDeleteTest() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		Response response = when().get("/projects");
		
		String pID = response.jsonPath().get("[0].projectId");
		System.out.println(pID);
		 
		given().pathParam("projectID",pID)
		.when().delete("/projects/{projectID}")
		.then().log().all();
		
	}
}
