package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibio {
	@Test
	public void test() throws AWTException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Goibibo-Flight&utm_term=%21SEM%21DF%21G%21Brand%21RSA%21108599293%2112768765973%21603637041733%21e%21goibio%21c%21&gclid=CjwKCAiArY2fBhB9EiwAWqHK6jYZ3trj-p1QOoLEBmHNQQ23YQxf4qzJquBLbHBA1LLVq38aAMcB1hoCmzkQAvD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		WebElement element=driver.findElement(By.xpath("//p[text()='Enter city or airport']"));
//		element.click();
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("vizag");
//		WebElement ele1=driver.findElement(By.xpath("//input[@type='text']"));
//		
//		driver.findElement(By.xpath("//span[text()='Visakhapatnam, India']")).click();
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hyderabad");
//		
//		driver.findElement(By.xpath("//p[text()='Rajiv Gandhi International Airport']")).click();
		
		List<WebElement> ele2=driver.findElements(By.xpath("//*[@class='logSprite icClose']"));
		if(ele2.size()>0)
		{
			ele2.get(0).click();
		}
		
		
		
		
		List<WebElement> eles=driver.findElements(By.xpath("//ul[@class='sc-bqiRlB hnjmtl']/li"));
		for(WebElement ele:eles)
		{
			String text=ele.getText();
			if(text.contains("Armed"))
			{
				ele.click();
			}
			if(text.contains("Student"))
			{
				ele.click();
			}
			
		}
		
		driver.findElement(By.xpath("//*[@class='sc-fWCJzd eRvjBC']/descendant::*[local-name()='svg' and @height='15']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='sc-fWCJzd eRvjBC']/descendant::*[local-name()='svg' and @height='2']")).click();
		
		
	}
	

}
