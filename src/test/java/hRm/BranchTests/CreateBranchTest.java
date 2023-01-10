package hRm.BranchTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.BranchPage;
import hRm.ObjectRepository.HomePage;

//@Listeners(hRm.GenericLibrary.ListenerImplmentation.class)
public class CreateBranchTest extends BaseClass {
	WebDriverLibrary wL=new WebDriverLibrary();
	@Test
	public void createNewBranch() throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnaddBranch();
		BranchPage bp=new BranchPage(driver);
		bp.clickOnaddBranchAndSave(driver);
		String alText=wL.getAlertText(driver);
		Assert.assertEquals(alText, "Insert Successfully!!!");
		
	}
	
}
