package TestNg;

import org.testng.Assert;

public class Test_01_Assert {

	public static void main (String[] args) {
		String fullName= "Automation Testing";
		//Assert
		
		//Mong đợi 1 đk trả về là đúng (true) 
		Assert.assertTrue(fullName.contains("Automation"));
		Assert.assertTrue(3<5);
		

		//Mong đợi 1 đk trả về là đúng (false) 
		Assert.assertFalse(fullName.contains("automation1"));
		Assert.assertFalse(3>5);
		
		//Mong đợi 2 đk bằng nhau
		 Assert.assertEquals(fullName, "Automation Testing");
	}
}
