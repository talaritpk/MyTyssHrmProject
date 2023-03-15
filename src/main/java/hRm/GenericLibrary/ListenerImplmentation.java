package hRm.GenericLibrary;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplmentation implements ITestListener{
	
	
	
	ExtentReports reports;
	ExtentTest test;
	JavaLibrary jl=new JavaLibrary();

	public void onTestStart(ITestResult result) {
		String method=result.getMethod().getMethodName();
		test=reports.createTest(method);
		
		test.log(Status.INFO, "Execution Of Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--->Passed");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wL=new WebDriverLibrary();
		
		String methodName=result.getMethod().getMethodName()+" "+jl.getSystemDateInFormat();
		try 
		{
			String path=wL.takeFailedTestCaseScreenShot(BaseClass.sDriver, methodName);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, result.getThrowable());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./target/ExtentReports/"+"Report"+jl.getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Reports For Enresource");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Enresource Execution Reports");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Reporter Name", "pavan");
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution is Finished", true);
		reports.flush();
	}
	
	

}
