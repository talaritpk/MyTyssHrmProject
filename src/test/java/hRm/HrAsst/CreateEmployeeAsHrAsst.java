package hRm.HrAsst;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

public class CreateEmployeeAsHrAsst extends BaseClass {
	
	@Test
	public void createNewEmployee() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hp.clickOnAddEmp();
		ep.clickOnAddEmployeeRhn();
		ep.fillDataForEmpCreation(driver);
		
	}

}
