package hRm.GenericLibrary;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import hRm.ObjectRepository.HomePage;
import hRm.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	PropertyFileLibrary pfl = new PropertyFileLibrary();
	WebDriverLibrary wl = new WebDriverLibrary();
	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite
	public void bsConfig() {
		System.out.println("Database Connected Successfully");
	}

	// @Parameters("browser")
	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = pfl.readDataFromPropertyFile("browser");
		String URL = pfl.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("CHROME")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " Browser launched");
		}
		else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + "Browser launched");
		}
		else 
		{
			System.out.println("Invalid Browser name ");
		}
		sDriver = driver;
		wl.maximize(driver);

		wl.waitForPageLoad(driver);
		driver.get(URL);
	}

	
	@BeforeMethod
	public void bmConfig() throws IOException {

		LoginPage lp = new LoginPage(driver);
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User");
		String user = scanner.nextLine();*/
		if (true/*user.equalsIgnoreCase("admin")*/)
		{
			lp.loginToHrmAsHr(driver);
			HomePage hp = new HomePage(driver);
			String adminMail = hp.getAdminMailElement().getText();
			String Uname = pfl.readDataFromPropertyFile("HrEmail");
			Assert.assertEquals(adminMail, Uname);
			Reporter.log("Home Page is Displayed", true);
		} 
		/*else if (user.equalsIgnoreCase("hrofficer"))
		{
			lp.loginToHrmAsHrOff(driver);
		}
		else if (user.equalsIgnoreCase("hrassistant"))
		{
			lp.loginToHrmAsHrAsst(driver);
		} 
		else 
		{
			System.out.println("Invalid User");
		}*/
	}

	@AfterMethod
	public void amConfig() 
	{
		HomePage hp = new HomePage(driver);
		hp.logOut(driver);
		System.out.println("Logout sucessfull");
	}

	@AfterClass
	public void acConfig() 
	{
		driver.close();
		System.out.println("Browser closed");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("Database disconneted successfully");
	}

}
