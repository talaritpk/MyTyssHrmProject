package hRm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.github.javafaker.Faker;

import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class AdminPage extends WebDriverLibrary{
	ExcelFileLibrary efl=new ExcelFileLibrary();
	WebDriverLibrary wl=new WebDriverLibrary();
	
	
	
	@FindBy(xpath="//h3[contains(.,'Add Admin')]")
	private WebElement addAdminRhnElement;
	
	@FindBy(name="hr_companyid")
	private WebElement cidTFElement;
	
	@FindBy(name="hr_firstname")
	private WebElement firstNameTFelElement;
	
	@FindBy(name="hr_lastname")
	private WebElement lastNameTFelElement;
	
	@FindBy(name="hr_middlename")
	private WebElement middleNameTFelElement;
	
	@FindBy(name="hr_contactno")
	private WebElement cNoTFelElement;

	@FindBy(name="hr_type")
	private WebElement hrTypeDDelElement;
	
	@FindBy(name="hr_email")
	private WebElement emailTFelElement;
	
	@FindBy(name="hr_password")
	private WebElement pwdTFelElement;
	
	@FindBy(name="hr_admin")
	private WebElement saveBtnElement;
	
	@FindBy(xpath="(//button[.='Close'])[1]")
	private WebElement closeBtnElement;
	
	public AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getAddAdminRhnElement() {
		return addAdminRhnElement;
	}

	public WebElement getCidTFElement() {
		return cidTFElement;
	}

	public WebElement getFirstNameTFelElement() {
		return firstNameTFelElement;
	}

	public WebElement getLastNameTFelElement() {
		return lastNameTFelElement;
	}

	public WebElement getMiddleNameTFelElement() {
		return middleNameTFelElement;
	}

	public WebElement getcNoTFelElement() {
		return cNoTFelElement;
	}

	public WebElement getHrTypeDDelElement() {
		return hrTypeDDelElement;
	}

	public WebElement getEmailTFelElement() {
		return emailTFelElement;
	}

	public WebElement getPwdTFelElement() {
		return pwdTFelElement;
	}

	public WebElement getSaveBtnElement() {
		return saveBtnElement;
	}

	public WebElement getCloseBtnElement() {
		return closeBtnElement;
	}
	
	public void addAdmin(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		addAdminRhnElement.click();
		cidTFElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 0));
		firstNameTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 1));
		lastNameTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 2));
		middleNameTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 3));
		cNoTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 4));
		handleDropDown(hrTypeDDelElement, 1);
		emailTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 5));
		pwdTFelElement.sendKeys(efl.readDataFromExcelFile("AdminDetails", 3, 6));
		saveBtnElement.click();
		acceptAlert(driver);
		
		
	}
	
	public void addAdminFaker(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		Faker fk=new Faker();
		addAdminRhnElement.click();
		cidTFElement.sendKeys(fk.number().digits(6));
		firstNameTFelElement.sendKeys(fk.name().firstName());
		lastNameTFelElement.sendKeys(fk.name().lastName());
		middleNameTFelElement.sendKeys(fk.name().nameWithMiddle());
		cNoTFelElement.sendKeys(fk.number().digits(11));
		handleDropDown(hrTypeDDelElement, fk.number().numberBetween(0, 4));
		emailTFelElement.sendKeys(fk.internet().emailAddress());
		pwdTFelElement.sendKeys(fk.internet().password());
		saveBtnElement.click();
	}

}
