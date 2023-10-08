package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



/**
 * This class contians all testNg configurations annotations 
 * @author Amruth N
 *
 */
public class BaseClass {

	public PropertyUtility propertyUtils; 
	public ExcelUtility excelUtils;
	public DataBaseUtility dbUtil;
	public WebDriverUtilities webDriverUtils; 
	public JavaUtility javaUtils;
	public WebDriver driver;
	public String url;
	public String browser;
		

	/**
	 * This method is used to initialize the utilities, Connect to DB and read common data
	 * @param browser
	 */
	@Parameters(value="browser")
	@BeforeClass(alwaysRun=true)
	public void initializationSetup(@Optional String browser) {
		dbUtil=new DataBaseUtility();
		propertyUtils= new PropertyUtility(Iconstants.filePath);
		excelUtils = new ExcelUtility();

		webDriverUtils=new WebDriverUtilities(driver);
		javaUtils= new JavaUtility();
		
		if(browser==null  ||browser.isEmpty() || browser.equals("")) {
			browser = propertyUtils.getPropertyData("Browser");
		}
		this.browser=browser;
		
		url = propertyUtils.getPropertyData("appUrl");

	}

	/**
	 * This method is used to open browser and initialize the pom pages
	 */
	@BeforeMethod(alwaysRun=true)
	public void setUpBrowser() {
		driver = webDriverUtils.launchBrowser(browser);
		webDriverUtils.maximizeBrowser();
		webDriverUtils.getUrl(url);
	}

	/**
	 * This method is used to close browser
	 */
	@AfterMethod(alwaysRun=true)
	public void tearDownBrowser() {
		webDriverUtils.closeBrowser();
	}

	/**
	 * This method ia used to close the excel file
	 */
	@AfterClass(alwaysRun=true)
	public void initializationTearDown() {
		excelUtils.close();
		dbUtil.closeDBConnection();
	}

}
