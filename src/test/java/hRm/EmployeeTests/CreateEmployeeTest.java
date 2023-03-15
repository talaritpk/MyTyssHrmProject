package hRm.EmployeeTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;
@Listeners(hRm.GenericLibrary.ListenerImplmentation.class)
public class CreateEmployeeTest extends BaseClass {
	WebDriverLibrary wl=new WebDriverLibrary();
	@Test
	public void createNewEmployeeTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Faker fk=new Faker();
		
		
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hp.clickOnAddEmp();
		ep.clickOnAddEmployeeRhn();
		ep.fillDetailsAndSave(fk.idNumber().valid(), fk.name().firstName(), fk.name().lastName(), fk.name().nameWithMiddle(), fk.number().digits(6),
				fk.number().digits(6), /*fk.number().digit(), fk.number().digit()*/ fk.name().name(), fk.number().digits(11), fk.name().name(), fk.name().name(), 
				fk.name().name(), fk.name().name(), driver);
		
		String alertText=wl.getAlertText(driver);
		Assert.assertEquals(alertText, "Insert Successfully!!!");
		Reporter.log(alertText,true);
		wl.acceptAlert(driver);
		
	}







}