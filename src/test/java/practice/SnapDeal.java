package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import hRm.GenericLibrary.WebDriverLibrary;

public class SnapDeal {
	@Test
	public void login() throws InterruptedException
	{
		WebDriverLibrary wl=new WebDriverLibrary(); 
		EdgeOptions eOptions=new EdgeOptions();
		eOptions.addArguments("--disable-notifications");
		eOptions.addArguments("--disable-geolocation");
		eOptions.addArguments("--ignore-certificate-errors");
		WebDriver driver=new EdgeDriver(eOptions);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele=driver.findElement(By.xpath("//span[.='Sign In']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='login']")).click();
		
		driver.switchTo().frame("loginIframe");
		
		driver.findElement(By.name("username")).sendKeys("8464992137");
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='cartInner']")).click();
	}

}
