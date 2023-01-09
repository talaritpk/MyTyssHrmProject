package hRm.BranchTests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.BranchPage;
import hRm.ObjectRepository.HomePage;

public class DeleteBranches extends BaseClass {
	WebDriverLibrary wL = new WebDriverLibrary();

	@Test
	public void deleteBranches() {
		HomePage hp = new HomePage(driver);
		hp.getBranchLinkElement().click();
		hp.getAddBranchSubElement().click();
		WebElement noDD = driver.findElement(By.xpath("//select[@name='example1_length']"));
		wL.handleDropDown(noDD, 3);
		// WebElement
		// deleteBtn=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[2]"));
		// WebElement
		// deleteBtn2=driver.findElement(By.xpath("//div[@id='modal-delete22']//button[@name='braches'][normalize-space()='Delete']"));
		// deleteBtn.click();
		// deleteBtn2.click();
		// wL.acceptAlert(driver);//
		// //div[@id='modal-delete216']//button[@name='braches'][normalize-space()='Delete']
		BranchPage bp = new BranchPage(driver);
		for (int i = 1; i <= 20; i++) {
			WebElement ele = bp.getDeleteBtn();

			// ele.click();
			wL.clickAction(driver, ele);

			for (int a = 33; a <= 300; a++) {
				String beforexpath = "//div[@id='modal-delete2";
				String afterxpath = "']//button[@name='braches'][normalize-space()='Delete']";
				WebElement delete2 = driver.findElement(By.xpath(beforexpath + a + afterxpath));
				if(delete2.isEnabled()) 
				{
					wL.clickAction(driver, delete2);
					wL.acceptAlert(driver);
				}

			}
			driver.navigate().refresh();

		}
	}

	// div[@id='modal-delete23']//button[@name='braches'][normalize-space()='Delete']
	// div[@id='modal-delete23']//button[@name='braches'][normalize-space()='Delete']
	// div[@id='modal-delete23']//button[@name='braches'][normalize-space()='Delete']

	@Test
	public void deleteData() {
		HomePage hp = new HomePage(driver);
		hp.getBranchLinkElement().click();
		hp.getAddBranchSubElement().click();

		BranchPage bp = new BranchPage(driver);

//		List <WebElement> trows=driver.findElements(By.xpath("//tbody/tr"));
//		List<WebElement> deleteBtns=driver.findElements(By.xpath("//tbody/tr//button[2]"));

		// div[@id='modal-delete28']//button[@name='braches'][normalize-space()='Delete']

		String beforeXpath = "//div[@id='modal-delete2";
		int a = 21;
		String afterXpath = "']//button[@name='braches'][normalize-space()='Delete']";

		while (a <= 30) {
			WebElement ele = bp.getDeleteBtn();
			wL.clickAction(driver, ele);
			for (int i = 21; i < 40; i++) {
				WebElement delete2 = driver.findElement(By.xpath(beforeXpath + i + afterXpath));
				wL.clickAction(driver, delete2);
				wL.acceptAlert(driver);
				driver.navigate().refresh();
			}

		}
	}

}