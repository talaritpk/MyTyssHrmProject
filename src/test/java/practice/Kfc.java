package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kfc {
	@Test
	public void menuList() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		//driver.get("https://www.worldometers.info/world-population/");
		driver.get("chrome://downloads/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String string="return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('div#searchTerm >input#searchInput');";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement ele = (WebElement)jse.executeScript(string);
		
		String js="arguments[0].setAttribute('value','abcd')";
		jse.executeScript("arguments[0].click();",ele);
		
		jse.executeScript(js,ele);
		//((JavascriptExecutor)driver).executeScript(js, ele);
		
		
//		Thread.sleep(6000);
//		List<WebElement> mList=driver.findElements(By.xpath("//ul[@class='outer-ul']"));
//		//System.out.println(mList.getText());
//		
//		for( WebElement ml:mList)
//		{
//			System.out.println(ml.getText());
//		}
	}

}
