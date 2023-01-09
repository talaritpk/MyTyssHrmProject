package hRm.EmployeeTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

public class DeleteEmployeesData extends BaseClass{
	@Test
	public void deleteDataOneByOne()
	{
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hp.clickOnAddEmp();
		
		ep.getDeleteLookUpIamgeElement().click();
		
		List<WebElement> deletebtns=driver.findElements(By.xpath("//button[.='Delete']"));
		
		for(WebElement d:deletebtns)
		{
			d.click();
			System.out.println(d);
		}
	}

}
