package hRm.CorporateTests;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.CorporatePage;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

public class DeleteCorporates extends BaseClass {

	@Test
	public void deleteData() throws EncryptedDocumentException, IOException {
		CorporatePage cp = new CorporatePage(driver);
		WebDriverLibrary wL = new WebDriverLibrary();
		cp.getCorLinkElement().click();
		cp.getAddCorElement().click();
		wL.handleDropDown(cp.getNoDD(), 3);

		// div[@id='modal-delete2']//button[@name='delete'][normalize-space()='Delete']
		// div[@id='modal-delete50']//button[@name='delete'][normalize-space()='Delete']

		String beforeXpath = "//div[@id='modal-delete16";
		int a = 0;
		String afterXpath = "']//button[@name='delete'][normalize-space()='Delete']";

		while (a <= 50) {
			WebElement ele = cp.getDeleteBtnElement();
			wL.clickAction(driver, ele);
			for (int i = 0; i < 99; i++) {
				WebElement delete2 = driver.findElement(By.xpath(beforeXpath + i + afterXpath));
				wL.clickAction(driver, delete2);
				wL.acceptAlert(driver);
				driver.navigate().refresh();
			}

		}

	}

	@Test
	public void deleteData1() throws EncryptedDocumentException, IOException {
		CorporatePage cp = new CorporatePage(driver);
		WebDriverLibrary wL = new WebDriverLibrary();
		cp.getCorLinkElement().click();
		cp.getAddCorElement().click();
		wL.handleDropDown(cp.getNoDD(), 3);

		// div[@id='modal-delete2']//button[@name='delete'][normalize-space()='Delete']
		// div[@id='modal-delete50']//button[@name='delete'][normalize-space()='Delete']
		int a = 0;
		String beforeXpath = "//div[@id='modal-delete";

		String afterXpath = "']//button[@name='delete'][normalize-space()='Delete']";

		while (a <= 50) {
			WebElement ele = cp.getDeleteBtnElement();
			wL.clickAction(driver, ele);
			for (int i = 0; i < 50; i++) {
				WebElement delete2 = driver.findElement(By.xpath(beforeXpath + i + afterXpath));
				wL.clickAction(driver, delete2);
				wL.acceptAlert(driver);
				wL.getAlertText(driver);
				driver.navigate().refresh();
			}

		}
	}

	@Test
	public void deleteData2() {

		CorporatePage cp = new CorporatePage(driver);
		WebDriverLibrary wL = new WebDriverLibrary();
		cp.getCorLinkElement().click();
		cp.getAddCorElement().click();
		wL.handleDropDown(cp.getNoDD(), 3);

		List<WebElement> column1data = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		int columnDataCount = column1data.size();

		System.out.println(columnDataCount);

		// System.out.println(cStrings);

		// div[@id='modal-delete175']//button[@name='delete'][normalize-space()='Delete']

//		WebElement ele = cp.getDeleteBtnElement();
//		ele.click();
//		
//		List<WebElement> deleteBtn=cp.getDeleteBtnElements();
//		for(WebElement w:deleteBtn) 
//		{
//			wL.clickAction(driver, w);
//			wL.acceptAlert(driver);
//			driver.navigate().refresh();
//		}

	}


}
