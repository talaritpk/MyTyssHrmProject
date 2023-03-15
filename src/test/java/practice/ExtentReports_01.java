package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import hRm.GenericLibrary.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(hRm.GenericLibrary.ListenerImplmentation.class)
public class ExtentReports_01 extends BaseClass{
	@Test
	public void extentReport() throws IOException
	{
//		
//		ExtentSparkReporter er=new ExtentSparkReporter("./target/ExtentReports/ExtentReports_03.html");
//		er.config().setDocumentTitle("Pavan Reports");
//		er.config().setTheme(Theme.STANDARD);
//		er.config().setReportName("PracticeExtent");
		
		
//		ExtentReports reports=new ExtentReports();
//		reports.attachReporter(er);
//		reports.setSystemInfo("Qa", "pavanKumar");
//		reports.setSystemInfo("Browser", "Chrome");
//		
//		ExtentTest test=reports.createTest("hello");
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver =new FirefoxDriver();
//		driver.get("https://www.facebook.com");
		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File sf=ts.getScreenshotAs(OutputType.FILE);
//		String path="./target/ScreenShots/sreenshot_01.png";
//		File df=new File(path);
//		Files.copy(sf, df);
//		String abPath = df.getAbsolutePath();
		//String abPath=System.getProperty("user.dir")+path;
		
		
//		test.addScreenCaptureFromPath(abPath);
//		test.log(Status.FAIL, "Method Failed");
//		
//		System.out.println(driver.getTitle());
//		reports.flush();
		Assert.assertEquals(false, true);
		
		
		
	}

}
