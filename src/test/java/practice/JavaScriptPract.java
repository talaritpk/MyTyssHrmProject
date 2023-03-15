package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import hRm.GenericLibrary.JavaScriptUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptPract {
	
	@Test
	public void javaScriptExe() throws IOException, InterruptedException
	{
		JavaScriptUtil jsu=new JavaScriptUtil();
		
		WebDriver driver =new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		WebElement logo=driver.findElement(By.xpath("//img[@title='Flipkart']"));
//		jsu.drawBorder(logo, driver, "3px", "Solid", "red");
		
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dtn=new File(".\\ScreenShot\\logoFlipkartJSE.png");
		FileUtils.copyFile(src, dtn);
		
		System.out.println(jsu.getTitleByJS(driver));//getTitle By JS
		
		jsu.clickByJS(driver, logo); //click byJS
		
//		jsu.generateAlert(driver, "pavankumar");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		
		
		js.executeScript("alert('pavankumar alert')");  //alert creation
		
		driver.switchTo().alert().accept();
		
		js.executeScript("history.go(0)");
		Thread.sleep(2000);
		WebElement travel=driver.findElement(By.xpath("//img[@alt='Travel']"));
		//jsu.flash(travel, driver);
		js.executeScript("arguments[0].style.border='8px solid red'",travel);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
		//js.executeScript("document.body.style.zoom='0.5'");
		//jsu.zoomByPageJS(driver, 0.5f);
		
		System.out.println(js.executeScript("return document.title;").toString());
		
		
		 String traCol=travel.getCssValue("backgroundColor");
		 
		 for(int i=0;i<=100;i++)
		 {
			 js.executeScript("arguments[0].style.backgroundColor='red'",travel);
			 Thread.sleep(20);
		 
			 js.executeScript("arguments[0].style.backgroundColor='"+traCol+"'",travel);
		 }
		WebElement login=driver.findElement(By.xpath("//a[@class='_1_3w1N']"));
		String logCol=login.getCssValue("backgroundColor");
		//jsu.flash(login, driver);
//		js.executeScript("arguments[0].style.backgroundColor='blue'", login);
//		js.executeScript("arguments[0].style.backgroundColor='logCol'", login);
		
		
		
		//System.out.println(js.executeScript("return document.documentElement.innerText;").toString());
		
	}

}
