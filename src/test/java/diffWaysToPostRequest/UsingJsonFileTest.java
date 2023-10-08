package diffWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonFileTest {

	@Test
	public void createProjectUsingJsonFile() {

		File file= new File("D:\\Eclipse Workspace\\Selenium Workspaces\\SDET Workspace\\RmgYantra\\Data\\jsonFile.json");
		
		baseURI="http://192.168.0.146";
		port=8084;

		given().body(file).contentType(ContentType.JSON)

		.when().post("/addProject")

		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();

	}
}
