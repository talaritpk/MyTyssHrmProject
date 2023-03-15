package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsPract {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\tpkta\\Downloads\\selenium\\edgedriver_win64\\msedgedriver.exe");
		//WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fb.com");
		
	}
	
	 //System.setProperty("webdriver.edge.driver", "C:\\Users\\tpkta\\Downloads\\selenium\\edgedriver_win64\\msedgedriver.exe");
	

}
