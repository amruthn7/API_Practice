package EndToEnd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.IendPoints;
import genericLibrary.JavaUtility;
import genericLibrary.SpecificationBuilderBaseClass;

public class AddProjectTest extends SpecificationBuilderBaseClass {

	@Test
	public void addProject() {
		JavaUtility jLib= new JavaUtility();
		
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "Amr");
		jObj.put("projectName", "hms_"+jLib.getRandomNumber(100));
		jObj.put("status", "Created");
		jObj.put("teamSize", 3);
		
		
		//precodition
		given().spec(requestSpec).body(jObj)
		
		//peforming action
		.when().post(IendPoints.project_addProject)
		
		//validation
		.then().spec(responseSpec).log().all();
	}

}
