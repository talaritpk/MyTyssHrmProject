package practice;



import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import hRm.GenericLibrary.JavaLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Random {
	
	public static void main(String[] args) {
		JavaLibrary jl=new JavaLibrary();
//		 int i = jl.getRandomNumber();
//		System.out.println(i);
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver =new EdgeDriver();
		//Wed Jan 11 13:29:08 IST 2023
		
		Date d=new Date();
		String dString=d.toString();
				System.out.println(dString);
				
				
				String [] strings=dString.toString().split(" ");
				String month =strings[1];
				String dateString=strings[2];
				String year=strings[5];
				String time=strings[3].replace(':', '-');
				String dom=strings[0];
				
				String dateInFor=dateString+" "+month+" "+year+" "+time+" "+dom;
				System.out.println(dateInFor);
		
	}

}
