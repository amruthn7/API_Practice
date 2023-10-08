package DataDrivenTestingUsingDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassToCreateProject.ProjectLibrary;

import static io.restassured.RestAssured.*;


public class AddProjectUsingDataProvider {

	@Test(dataProvider = "TestData")
	public void addProjectUsingDataProvider(String createdBy, String projectName, String status, int time){

		baseURI="http://192.168.0.146";
		port=8084;
//		basePath="http://192.168.0.146:8084";
		
		ProjectLibrary projLib= new ProjectLibrary(createdBy, projectName, status, time);
		
		given().body(projLib).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).and().assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
	
	@DataProvider
	public  Object[][] TestData() {
		Object[][] ob= new  Object[2][4];
		ob[0][0]="Amr";
		ob[0][1]="Dell";
		ob[0][2]="created";
		ob[0][3]=3;
		ob[1][0]="ruth";
		ob[1][1]="Dell_1";
		ob[1][2]="completed";
		ob[1][3]=4;
		return ob;
	}
}
