package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class PetParasiteForeCast {
	// WebDriverLibrary wl=new WebDriverLibrary();
	@Test
	public void petParasite() throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petdiseasealerts.org/forecast-map#/");

		// wl.scrollAction(driver);
		// Thread.sleep(5000);

		String state = "texas";

		By ref = By
				.xpath("//*[name()='svg' and @id='map-svg' ]//*[name()='g'  and @id='regions']/*[name()='g' and @id='"
						+ state + "'");
//
//		driver.switchTo().frame(0);
//		WebElement element=driver.findElement(ref);
//
//		element.click();

		List<WebElement> eles = driver.findElements(By.xpath("//iframe"));
		int i = 0;
		for (WebElement e : eles) {

			if (e.getAttribute("id").contains("map-instance")) 
			{
				System.out.println(e.getAttribute("id"));
			}
			i++;
		}
		Thread.sleep(3000);
		driver.switchTo().frame(i);
		Thread.sleep(5000);
		driver.findElement(ref).click();

		// Pet pet=new Pet(driver);
		// //WebElement ele=driver.findElement(By.xpath("//*[@id='texas']//*[name()='g'
		// and @class='rpath']/*[name()='path']"));
		// //wl.mouseHoverOn(driver, pet.getPet());
		// //ele.click();
		// pet.getPet().click();
	}

}
