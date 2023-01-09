	package hRm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hRm.GenericLibrary.BaseClass;
import hRm.GenericLibrary.WebDriverLibrary;

public class HomePage {
	
	WebDriverLibrary wl=new WebDriverLibrary();
	@FindBy(linkText = "hrhead@gmail.com")
	private WebElement adminMailElement;
	
	@FindBy(xpath = "//b[.='Welcome!,']")
	private WebElement welcomElement;
	
	@FindBy(xpath = "//a[@href='log_out.php']")
	private WebElement logOutElement;
	
	@FindBy(xpath = "//p[contains(.,'BRANCHES')]")
	private WebElement branchLinkElement;
	
	@FindBy(xpath="//p[.='Add Braches']")
	private WebElement addBranchSubElement;
	
	
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement empLinkElement;
	
	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addEmpSubElement;
	
	
	@FindBy(xpath ="//p[contains(.,'ADMIN')]")
	private WebElement adminLinkElement;
	
	@FindBy(xpath = "//p[.='Add Admin']")
	private WebElement adminSubLinkElement;
	
	
	


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getWelcomElement() {
		return welcomElement;
	}



	public WebElement getLogOutElement() {
		return logOutElement;
	}


	
	
	public WebElement getBranchLinkElement() {
		return branchLinkElement;
	}



	public WebElement getAddBranchSubElement() {
		return addBranchSubElement;
	}



	public WebElement getAddEmpSubElement() {
		return addEmpSubElement;
	}



	public WebElement getAdminMailElement() {
		return adminMailElement;
	}
	
	public WebElement getEmpLinkElement() {
		return empLinkElement;
	}

	public WebElement getAddEmpElement() {
		return addEmpSubElement;
	}
	
	public WebElement getAdminLinkElement()
	{
		return adminLinkElement;
	}
	
	public WebElement getAdminSubLinkElement() {
		return adminSubLinkElement;
	}
	
	//BusinessLibrary
		public void clickOnAddEmp()
		{
			empLinkElement.click();
			addEmpSubElement.click();
		}
	
	public void clickAddadminLinks()
	{
		adminLinkElement.click();
		adminSubLinkElement.click();
	}
	
	public void clickOnaddBranch()
	{
		branchLinkElement.click();
		addBranchSubElement.click();
	}
	



	public void logOut(WebDriver driver) {
		welcomElement.click();
		logOutElement.click();
		wl.acceptAlert(driver);
	}
	
	

}
