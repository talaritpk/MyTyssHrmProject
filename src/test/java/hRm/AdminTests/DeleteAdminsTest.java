package hRm.AdminTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.AdminPage;
import hRm.ObjectRepository.HomePage;

public class DeleteAdminsTest extends BaseClass {

	@Test
	public void deleteAdminData() {
		AdminPage ap = new AdminPage(driver);
		HomePage hPage = new HomePage(driver);
		wl.clickAction(driver, hPage.getAdminLinkElement());// hPage.getAdminLinkElement().click();
		wl.clickAction(driver, hPage.getAdminSubLinkElement());// hPage.getAdminSubLinkElement().click();

		List<WebElement> emailAdss = ap.getEmailAdss();// driver.findElements(By.xpath("//table//tbody//tr//td[6]"));
		List<WebElement> deleteBtns = ap.getDeleteBtns();// driver.findElements(By.xpath("//tbody/tr/td[9]/i[2]"));
		for (WebElement eadrr : emailAdss) {
			String email = eadrr.getText();
			if (email != "hrOfficer@gmail.com" && email != "hrhead@gmail.com" && email != "hrassistant@gmail.com") {
				for (WebElement delete : deleteBtns) {
					wl.clickAction(driver, delete);
					wl.clickAction(driver, ap.getDeleteBtns2());// driver.findElement(By.xpath("//div[@class='modal fade
																// show']//button[.='Delete']")).click();
					wl.acceptAlert(driver);
					driver.navigate().refresh();
				}
			}

		}

	}
}
