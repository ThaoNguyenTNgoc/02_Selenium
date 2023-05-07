package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_06_Web_Element_p3 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	

	
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Test
	public void TC_01_Login_with_empty() {
	driver.get("http://live.techpanda.org/");
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	sleepInSecond(1);
	driver.findElement(By.id("send2")).click();
	Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
	Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	sleepInSecond(1);
	}
	
	
	@Test
	public void TC_02_Login_with_invalid_email() {
	driver.get("http://live.techpanda.org/");
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	sleepInSecond(1);
	driver.findElement(By.id("email")).sendKeys("123131231312313@12312312313");
	driver.findElement(By.id("pass")).sendKeys("123456");
	driver.findElement(By.id("send2")).click();
	Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Login_with_password_less() {
	driver.get("http://live.techpanda.org/");
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	sleepInSecond(1);
	driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("123");
	driver.findElement(By.id("send2")).click();
	Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_04_Login_with_incorrect() {
	driver.get("http://live.techpanda.org/");
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	sleepInSecond(1);
	driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("123123123");
	driver.findElement(By.id("send2")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//div//li[@class='error-msg']")).getText(), "Invalid login or password.");
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
