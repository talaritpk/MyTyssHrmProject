package hRm.CorporateTests;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.PropertyFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.CorporatePage;
import hRm.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleCorporates {
	ExcelFileLibrary efl=new ExcelFileLibrary();
	WebDriverLibrary wL=new WebDriverLibrary();
	PropertyFileLibrary pfl=new PropertyFileLibrary();
	
	@Test(dataProvider ="MultipleCor")
	public void createMultipleCor(String corName) throws EncryptedDocumentException, IOException
	{
		WebDriver driver=null;
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
		
		wL.maximize(driver);

		wL.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.loginToHrmAsHr(driver);
		
		
		
		CorporatePage cp = new CorporatePage(driver);
		cp.createcorporate();
		cp.enterCorNameAndSave(corName);
		wL.acceptAlert(driver);
		driver.close();
		
		
	}
	
	
	@DataProvider(name ="MultipleCor")
	public Object[][] readData() throws EncryptedDocumentException, IOException
	{
		Object[][] dataObjects= efl.readMutipleDataFromExcelFile("CorN");
		return dataObjects;
		
	}
	
	
	
	
	
	
	
	
	
	@Test(dataProvider = "mul")
	public void pavan1(String name,String name1)
	{
		System.out.println(name+" "+name1);
	}
	
	@DataProvider(name="mul")
	public Object[][] readData1()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="a";
		data[0][1]="b";
		
		data[1][0]="c";
		data[1][1]="d";
		return data;
	}
	
	@Test
	public void readData2() throws EncryptedDocumentException, IOException
	{
		Object[][] aObjects=efl.readMutipleDataFromExcelFile("CorN");
		System.out.println(aObjects);
		
		System.out.println(aObjects.length);
		System.out.println(aObjects[0].length);
		
	}
	
	
	
	

}
