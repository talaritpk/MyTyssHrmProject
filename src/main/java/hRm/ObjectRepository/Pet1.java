package hRm.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class Pet1 {
		
		@FindBy(xpath="//iframe")
		private List<WebElement> frames;
		
		//initialization
		public Pet1(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public List<WebElement> getPet() {
			return frames;
		}
	}
	
