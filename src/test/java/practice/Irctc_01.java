package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import hRm.GenericLibrary.WebDriverLibrary;

public class Irctc_01 {
	@Test
	public void irctc() throws InterruptedException
	{
		
		WebDriverLibrary wl=new WebDriverLibrary(); 
//		EdgeOptions eOptions=new EdgeOptions();
//		eOptions.addArguments("--disable-notifications");
//		eOptions.addArguments("--disable-geolocation");
//		eOptions.addArguments("--ignore-certificate-errors");
		ChromeOptions cOptions=new ChromeOptions();
		cOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(cOptions);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		System.out.println(driver.getTitle());
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		
		driver.findElement(By.xpath("//a[.=' BUSES ']")).click();
		
		Thread.sleep(2000);
		
		
		
		//wl.switchToWindow(driver, "Online Bus");
		switchWindow(driver, "Online Bus");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//div[@class='Home-Form-Section']//li//span[.='Cruise']")).click();
		//wl.switchToWindow(driver, "Incredible India Travel & Tour Package");
		switchWindow(driver, "Incredible India Travel & Tour Package");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@class='Home-Form-Section cruise-Section-srch']//a[contains(.,'Domestic')]")).click();
		
		List<WebElement> searchPacks=driver.findElements(By.xpath("//div[@class='right-searchresult']/descendant::div[@class='mid-searchpack']"));
		for(WebElement ele:searchPacks){
			{
				System.out.println(ele.getText());
				System.out.println("------------------");
			}
		}
		//wl.switchToWindow(driver, "Online Bus");
		switchWindow(driver, "Online Bus");
		driver.findElement(By.id("departFrom")).sendKeys("hyderabad");
		List<WebElement> suggFrom=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		suggFrom.get(0).click();
		driver.findElement(By.id("goingTo")).sendKeys("Bengaluru");
		List<WebElement> suggTo=driver.findElements(By.xpath("//ul[@id='ui-id-2']/li"));
		suggTo.get(0).click();
		driver.findElement(By.id("departDate")).click();
		WebElement datepick=driver.findElement(By.xpath("//tbody//tr//td/a[.='17']"));
		datepick.click();
		driver.findElement(By.xpath("//button[.='Search Bus ']")).click();
		
		driver.findElement(By.xpath("//label[contains(.,'TSRTC')]/../following-sibling::div[contains(@class,'02')]/label[.='05:00']/../following-sibling::div/button")).click();
		
		WebElement ddboarding=driver.findElement(By.xpath("//label[contains(.,'TSRTC')]/../following-sibling::div[contains(@class,'02')]/label[.='05:00']/../following-sibling::div/button/ancestor::div/following-sibling::div[@id='seatLayout0']//select[@name='bordingSelected']"));
		
		WebElement dddrop=driver.findElement(By.xpath("//label[contains(.,'TSRTC')]/../following-sibling::div[contains(@class,'02')]/label[.='05:00']/../following-sibling::div/button/ancestor::div/following-sibling::div[@id='seatLayout0']//select[@name='debordingSelected']"));
		Select se=new Select(ddboarding);
		se.selectByIndex(1);
		Select se1=new Select(dddrop);
		se1.selectByIndex(1);
		
		WebElement seatLayout=driver.findElement(By.xpath("//label[contains(.,'TSRTC')]/../following-sibling::div[contains(@class,'02')]/label[.='05:00']/../following-sibling::div/button/ancestor::div/following-sibling::div[@id='seatLayout0']//button"));
		seatLayout.click();
		
		
		
		jsExecutor.executeAsyncScript("arguments[0].style.border='4px Solid green'",seatLayout);
		
		String orgCol=ddboarding.getCssValue("backgroundColor");
		System.out.println(orgCol);
		
		for(int i=0;i<50;i++)
		{
			
			jsExecutor.executeScript("arguments[0].style.backgroundColor='red'",seatLayout);
			Thread.sleep(20);
			jsExecutor.executeScript("arguments[0].style.backgroundColor='"+orgCol+"'",seatLayout);
		}
		
//		List<WebElement> priceEles=driver.findElements(By.xpath("//div[@class='SearchCard SearchCard05']//label"));
//		
//		TreeSet tSet=new TreeSet<>();
//		for(WebElement ele:priceEles)
//		{
//			String price=ele.getText().substring(2);
//			 int i=Integer.parseInt(price);
//			 tSet.add(i);
//		}
//		System.out.println(tSet);
		
	}
	
	public  void switchWindow(WebDriver driver,String parWindowTitle)
	{
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String wId=it.next();
			String curTitle=driver.switchTo().window(wId).getTitle();
			if(curTitle.contains(parWindowTitle))
			{
				break;
			}
		}
	}

}
