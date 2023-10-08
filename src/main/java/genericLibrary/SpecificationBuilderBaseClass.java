package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuilderBaseClass {

	public ExcelUtility excelUtils = new ExcelUtility();
	public JavaUtility javaUtils= new JavaUtility();
	public PropertyUtility propUtils= new PropertyUtility(Iconstants.filePath);
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	
	@BeforeSuite
	public void bsConfig() {
		RequestSpecBuilder builder =new RequestSpecBuilder();
		String baseUrl= "http://localhost";//propUtils.getPropeirtyData("baseUrl");
		//String PortNo = propUtils.getPropertyData("portNo"); //we can also keep port no as constant if we are performing only single method(ex. get()) 		
		//int port = Integer.parseInt(portNo); // it will fetch string so we hardcoding it
		builder.setBaseUri(baseUrl);
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		requestSpec = builder.build();
		
		ResponseSpecBuilder builder1 = new ResponseSpecBuilder();
		builder1.expectContentType(ContentType.JSON);
		builder1.expectResponseTime(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS);
		//builder.expectStatusLine("HTTP/1.1 409 ");
		//builder.expectStatusCode(200);
		responseSpec = builder1.build();
	}
	
	
	
}
