package webdriver;

import java.util.Random;
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

	Random rand;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email_rand, firstName, lastName, fullName, passWord ; 

	
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		rand= new Random(); 
		email_rand= "automation" +rand.nextInt(4444)+"@gmail.com"; 
		firstName="Ngọc Thảo"; 
		lastName="Nguyễn";
		fullName=firstName+ lastName; 
		passWord="12345678@";
	}

	
	/*
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
	
	public void TC_03_Login_with_password_less() {
	driver.get("http://live.techpanda.org/");
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	sleepInSecond(1);
	driver.findElement(By.id("email")).sendKeys("automation@gmail.com"); // này là nhập chuỗi 
	// này là nhập cái email random được truyền vào biển email_rand trước đó
	driver.findElement(By.id("email")).sendKeys(email_rand); 

	
	driver.findElement(By.id("pass")).sendKeys("123");
	driver.findElement(By.id("send2")).click();
	Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	
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
	*/
	@Test
	public void TC_05_Create_new_account() {
	driver.get("http://live.techpanda.org/");
	
	driver.findElement(By.xpath("//div[@class='footer']//div/ul/li/a[@title='My Account']")).click();
	sleepInSecond(1);
	
	driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
	sleepInSecond(3);
	
	driver.findElement(By.id("firstname")).sendKeys(firstName);
	driver.findElement(By.id("middlename")).sendKeys("Thị");	
	driver.findElement(By.id("lastname")).sendKeys(fullName);
	driver.findElement(By.id("email_address")).sendKeys(email_rand);
	driver.findElement(By.id("password")).sendKeys(passWord);
	driver.findElement(By.id("confirmation")).sendKeys(passWord);
	driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']")).click();	
	sleepInSecond(3);
	Assert.assertEquals(driver.findElement(By.xpath("//div//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
	
	String containInformation= driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
	
	System.out.println(containInformation);
	
	Assert.assertTrue(containInformation.contains(fullName));
	Assert.assertTrue(containInformation.contains(email_rand));
	driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click(); 
	sleepInSecond(2);
	driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();
	sleepInSecond(2);
	Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/logoutSuccess/");
	
	Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed());
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
