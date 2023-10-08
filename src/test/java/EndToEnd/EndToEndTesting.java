package EndToEnd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericLibrary.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class EndToEndTesting {

	@Test
	public void endToEndTesting() throws SQLException {
		JavaUtility jUtil=new JavaUtility();
		
		//Adding data from DataBase
		DriverManager.registerDriver(new Driver());
		Connection connection = null;

		//data
		String url="http://localhost:8084";
		String userName = "rmgyantra";
		String password = "rmgy@9999";
		String createdBy = "Job";
		String projecId = "TY_PROJ_"+jUtil.getRandomNumber(300);
		String query = "insert into project values('"+projecId+"','"+createdBy+"','07/02/2023', 'selenium', 'Created', '3');";

		try {
			connection=DriverManager.getConnection("jdbc:mysql://192.168.0.146:3333/projects", "root@%", "root");
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		}
		finally {
			//connection.close();
			System.out.println("Connection closed");
		}

		
		//Fetching project using api
		baseURI="http://localhost";
		port=8084;

		when().get("/projects/"+projecId)
		.then().statusCode(200).and().contentType(ContentType.JSON).log().all();
		
		//checking created project in GUI
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		String actWelcomePage=driver.findElement(By.xpath("//h2[text()='Welcome To Project Management System']")).getText();

		if(actWelcomePage.contains("Welcome To Project Management System")) {
			System.out.println("User signed in successfully");
		}else {
			System.out.println("User not signed in successfully");
		}

		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String projectPage = driver.getCurrentUrl();

		if(projectPage.contains("projects")) {
			System.out.println("Project page displayed successfully");
		}else {
			System.out.println("Project page not displayed successfully");
		}

		WebElement actCreatedBy = driver.findElement(By.xpath("//th[text()='Project Manager']/ancestor::table//tbody/child::tr/td[text()='"+createdBy+"']"));

		if(createdBy.equals(actCreatedBy.getText())) {
			System.out.println("Data inserted successfully and TC pass");
		}else {
			System.out.println("Data not inserted successfully and TC fail");
		}
		driver.close();
	}
}
