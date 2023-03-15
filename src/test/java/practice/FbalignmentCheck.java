package practice;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class FbalignmentCheck {
	@Test
	public void alignmentCheck() throws InterruptedException
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement ele=driver.findElement(By.id("email"));
		WebElement ele1= driver.findElement(By.id("passContainer"));
		
		System.out.println(ele.getRect().getHeight());
		System.out.println(ele.getRect().getWidth());
		System.out.println(ele.getRect().getX());
		
		System.out.println(ele1.getRect().getHeight());
		System.out.println(ele1.getRect().getWidth());
		System.out.println(ele1.getRect().getX());
		
		driver.switchTo().activeElement().sendKeys("pavan kumar");
		Thread.sleep(3000);
		ele.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		
		driver.findElement(By.name("login")).click();
		WebElement errormsg=driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String ercolor=errormsg.getCssValue("color");
		System.out.println(ercolor);
		
		String hex=Color.fromString(ercolor).asHex();
		System.out.println(hex);
		if(hex.equals("#ce0100"))
		{
			System.out.println("is red color");
		}
		
	}

}
