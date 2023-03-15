package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.JsonParser;

public class ReadDataFromJSON {
	
	@Test
	public void readDataFromJSON() throws FileNotFoundException
	{
		FileReader fReader=new FileReader("./jsonData.json");
		JsonParser jParser=new JsonParser();
		Object obj =jParser.parse(fReader);
		
		HashMap hMap=(HashMap)obj;
		System.out.println(hMap.get("browser"));
		
	}
}
