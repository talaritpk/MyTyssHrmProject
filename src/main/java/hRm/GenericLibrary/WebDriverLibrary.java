package hRm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverLibrary {
	/**
	 * Maximize
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Minimize
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * Implicit Wait
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * Explicit Wait
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait ww=new WebDriverWait(driver, Duration.ofSeconds(10));
		ww.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	/**
	 * Explicit Wait
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Dropdown Handling
	 * @param element
	 * @param text
	 */
	public void handleDropdown(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByValue(text);
	}
	
	/**
	 * Dropdown Handling
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * Dropdown Handling
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * MouseHover
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * RightClick
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver,WebElement element)
	{
		Actions actions =new Actions(driver);
		actions.contextClick(element);
	}
	
	/**
	 * DragAndDrop
	 * @param driver
	 * @param source
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement dest)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source,dest).perform();
	}
	
	/**
	 * DoubleClick
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/**
	 * Accept Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will return the text of alert pop up to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	
	/**
	 * Scrolling
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		//int y = element.getLocation().getY();
		//js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * Click Using JavaScriptExecutor
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		//int y = element.getLocation().getY();
		//js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * Click Using JavaScriptExecutor
	 * @param driver
	 * @param script
	 */
	public void clickAction(WebDriver driver,String script)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}
	
	
	public String takeFailedTestCaseScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dtn=new File("./target/ScreenShots/"+screenshotName+".png");
		Files.copy(src, dtn);
		String path=dtn.getAbsolutePath();
		return path;
	}
	
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//Step 1: get all the window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2: iterate through all the window ids --- similar to foreach loop
		Iterator<String> it = windowIds.iterator();
		
		//Step 3: navigate to each window and check the title
		while(it.hasNext())
		{
			//Step 4: capture the individual window id
			String winID = it.next();
		
			//Step 5: switch to that window and capture the title
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 6: compare current title with partial title
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
	}
	
}
