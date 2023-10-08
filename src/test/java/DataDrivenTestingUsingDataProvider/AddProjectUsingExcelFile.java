package DataDrivenTestingUsingDataProvider;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.ExcelUtility;
import io.restassured.http.ContentType;
import pojoClassToCreateProject.ProjectLibrary;

public class AddProjectUsingExcelFile {
	
	
	@Test(dataProvider = "TestData")
	public void addProjectUsingDataProvider(String createdBy, String projectName, String status, String teamSize) {
		baseURI="http://192.168.0.146";
		port=8084;
		int size=Integer.parseInt(teamSize);
		ProjectLibrary projLib= new ProjectLibrary(createdBy, projectName, status, size);
		
		given().body(projLib).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().statusCode(201).and().assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
	
	
	@DataProvider
	public  Object[][] TestData() {
		ExcelUtility exUtil=new ExcelUtility();
		Object[][] ob= exUtil.getExcelData("createProject");
		return ob;
	}
}

