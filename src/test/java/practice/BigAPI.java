package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;


public class BigAPI {

	@Test
	public void test()
	{
		baseURI="https://api.publicapis.org/";
	
		 Response resp = when().get("entries");
		 //.then().log().all();
		 List<String> s = resp.jsonPath().get("entries.API");
		System.out.println( s.size());
		 for (String p : s) 
		 {
			 System.out.println(p);
			}
		
	}
}
