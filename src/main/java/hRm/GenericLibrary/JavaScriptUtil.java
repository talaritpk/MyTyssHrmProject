package hRm.GenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	public void drawBorder(WebElement ele,WebDriver driver,String pixels,String strength,String color)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='"+pixels+" "+strength+" "+color+"'", ele);
		//3px Solid red
	}
	
	
	public String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public void clickByJS(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	
	public void generateAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('" + message + "')");
	}
	
	public void refreshByJS(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollPageUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public void zoomByPageJS(WebDriver driver,float num)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='"+num+"'");
	}
	
	public void flash(WebElement ele,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgcolor=ele.getCssValue("backgroundColor");
		for(int i=0;i<50;i++)
		{
			changeColor("rgb(0,200,0)",ele,driver);
			changeColor(bgcolor,ele,driver);
		}
	}
	
	public void changeColor(String color,WebElement ele,WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor=' "+color+" '",ele);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException i)
		{}
	}
	
	
	
	
	

}
