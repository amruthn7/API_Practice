package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2Coops {
	@Test
	public void oauth2Coops() {

		baseURI="http://coop.apps.symfonycasts.com";
		
		Response response = given()
				.formParam("client_id", "HarXon")
				.formParam("client_secret", "7e8e0235c856ae90947da98d90feb7dc")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://harxon.com")
				.formParam("code", 4460)

		.when().post("/token");
		System.out.println(response.asString());
		String token= response.jsonPath().get("access_token");

		given().auth().oauth2(token).pathParam("USER_ID", 4460)

		.when().post("/api/{USER_ID}/eggs-count")
		.then().log().all();

	}
}
