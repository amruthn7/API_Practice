package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class Cookies {

	@Test //not done
	public void cookiesTest() {

		baseURI="http://192.168.0.146";
		port=8084;

		Cookie requestCookie = new Cookie.Builder("key", "value").setSecured(true)
				.setComment("Example Comment").build();
		Response response = given()
				.cookie(requestCookie).get("enterEndPointHere");
	}

}



