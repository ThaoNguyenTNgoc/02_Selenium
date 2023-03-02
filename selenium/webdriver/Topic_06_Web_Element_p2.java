package webdriver;
//import java.util.concurrent.TimeUnit;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_p2 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	By emailTextbox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("under_18");
	By eduCationTextArea = By.cssSelector("edu");
	By nameUser5Text = By.xpath("//div//h5[text()='Name: User5']");
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
	}else 
	{
		System.out.println("Email textbox is not dispayed");
	}
	
	System.out.println();
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
