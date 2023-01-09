package hRm.AdminTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.AdminPage;
import hRm.ObjectRepository.HomePage;

public class CreateAdmin extends BaseClass{
	
	
	@Test
	public void createAdmin() throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		AdminPage ap=new AdminPage(driver);
		hp.clickAddadminLinks();
		ap.addAdmin(driver);
	}
	
	
	
	
	

}
