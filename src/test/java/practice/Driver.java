package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
	}

}
