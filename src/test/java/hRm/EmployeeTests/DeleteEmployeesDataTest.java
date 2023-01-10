package hRm.EmployeeTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

public class DeleteEmployeesDataTest extends BaseClass {
	@Test
	public void deleteDataOneByOne() {
		WebDriverLibrary wl = new WebDriverLibrary();
		HomePage hp = new HomePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		hp.clickOnAddEmp();
		wl.clickAction(driver, ep.getDeleteLookUpIamgeElement());
		// ep.getDeleteLookUpIamgeElement().click();

		// List<WebElement>
		// deletebtns=ep.getDeleteBtnElement();//driver.findElements(By.xpath("//button[.='Delete']"));

		for (WebElement d : ep.getDeleteBtnElement()) {
			wl.clickAction(driver, d);

			wl.acceptAlert(driver);
			// System.out.println(d.getText());

		}
		driver.navigate().refresh();

	}

	@Test
	public void deleteData() {

		WebDriverLibrary wl = new WebDriverLibrary();
		HomePage hp = new HomePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		hp.clickOnAddEmp();
		wl.clickAction(driver, ep.getDeleteLookUpIamgeElement());
		//table//tbody//tr//td[9]//i[2]
//		for (int i = 335; i <= 400; i++) {
//			String beforeXpath = "//div[@id='modal-delete" + i + "']";
//			String afterXpath = "//button[@name='delete3'][normalize-space()='Delete']";
//		WebElement ele=driver.findElement(By.xpath(beforeXpath+afterXpath));
//		if(ele.isDisplayed())
//		{
//			System.out.println("enabled");
//		}
//			
//		}
		
		
		
		
		
		
		
		for(int i=0;i<370;i++) {
		WebElement element=driver.findElement(By.xpath("//div[@id='modal-delete"+i+"']"));//("");    //button[@name='delete3'][normalize-space()='Delete']
		if(element.isDisplayed())
		{
			System.out.println("pavan");
		}
		else
		{
			System.out.println("not avilabale");
		}
		}
	}

}
