package practice;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

import static io.restassured.RestAssured.*;

public class DataHidden {

	@Test
	public void dataHiddenTest() {
		ArrayList<String> list= new ArrayList<String>();
		list.add("Vary");
		list.add("Server");

		given().contentType(ContentType.JSON).config(RestAssured.config
				.logConfig(io.restassured.config.LogConfig.logConfig().blacklistHeaders(list)))

		.when().get("https://reqres.in/api/users").then().log().headers();
	}
}
