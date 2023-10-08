package responseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class BodyValidation {

	@Test
	public void bodyValidation() {
	
		String expData="06/01/2023";
		baseURI="http://192.168.0.146";
		port=8084;
		
		Response res = when().get("/projects");
		
		String body = res.getBody().asString();
		boolean flag = false;
		
		if(body.contains(expData)) {
			flag=true;
			System.out.println("Data present in body");
		}
		Assert.assertTrue(flag);

//		System.out.println(res.body()); //both will return the address of the response body
//		System.out.println(res.getBody()); 
//		System.out.println("===========");
		
//		System.out.println(res.prettyPrint()); //it will return the body of the response
//		System.out.println("===========");
//		System.out.println(res.prettyPeek()); //it will return the header and body of the response
		
//		System.out.println("===========");
//		System.out.println(res.toString());
//		System.out.println("===========");
//		System.out.println(res.asString());
	}
}
