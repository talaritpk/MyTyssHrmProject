package hRm.ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;

import hRm.GenericLibrary.ExcelFileLibrary;
import hRm.GenericLibrary.WebDriverLibrary;

public class EmployeePage {

	ExcelFileLibrary efl = new ExcelFileLibrary();
	WebDriverLibrary wl = new WebDriverLibrary();

	@FindBy(xpath = "//h3[contains(.,'Add Employee')]")
	private WebElement addEmpElementRhn;

	@FindBy(name = "employee_companyid")
	private WebElement comIdElement;

	@FindBy(name = "employee_firstname")
	private WebElement firstNameElement;

	@FindBy(name = "employee_lastname")
	private WebElement lastNameElement;

	@FindBy(name = "employee_middlename")
	private WebElement middleNameElement;

	@FindBy(name = "branches_datefrom")
	private WebElement dateFromElement;

	@FindBy(name = "branches_recentdate")
	private WebElement recentDatElement;

	@FindBy(name = "employee_department")
	private WebElement deptDD;

	@FindBy(name = "employee_branches")
	private WebElement brachDD;

	@FindBy(name = "employee_position")
	private WebElement positionTextFiElement;

	@FindBy(name = "employee_contact")
	private WebElement contactNOTextFiElement;

	@FindBy(name = "employee_sss")
	private WebElement sssTextFiElement;

	@FindBy(name = "employee_tin")
	private WebElement tinTextFiElement;

	@FindBy(name = "employee_hdmf_pagibig")
	private WebElement hdmfTextFiElement;

	@FindBy(name = "employee_gsis")
	private WebElement gsisTextFiElement;

	@FindAll({ @FindBy(xpath = "//input[contains(@accept,'.docx')]"), @FindBy(name = "employee_file201") })
	private WebElement file201Element;

	@FindBy(xpath = "//form[@action='process/addemployee_process.php']/descendant::input[@name='employee_image']")
	private WebElement empPicturElement;

	@FindBy(name = "emplo")
	private WebElement saveBtnElement;

	@FindBy(xpath = "(//button[.='Close'])[1]")
	private WebElement closeBtnElement;
	
	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[2]")
	private WebElement deleteLookUpIamgeElement;
	
	@FindBy(xpath = "//button[.='Delete']")
	private List<WebElement> deleteBtnElement;
	
	
	
	
	
	

	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	
	
	
	public List<WebElement> getDeleteBtnElement() {
		return deleteBtnElement;
	}








	public void setDeleteBtnElement(List<WebElement> deleteBtnElement) {
		this.deleteBtnElement = deleteBtnElement;
	}








	public WebElement getDeleteLookUpIamgeElement() {
		return deleteLookUpIamgeElement;
	}




	public void setDeleteLookUpIamgeElement(WebElement deleteLookUpIamgeElement) {
		this.deleteLookUpIamgeElement = deleteLookUpIamgeElement;
	}




	public WebElement getAddEmpElementRhn() {
		return addEmpElementRhn;
	}
	
	

	public WebElement getComIdElement() {
		return comIdElement;
	}

	public WebElement getFirstNameElement() {
		return firstNameElement;
	}

	public WebElement getLastNameElement() {
		return lastNameElement;
	}

	public WebElement getMiddleNameElement() {
		return middleNameElement;
	}

	public WebElement getDateFromElement() {
		return dateFromElement;
	}

	public WebElement getRecentDatElement() {
		return recentDatElement;
	}

	public WebElement getDeptDD() {
		return deptDD;
	}

	public WebElement getBrachDD() {
		return brachDD;
	}

	public WebElement getPositionTextFiElement() {
		return positionTextFiElement;
	}

	public WebElement getContactNOTextFiElement() {
		return contactNOTextFiElement;
	}

	public WebElement getSssTextFiElement() {
		return sssTextFiElement;
	}

	public WebElement getTinTextFiElement() {
		return tinTextFiElement;
	}

	public WebElement getHdmfTextFiElement() {
		return hdmfTextFiElement;
	}

	public WebElement getGsisTextFiElement() {
		return gsisTextFiElement;
	}

	public WebElement getFile201Element() {
		return file201Element;
	}

	public WebElement getEmpPicturElement() {
		return empPicturElement;
	}

	public WebElement getSaveBtnElement() {
		return saveBtnElement;
	}

	public WebElement getCloseBtnElement() {
		return closeBtnElement;
	}

	public void clickOnAddEmployeeRhn()
	{
		addEmpElementRhn.click();
	}

	public void fillDataForEmpCreation(WebDriver driver)
			throws EncryptedDocumentException, IOException, InterruptedException {

		comIdElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 0));
		firstNameElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 1));
		lastNameElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 2));
		middleNameElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 3));
		dateFromElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 4));
		recentDatElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 5));
		wl.handleDropDown(deptDD, 5);
		wl.handleDropDown(brachDD, 2);
		positionTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 6));
		contactNOTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 7));
		sssTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 8));
		tinTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 9));
		hdmfTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 10));
		gsisTextFiElement.sendKeys(efl.readDataFromExcelFile("EmployeeDetails", 2, 11));
		wl.scrollAction(driver, closeBtnElement);
		wl.clickAction(driver, file201Element);
		Runtime.getRuntime().exec("C:\\Users\\tpkta\\OneDrive\\Desktop\\AutoIt\\File201SoftCopy.au4.exe");
		wl.waitForElementToBeClickable(driver, empPicturElement);
		wl.clickAction(driver, empPicturElement);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\tpkta\\OneDrive\\Desktop\\AutoIt\\File201SoftCopy.au4.exe");
		Thread.sleep(10000);
		saveBtnElement.click();
		wl.acceptAlert(driver);
	}
	

	

	

	public void fillDetailsAndSave(String number, String firstName, String lastName, String midNme, String fromDate,
			String recDate,/* String deptDDno, String BranchDDno,*/ String positn, String cNo, String sssTx, String TinNo,
			String Hdmf, String Gsis, WebDriver driver) throws IOException, InterruptedException {
		comIdElement.sendKeys(number);
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		middleNameElement.sendKeys(midNme);////
		dateFromElement.sendKeys(fromDate);
		recentDatElement.sendKeys(recDate);////
		wl.handleDropDown(deptDD, 3);																			//wl.handleDropdown(deptDD, deptDDno);
		wl.handleDropDown(deptDD, 2);																								//wl.handleDropdown(brachDD, BranchDDno);//
		positionTextFiElement.sendKeys(positn);
		contactNOTextFiElement.sendKeys(cNo);//
		sssTextFiElement.sendKeys(sssTx);
		tinTextFiElement.sendKeys(TinNo);
		hdmfTextFiElement.sendKeys(Hdmf);/////
		gsisTextFiElement.sendKeys(Gsis);
		wl.scrollAction(driver, closeBtnElement);
		wl.clickAction(driver, file201Element);///////
		Runtime.getRuntime().exec("C:\\Users\\tpkta\\OneDrive\\Desktop\\AutoIt\\File201SoftCopy.au4.exe");
		wl.waitForElementToBeClickable(driver, empPicturElement);
		wl.clickAction(driver, empPicturElement);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\tpkta\\OneDrive\\Desktop\\AutoIt\\File201SoftCopy.au4.exe");
		Thread.sleep(10000);
		saveBtnElement.click();
		
		
	}

}
