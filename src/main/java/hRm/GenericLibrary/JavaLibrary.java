package hRm.GenericLibrary;

import java.util.Random;

public class JavaLibrary {
	
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(500);
		return value;
	}
}
