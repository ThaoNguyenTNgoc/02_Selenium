package webdriver;
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_mfast_Web_Element2 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_WebElement() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		// Tương tác được với Element thì cần tìm được element đó
		// Thông qua các locator của nó

		WebElement emailTextbox = driver.findElement(By.id("Email"));
		WebElement passwordTextbox = driver.findElement(By.id("Password"));

		emailTextbox.sendKeys("");
		passwordTextbox.sendKeys("");

		// By: id/class/name/xpath/css

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
