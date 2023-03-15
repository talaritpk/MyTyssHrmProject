package practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKArt {
	@Test
	public void windowhandle() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=iphone12&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@alt='APPLE iPhone 14 (Blue, 128 GB)']")).click();
		driver.findElement(By.xpath("//div[@class='_2QcLo-']//div//img[@alt='APPLE iPhone 14 (Starlight, 128 GB)']")).click();
		String parent=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		System.out.println(childWindows.size());
		
//		driver.close()  //closing parent browser
//		driver.quit();  //close all browser
		
		Iterator<String> it=childWindows.iterator();
		
//		while(it.hasNext())
//			{
//				String id=it.next();
//				driver.switchTo().window(id);   //closing all browsers without quit method
//				driver.close();
//				Thread.sleep(5000);
//			}
		
		
//		
		while(it.hasNext())
		{
			String id=it.next();
			String curUrl=driver.switchTo().window(id).getCurrentUrl();
			System.out.println(curUrl);
			if(curUrl.contains("starlight"))
			{
				driver.close();
			}
		}
	}

}
