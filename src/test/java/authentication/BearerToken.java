package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class BearerToken {

	@Test
	public void bearerToken() {
		
		given().auth().oauth2("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")		
		
		.when().get("https://api.github.com/repos/Amruthn16/SDET46_Repo")
		
		.then().assertThat().statusCode(200).log().all();

	}
}
