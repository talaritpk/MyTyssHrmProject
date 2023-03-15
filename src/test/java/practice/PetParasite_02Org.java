package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class PetParasite_02Org {
	@Test
	public void Irctc() throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://petdiseasealerts.org/forecast-map#/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");

		List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
		int i=0;
		for (WebElement ele : frames) {
			String atvalue = ele.getAttribute("id");
			if (atvalue.contains("map-instance")) 
			{				
				System.out.println(atvalue);
				break;
			}
			i++;
		}
		System.out.println(i);
		Thread.sleep(3000);
		driver.switchTo().frame(i);

		List<WebElement> eles = driver
				.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[@id='regions']/*"));
		System.out.println(eles.size());

		String subReg = "florida";
		WebElement ele1=driver.findElement(
				By.xpath("//*[local-name()='svg'and@id='map-svg']//*[name()='g'and@id='regions']/*[name()='g'and @id='"
						+ subReg + "']"));
		jsExecutor.executeScript("arguments[0].click();",ele1);

	}

}
