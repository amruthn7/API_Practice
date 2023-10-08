package diffWaysToPostRequest;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class UsingJsonObjectTest {

	@Test
	public void createProjectUsingJsonObject() {
		JavaUtility jLib= new JavaUtility();	

		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Amr");
		jObj.put("projectName", "hms_"+jLib.getRandomNumber(100));
		jObj.put("status", "Created");
		jObj.put("teamSize", 3);


		baseURI="http://192.168.0.146";
		port=8084;

		given().body(jObj).contentType(ContentType.JSON)

		.when().post("/addProject")

		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();


	}
}
