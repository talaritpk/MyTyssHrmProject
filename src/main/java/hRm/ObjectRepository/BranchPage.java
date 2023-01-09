package hRm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class BranchPage {
	ExcelFileLibrary efl=new ExcelFileLibrary();
	WebDriverLibrary wLibrary=new WebDriverLibrary();
	
	@FindBy(xpath="//button[contains(.,'Add Branches')]")
	private WebElement addBranchRhnElement;
	
	@FindBy(name="branches_name")
	private WebElement branchTF;
	
	@FindBy(name="bran")
	private WebElement saveBtnElement;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement closeBtnElement;
	
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/button[2]")
	private WebElement deleteBtn;//////////////////////////delete1///////////////
	
	
	
	
	
	
	
	
	@FindBy(xpath="//tbody/tr")
	private WebElement trows;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getTrows() {
		return trows;
	}
	
	
	
	
	
	
	


	public BranchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}


	public WebElement getAddBranchRhnElement() {
		return addBranchRhnElement;
	}
	
	
	
	public WebElement getSaveBtnElement() {
		return saveBtnElement;
	}

	public WebElement getCloseBtnElement() {
		return closeBtnElement;
	}

	public WebElement getBranchTF() {
		return branchTF;
	}

	public void clickOnaddBranchAndSave(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		Faker fkFaker=new Faker();
		addBranchRhnElement.click();
		String bname=fkFaker.name().name();
		branchTF.sendKeys(bname);
		efl.writeDataIntoExcelFile("Branch", 7, 0, bname);
		saveBtnElement.click();
		wLibrary.acceptAlert(driver);
	}
	
	public void clickObAddBranchAndSave(String branchName, WebDriver driver)
	{
		addBranchRhnElement.click();
		branchTF.sendKeys(branchName);
		saveBtnElement.click();
		wLibrary.acceptAlert(driver);
	}
	
	public void clickOnDelete()
	{
		
	}

}
