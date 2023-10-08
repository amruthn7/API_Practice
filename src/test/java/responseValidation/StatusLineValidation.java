package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class StatusLineValidation {

	@Test
	public void statusLineValidationTest() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		String expStatusLine = "HTTP/1.1 200";
		Response res = given().get("/projects");
		
		String actStatusLine = res.getStatusLine();
		Assert.assertEquals(actStatusLine, expStatusLine);
	}
}
