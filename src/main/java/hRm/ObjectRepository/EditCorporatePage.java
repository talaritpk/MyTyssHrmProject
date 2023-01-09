package hRm.ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.JavaLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class EditCorporatePage {
	ExcelFileLibrary efl=new ExcelFileLibrary();
	JavaLibrary rL=new JavaLibrary();
	WebDriverLibrary wL=new WebDriverLibrary();
	
	@FindBy(xpath="//div[@id='modal-edit1']/descendant::input[@name='corporate_name']")
	private WebElement updateTFBtnElement;
	
	@FindBy(xpath="//div[@id='modal-edit1']/descendant::button[.='Update']")
	private WebElement updateBtnElement;
	
	public EditCorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getUpdateTFBtnElement() {
		return updateTFBtnElement;
	}



	public WebElement getUpdateBtnElement() {
		return updateBtnElement;
	}
	
	public void enterName_clickOnUpdate(WebDriver driver, String sheetName, int rNo, int cNo) throws EncryptedDocumentException, IOException
	{
		String CorName=efl.readDataFromExcelFile(sheetName, rNo, cNo);
		List<WebElement> updateTF=driver.findElements(By.xpath("//input[@value='"+CorName+"']"));
		
		//WebElement updateTF=driver.findElement(By.xpath("//input[@value='\"+CorName+\"']"));
		//wL.scrollAction(driver, updateTF);
		String ab=rL.getRandomNumber()+CorName;
//		updateTF.sendKeys(ab);
		for(WebElement we:updateTF)
		{
			if(updateTF.contains(CorName))
			{
				we.clear();
				we.sendKeys("pavan");
			}
		}
		
//		updateTF.clear();
		
		WebElement updateBtn=driver.findElement(By.xpath("//input[@value='"+CorName+"']/ancestor::div[@class='modal fade show']/descendant::button[.='Update']"));
		updateBtn.click();
	}

}
