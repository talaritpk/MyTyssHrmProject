package hRm.HrAssistant;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClassHrAsst;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HrOffEmployeePage;

public class DeleteDataOneByOne extends BaseClassHrAsst {
	
	@Test
	public void clickOnDeleteLookUpImageAndDeleteOneByOne() {

		WebDriverLibrary wl = new WebDriverLibrary();
		HrOffEmployeePage hp = new HrOffEmployeePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		hp.clickOnEmployeeLinks();

		int noOfRows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		for (int i = 1; i < noOfRows; i++) {
			wl.clickAction(driver, hp.getDeleteLookUpIamgeElement());
			// List<WebElement>
			// deletes=driver.findElements(By.xpath("//table//tbody//tr//td//i[2]"));

			// div[@class='modal fade show']
			driver.findElement(By.xpath("//div[@class='modal fade show']//button[.='Delete']")).click();
			String altext=wl.getAlertText(driver);
			Assert.assertEquals(altext, "Delete Successfully!!!");
			Reporter.log(altext,true);
			wl.acceptAlert(driver);
		}

}
}
