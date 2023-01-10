package hRm.CorporateTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.HPSFException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.PropertyFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.CorporatePage;
import hRm.ObjectRepository.EditCorporatePage;

/* Integration TestCase----->Navigate to LHN and Click on the Corporate Hide Bar and click on the Add Corporate Button Fill the name of 
   corporate and click on save button (---> Insert Successfully confirmation message should be displayed  and inserted corporate should be 
   displayed in the corporate dashboard)*/

public class CreateCorporateTest extends BaseClass {
	WebDriverLibrary wL = new WebDriverLibrary();
	PropertyFileLibrary pfl = new PropertyFileLibrary();

	@Test
	public void createCorporate() throws IOException, InterruptedException {

		CorporatePage cp = new CorporatePage(driver);
		cp.createcorporate();
		cp.enterCorNameAndSave("CorN", 2, 0);
		String alText = wL.getAlertText(driver);
		Assert.assertEquals(alText, "Insert Successfully!!!");
		Reporter.log(alText,true);
		wL.acceptAlert(driver);

	}

	@Test
	public void editCorFunctionTest() throws EncryptedDocumentException, IOException, InterruptedException {
		CorporatePage cp = new CorporatePage(driver);
		cp.createcorporate();
		cp.enterCorNameAndSave("HrmApp", 3, 0);
		String alText = wL.getAlertText(driver);
		Assert.assertEquals(alText, "Insert Successfully!!!");
		wL.acceptAlert(driver);
		cp.searchAndEditCor(driver);// jspy

		EditCorporatePage ecp = new EditCorporatePage(driver);
		ecp.enterName_clickOnUpdate(driver, "HrmApp", 3, 0);
//		String alText1 = wL.getAlertText(driver);
//		Assert.assertEquals(alText1, "Update Successfully!!!");
//		wL.acceptAlert(driver);
	}

	@Test
	public void pavan() throws EncryptedDocumentException, IOException {
		CorporatePage cp = new CorporatePage(driver);
		cp.getCorLinkElement().click();
		cp.getAddCorElement().click();

//		EditCorporatePage ecp=new EditCorporatePage(driver);
//		ecp.enterName_clickOnUpdate(driver, "HrmApp", 3, 0);
		// driver.findElement(By.xpath("//table/tbody/tr[1]//td[4]//button[.='Edit']"));

		WebElement ele = driver.findElement(By.xpath("//select[@name='example1_length']"));
		wL.handleDropDown("100", ele);

		ExcelFileLibrary efl = new ExcelFileLibrary();
		String CorName = efl.readDataFromExcelFile("HrmApp", 3, 0);
		WebElement corNameEleTable = driver.findElement(By.xpath("//td[normalize-space()='" + CorName + "']"));
		wL.scrollAction(driver, corNameEleTable);
		int i;
		int end = 200;
		String beforexpath = "//table/tbody/tr[10";
		String afterxp = "]//td[4]//button[.='Edit']";

		String corNameText = driver.findElement(By.xpath("//td[normalize-space()='" + CorName + "']")).getText();
		System.out.println(corNameText);

		if (corNameText.contains(CorName)) {
			for (i = 6; i < end; i++) {
				WebElement edit = driver.findElement(By.xpath(beforexpath + i + afterxp));
				edit.click();
				// System.out.println(str);
				// driver.findElement(By.xpath("//table/tbody/tr["+i+"]//td["+end+"]//button[.='Edit']")).getText();
			}
		}
	}
}
