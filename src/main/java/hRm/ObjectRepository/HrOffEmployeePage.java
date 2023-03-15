package hRm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrOffEmployeePage {
	
	
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement empLinkElement;
	
	
	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addEmpSubElement;
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[3]")
	private WebElement deleteLookUpIamgeElement;
	
	
	public HrOffEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getEmpLinkElement() {
		return empLinkElement;
	}


	public WebElement getAddEmpSubElement() {
		return addEmpSubElement;
	}
	
	
	
	
	public WebElement getDeleteLookUpIamgeElement() {
		return deleteLookUpIamgeElement;
	}



	public void clickOnEmployeeLinks()
	{
		empLinkElement.click();
		addEmpSubElement.click();
	}
	
	
	

}
