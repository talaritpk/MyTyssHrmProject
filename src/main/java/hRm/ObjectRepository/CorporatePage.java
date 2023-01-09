package hRm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.JavaLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class CorporatePage  extends BaseClass{
	ExcelFileLibrary efl=new ExcelFileLibrary();
	WebDriverLibrary wl=new WebDriverLibrary();
	JavaLibrary rL=new JavaLibrary();
	//WebDriver driver;

	@FindBy(xpath="//p[contains(text(),'CORPORATE')]")
	private WebElement corLinkElement;
	
	@FindBy(xpath="//p[.='Add Corporate']")
	private WebElement addCorElement;
	
	@FindBy(xpath="//button[contains(.,'Add Corporate')]")
	private WebElement addCorRhnElement;
	
	@FindBy(name="corporate_name")
	private WebElement corNameTextFieldElement;
	
	@FindBy(name="corp")
	private WebElement saveBtnElement;
	
	@FindBy(xpath="//div[@id='modal-overlay']/descendant::form/descendant::button[1]")
	private WebElement closeBtnElement;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchElement;
	
	@FindBy(xpath = "//tbody/descendant::button[.='Edit']")
	private WebElement editBtnElement;
	
	
	
	@FindBy(xpath="//select[@name='example1_length']")
	private WebElement noDD;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/button[2]")
	private WebElement deleteBtnElement;
	
	
	
	
	
	
	
	public CorporatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	public WebElement getNoDD() {
		return noDD;
	}





	public WebElement getDeleteBtnElement() {
		return deleteBtnElement;
	}





	public WebElement getSearchElement() {
		return searchElement;
	}



	public WebElement getCorLinkElement() {
		return corLinkElement;
	}


	public WebElement getAddCorElement() {
		return addCorElement;
	}


	public WebElement getAddCorRhnElement() {
		return addCorRhnElement;
	}


	public WebElement getCorNameTextFieldElement() {
		return corNameTextFieldElement;
	}


	public WebElement getSaveBtnElement() {
		return saveBtnElement;
	}


	public WebElement getCloseBtnElement() {
		return closeBtnElement;
	}
	
	
	public void createcorporate() throws EncryptedDocumentException, IOException
	{
		ExcelFileLibrary efl=new ExcelFileLibrary();
		corLinkElement.click();
		addCorElement.click();
		addCorRhnElement.click();
	}
	public void enterCorNameAndSave(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		ExcelFileLibrary efl=new ExcelFileLibrary();
		corNameTextFieldElement.sendKeys(efl.readDataFromExcelFile(sheetName,rowNo,cellNo));
		saveBtnElement.click();
	}
	
	public void enterCorNameAndSave(String corName)
	{
		ExcelFileLibrary efl=new ExcelFileLibrary();
		corNameTextFieldElement.sendKeys(corName);
		saveBtnElement.click();
	}
	
	public void searchAndEditCor(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		String CorName=efl.readDataFromExcelFile("HrmApp", 4, 0);
		
		searchElement.sendKeys(CorName);
	
		driver.findElement(By.xpath("//td[.='"+CorName+"']"));
		editBtnElement.click();
	}
}
