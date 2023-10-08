package EndToEnd;

import genericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import pojoClassToCreateProject.ProjectLibrary;

public class EndToEndTesting2 {

	@Test
	public void endToEndTesting() throws SQLException {
		
		JavaUtility jUtil=new JavaUtility();

		ProjectLibrary pojo=new ProjectLibrary("qwert", "ans"+jUtil.getRandomNumber(100), "completed", 5);
		
		baseURI="http://192.168.0.146";
		port=8084;
		
		Response response = given().body(pojo).contentType(ContentType.JSON)
		.when().post("/addProject");
		
		String pID = response.jsonPath().get("projectId");
		//String pName = response.jsonPath().get("projectName");

		try {
		Driver dbDriver= new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.0.146:3333/projects", "root@%", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project where project_id = '"+pID+"' ");
		
		while(result.next()) {
			String actProjectId = result.getString("project_id");
			if(actProjectId.equalsIgnoreCase(pID)) {
				System.out.println("Project is present in DB");
			}
		}
		}finally {
			//connection.close();
			System.out.println("Connection closed");
		}
	}
}
