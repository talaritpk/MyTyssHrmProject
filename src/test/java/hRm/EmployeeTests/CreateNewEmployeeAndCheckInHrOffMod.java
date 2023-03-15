package hRm.EmployeeTests;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;
import hRm.ObjectRepository.HrOffEmployeePage;
import hRm.ObjectRepository.LoginPage;

public class CreateNewEmployeeAndCheckInHrOffMod extends BaseClass{
	ExcelFileLibrary efl = new ExcelFileLibrary();
	WebDriverLibrary wl=new WebDriverLibrary();
	@Test
	public void createNewEmployeeTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Faker fk=new Faker();
		
		
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hp.clickOnAddEmp();
		ep.clickOnAddEmployeeRhn();
		//ep.fillDetailsAndSave(fk.idNumber().valid(), fk.name().firstName(), fk.name().lastName(), fk.name().nameWithMiddle(), fk.number().digits(6),
			//	fk.number().digits(6), /*fk.number().digit(), fk.number().digit()*/ fk.name().name(), fk.number().digits(11), fk.name().name(), fk.name().name(), 
				//fk.name().name(), fk.name().name(), driver);
		
		ep.fillDataForEmpCreation(driver);
		
		
	
		
//		String alertText=wl.getAlertText(driver);
//		Assert.assertEquals(alertText, "Insert Successfully!!!");
//		Reporter.log(alertText,true);
//		wl.acceptAlert(driver);
		
		hp.logOut(driver);
		
		LoginPage lp=new LoginPage(driver);
		HrOffEmployeePage hef=new HrOffEmployeePage(driver);
		lp.loginToHrmAsHrOff(driver);
		hef.clickOnEmployeeLinks();
		
		List<WebElement> ele=driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for(WebElement e:ele)
		{
			String cid=e.getText();
			if(cid.contains(efl.readDataFromExcelFile("employee", 2, 0)))
			{
				Reporter.log(cid+"data is present ",true);
			}
		}
		

}
}
