package practice;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PetstoreUploadImage {

	@Test
	public void UploadImageTest() {
		
		given().multiPart("file", new File("./Data/Screenshot.png"),"application/json")
		
		.when().post("https://petstore.swagger.io/v2/pet/123/uploadImage")
		
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
	}
}
