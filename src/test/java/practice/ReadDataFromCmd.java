package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromCmd {
	WebDriver driver;
	
	@Test
	public void readDataFrom()
	{
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		if(BROWSER.equals("chrome"))
		{
			ChromeOptions cOptions=new ChromeOptions();
			cOptions.addArguments("--remote-allow-origins=*");
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(cOptions);
		}
		else if (BROWSER.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		driver.get(URL);
	}

}
