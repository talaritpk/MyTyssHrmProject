package hRm.BranchTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.BranchPage;
import hRm.ObjectRepository.HomePage;

public class CreateMultipleBranches extends BaseClass{

	WebDriverLibrary wL=new WebDriverLibrary();
	ExcelFileLibrary efl=new ExcelFileLibrary();
	
	@Test(dataProvider = "Multiple Branch")
	public void createNewBranch(String bName) throws EncryptedDocumentException, IOException
	{
		
		
		HomePage hp=new HomePage(driver);
		hp.clickOnaddBranch();
		BranchPage bp=new BranchPage(driver);
		bp.clickObAddBranchAndSave(bName, driver);
		
	}
	
	@DataProvider(name="Multiple Branch")
	public Object[][] readData() throws EncryptedDocumentException, IOException
	{
		Object[][] data=efl.readMutipleDataFromExcelFile("Branch");
		return data;
	}
}
