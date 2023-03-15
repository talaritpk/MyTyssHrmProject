package practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



public class NoonCarousel {

	@Test
	public void noonCarousel() {

		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(cOptions);
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

//		List<WebElement> carouselNames = driver.findElements(By.xpath("//div[@data-qa='widget_productCarousel']//h2"));
//		List<WebElement> proNames=driver.findElements(By.xpath("//div[@data-qa='widget_productCarousel']//div[@data-qa='product-name']"));
		//WebElement element=driver.findElement(By.xpath("//div[@data-qa='widget_productCarousel']//h2"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role=\"presentation\" and @src=\"javascript:void(0)\" ]")));
		Point p=driver.findElement(By.xpath("//h2[.='Recommended for you']")).getLocation();
		System.out.println(p);
		
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy"+p);
		//jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@data-qa='widget_productCarousel']//h2")));
//		for (WebElement caro : elesElements) {
//			jsExecutor.executeScript("arguments[0].scrollIntoView();", caro);
//			System.out.println(caro.getText());
//
//		}

	}

}
