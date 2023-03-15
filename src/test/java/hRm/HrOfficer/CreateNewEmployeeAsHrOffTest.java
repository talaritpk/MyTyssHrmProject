package hRm.HrOfficer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.BaseClassHrOff;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

public class CreateNewEmployeeAsHrOffTest extends BaseClassHrOff {
	@Test
	public void createNewEmployee() throws EncryptedDocumentException, IOException, InterruptedException
	{
Faker fk=new Faker();
		
		
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hp.clickOnAddEmp();
		ep.clickOnAddEmployeeRhn();
		ep.fillDetailsAndSave(fk.idNumber().valid(), fk.name().firstName(), fk.name().lastName(), fk.name().nameWithMiddle(), fk.number().digits(6),
				fk.number().digits(6), /*fk.number().digit(), fk.number().digit()*/ fk.name().name(), fk.number().digits(11), fk.name().name(), fk.name().name(), 
				fk.name().name(), fk.name().name(), driver);
		
		
		
		
	}
	
	

	
	
}
