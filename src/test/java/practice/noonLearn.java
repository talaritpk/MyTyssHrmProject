package practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class noonLearn {
	@Test
	public void windowhandle() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).click();
		Thread.sleep(10000);
		List<WebElement> eles=driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li/a"));
		
		System.out.println(eles.size());
		for(WebElement w:eles)
		{ 
			String string=w.getText();
			System.out.println(string);
		}
	}
}
