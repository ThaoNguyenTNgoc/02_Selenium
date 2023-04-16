package webdriver;
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_p2 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	By emailTextbox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By eduCationTextArea = By.cssSelector("#edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By job1Dropdown= By.cssSelector("#job1");
	
	By job2Dropdown= By.cssSelector("#job2");
	By interestCheckbox= By.cssSelector("#development");
	By slider01=By.cssSelector("#slider-1");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Url() {
	driver.get("https://automationfc.github.io/basic-form/index.html"); 	
	// textbox/ textarea nếu có hiển thị thì nhập text vào và in ra console
	
	if(driver.findElement(emailTextbox).isDisplayed()) {
		driver.findElement(emailTextbox).sendKeys("Tharo beautifull");
		System.out.println("Email textbox is dispayed"+"Tharo" );
		sleepInSecond(3);
	}else 
	{
		System.out.println("Email textbox is not dispayed");
		
	}
	
//	TextArea
	
	if (driver.findElement(eduCationTextArea).isDisplayed()) {
		driver.findElement(eduCationTextArea).sendKeys("Đại Học");
		System.out.println("eduCationTextArea is display"+"Tharo");
		sleepInSecond(3);
	} else {
		System.out.println("eduCationTextArea is not display"+"Tharo");

	}
	
//	AgeUnder18
	
	if (driver.findElement(ageUnder18Radio).isDisplayed()) {
		driver.findElement(ageUnder18Radio).click();
		System.out.println("ageUnder18Radio is display"+"Tharo");
		sleepInSecond(3);
		
	} else {
		System.out.println("ageUnder18Radio is not display"+"Tharo");

	}
	
// User5 
	if (driver.findElement(nameUser5Text).isDisplayed()) {
		driver.findElement(nameUser5Text).click();
		System.out.println("Element is display"+"Tharo");
		sleepInSecond(3);
		
	} else {
		System.out.println("Element is not display");
	}
	
//	System.out.println("Thảo đẹp gái");
	}
	
	
	@Test
	public void TC_02_Enabled() {
	
		driver.get("https://automationfc.github.io/basic-form/index.html");
		if (driver.findElement(emailTextbox).isEnabled()) {
//			driver.findElement(emailTextbox).click();
			System.out.println("Element isEnabled"+"emailTextbox");
			
		} else {
			System.out.println("Element is disEnabled");

		}
	
//Ageunder18radio	
	
	if (driver.findElement(ageUnder18Radio).isEnabled()) {
		System.out.println("Element isEnabled"+"Ageunder18radio");
		
	} else {
		System.out.println("Element is disEnabled");

	}
	
//	educationTextbox
	if (driver.findElement(eduCationTextArea).isEnabled()) {
		System.out.println("Element isEnabled"+" eduCationTextArea");
		
	} else {
		System.out.println("Element is disEnabled"+"eduCationTextArea");

	}
	
//jobrole01/jobrole02
	if(driver.findElement(job1Dropdown).isEnabled()|| driver.findElement(job2Dropdown).isEnabled()) {
		if(driver.findElement(job1Dropdown).isEnabled()) {
		System.out.println("Element is Enabled"+" jobrole01");
		}
		if (driver.findElement(job1Dropdown).isEnabled()){
			System.out.println("Element is Enabled"+" jobrole02");
			sleepInSecond(3); }
				
	}
	else {
		System.out.println("Element is disEnabled" +"jobrole01&02");
		
	}
//	INterests check box 

	if (driver.findElement(interestCheckbox).isEnabled()) {
		System.out.println("Element isEnabled"+" interestCheckbox");
		
	} else {
		System.out.println("Element is disEnabled" + "interestCheckbox");
}
//	Slider 01 

	if (driver.findElement(slider01).isEnabled()) {
		System.out.println("Element isEnabled"+" slider01");
		
	} else {
		System.out.println("Element is disEnabled" + "slider01");
}
	


}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond *1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
