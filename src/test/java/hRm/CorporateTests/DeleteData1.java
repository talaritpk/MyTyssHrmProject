package hRm.CorporateTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.CorporatePage;
import hRm.ObjectRepository.HomePage;

public class DeleteData1 extends BaseClass {
	

	
	@Test
	public void deleteDataOneByOne() {
		CorporatePage cp = new CorporatePage(driver);

		HomePage hp = new HomePage(driver);
		wl.clickAction(driver, driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")));
		
		wl.clickAction(driver,cp.getAddCorElement());

		List<WebElement> eles = driver.findElements(By.xpath("//table//tbody//tr"));
		int rows = eles.size();
		for (int i = 1; i < rows; i++) {
			wl.clickAction(driver, cp.getDeleteBtnElement());

			driver.findElement(By.xpath("// div[@class='modal fade show']//button[.='Delete']")).click();
			wl.acceptAlert(driver);
			driver.navigate().refresh();
		}
	}

}
