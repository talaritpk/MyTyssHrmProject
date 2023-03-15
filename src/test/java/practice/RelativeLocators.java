package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocators {
	@Test
	public void relativeLocator() {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://calculator.com/");

		WebElement ele = driver.findElement(RelativeLocator.with(By.tagName("input"))
				.toLeftOf(By.xpath("//div[@id=\"calcbuttons\"]//div[@style='clear:both;']//input[@value='3']")));
		ele.click();
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//div[@id=\"calcbuttons\"]//div[@style='clear:both;']//input[@value='9']"))).click();
		
		List<WebElement> elesElements=driver.findElements(By.xpath("//div[@id=\"calcbuttons\"]//div[@style='clear:both;']//input"));
		for(WebElement ele1:elesElements) {
			System.out.println(ele1.getAttribute("value"));
		}
		
	}

}
