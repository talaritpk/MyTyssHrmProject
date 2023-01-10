package hRm.AdminTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;
import hRm.ObjectRepository.AdminPage;
import hRm.ObjectRepository.HomePage;

public class CreateAdminTest extends BaseClass{
	
	WebDriverLibrary wLibrary=new WebDriverLibrary();
	@Test
	public void createAdmin() throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		AdminPage ap=new AdminPage(driver);
		hp.clickAddadminLinks();
		ap.addAdminFaker(driver);
		String text=wLibrary.getAlertText(driver);
		Assert.assertEquals(text, "Insert Successfully!!!");;
		Reporter.log(text,true);
		wLibrary.acceptAlert(driver);
	}
	
	
	
	
	

}
