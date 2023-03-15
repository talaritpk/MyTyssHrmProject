package hRm.BranchTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import hRm.GenericLibrary.BaseClass;
import hRm.ObjectRepository.HomePage;

public class PrintAllTheData extends BaseClass {
	
	@Test
	public void printAllData()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnaddBranch();
		
		
		int rows=driver.findElements(By.xpath("//table//tbody//tr")).size();
		int columns=driver.findElements(By.xpath("//table//tbody//tr[1]//td")).size();
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=1;j<=columns;j++)
			{
				String data=driver.findElement(By.xpath("//table//tbody//tr["+ i +"]//td["+  j +"]")).getText();
				System.out.print(data+" ");
			}
			System.out.println(" ");
		}
	}
	

}
