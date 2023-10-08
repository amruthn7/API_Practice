package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class HeaderValidation {
	
	@Test
	public void headerValidation() {
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		String expVary="Access-Control-Request-Headers";
		String expPragma = "no-cache";
		String expContentType = "application/json";
//		String expSessionId = "";
		long expTimeIn = 3000L;
		
		Response response = when().get("/projects");
		
		//it will return the complete body of the response
		System.out.println(response.getHeaders()); 
		//it will return the specfied value of the key in response body
		System.out.println(response.getHeader("Vary"));
		
		String actualVary = response.getHeader("Vary");
		String actualPragma = response.getHeader("Pragma");
		String actualContentType = response.getContentType();
		
//		String actualSessionId = response.getSessionId();
		
		response.then().log().all();
		Assert.assertEquals(actualVary, expVary);
		Assert.assertEquals(actualPragma, expPragma);
		Assert.assertEquals(actualContentType, expContentType);
//		Assert.assertEquals(actualSessionId, expSessionId);
		//Assert.assertEquals(actualTime, expTimeIn); 
		
		//we cant validate time using assert
		response.then().assertThat().time(Matchers.lessThan(expTimeIn), TimeUnit.MILLISECONDS);	
	}	
}