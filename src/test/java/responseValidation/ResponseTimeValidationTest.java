package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ResponseTimeValidationTest {

	@Test
	public void responseTime() {
		
		//precondition
		baseURI="http://192.168.0.146";
		port=8084;
		
		//action
		when().get("/projects")
		
		//validation
		.then().assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS).log().all();
		
	}
	
}
