package hRm.EmployeeTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.EmployeePage;
import hRm.ObjectRepository.HomePage;

@Listeners(hRm.GenericLibrary.ListenerImplmentation.class)
public class CreateMultipleEmployeesTest extends BaseClass {
	
	
	@Test(dataProvider = "multipledata")
	public void createMultipleEmployee(String number, String firstName, String lastName, String midNme, String fromDate,
			String recDate,/*String deptDDno, String BranchDDno,*/ String positn, String cNo, String sssTx, String TinNo,
			String Hdmf, String Gsis) throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hPage=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		hPage.clickOnAddEmp();
		ep.clickOnAddEmployeeRhn();
		ep.fillDataForEmpCreation(driver);
		
		
	}
	
	
	
	
	@DataProvider(name="multipledata")
	public Object[][] createMultipleEmployees() throws EncryptedDocumentException, IOException
	{
		Object[][] o=el.readMutipleDataFromExcelFile("emp");
		return o;
	}
}
