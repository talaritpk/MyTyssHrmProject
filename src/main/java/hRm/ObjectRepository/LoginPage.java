package hRm.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hRm.GenericLibrary.PropertyFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class LoginPage {
	PropertyFileLibrary pfl=new PropertyFileLibrary();
	WebDriverLibrary wLibrary=new WebDriverLibrary();
	
	
	@FindBy(name="hr_email")
	private WebElement unameElement;
	
	@FindBy(name="hr_password")
	private WebElement pwdElement;
	
	@FindBy(id="hr_type")
	private WebElement hrTypeDD;
	
	@FindBy(id="remember")
	private WebElement checkBoxElement;
	
	@FindBy(name="login_hr")
	private WebElement signInElement;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getUnameElement() {
		return unameElement;
	}


	public WebElement getPwdElement() {
		return pwdElement;
	}


	public WebElement getHrTypeDD() {
		return hrTypeDD;
	}


	public WebElement getCheckBoxElement() {
		return checkBoxElement;
	}


	public WebElement getSignInElement() {
		return signInElement;
	}
	
	//Business Library
	public void loginToHrmAsHr(WebDriver driver) throws IOException
	{
		unameElement.sendKeys(pfl.readDataFromPropertyFile("HrEmail"));
		pwdElement.sendKeys(pfl.readDataFromPropertyFile("HrPwd"));
		wLibrary.handleDropDown(hrTypeDD, 1);
		checkBoxElement.click();
		signInElement.click();
		wLibrary.acceptAlert(driver);
	}
	
	public void loginToHrmAsHrOff(WebDriver driver) throws IOException
	{
		unameElement.sendKeys(pfl.readDataFromPropertyFile("HrOfficerEmail"));
		pwdElement.sendKeys(pfl.readDataFromPropertyFile("HrOfficerPwd"));
		wLibrary.handleDropDown(hrTypeDD, 2);
		checkBoxElement.click();
		signInElement.click();
		wLibrary.acceptAlert(driver);
	}
	
	public void loginToHrmAsHrAsst(WebDriver driver) throws IOException
	{
		unameElement.sendKeys(pfl.readDataFromPropertyFile("HrAsstEmail"));
		pwdElement.sendKeys(pfl.readDataFromPropertyFile("HrAsstPwd"));
		wLibrary.handleDropDown(hrTypeDD, 3);
		checkBoxElement.click();
		signInElement.click();
		wLibrary.acceptAlert(driver);
	}
	

}
