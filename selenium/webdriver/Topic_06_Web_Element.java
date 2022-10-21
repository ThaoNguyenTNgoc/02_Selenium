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

public class Topic_06_Web_Element {

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
		//Khi element dùng nhiều lần khai báo biến
		WebElement emailTextbox = driver.findElement(By.id("Email"));
		emailTextbox.isDisplayed();
		emailTextbox.clear(); 
		emailTextbox.sendKeys("");
		WebElement passwordTextbox = driver.findElement(By.id("Password"));

		passwordTextbox.sendKeys("");
		
		//khi dùng 1 lần
		driver.findElement(By.id("Email")).sendKeys("");
		
		// By: id/class/name/xpath/css

	}
	public void TC_02_WebElement() {
		WebElement element=driver.findElement(By.className(""));
		//Dùng cho các textbox/ textarea/ dropdown (Editable)
		//Xóa dữ liệu trước khi nhập text
		element.clear();
		//Nhập liệu
		element.sendKeys("");
		
		//search element
		driver.findElement(By.cssSelector("div.header-links a.ico-login"));

		// Click vào các button/ link/ checkbox/ radio/ image
		element.click();
		
		String searchAtribute= element.getAttribute("placeholder");
		String emailTextboxAttributr= element.getAttribute("value");

		//Search store
		
		//GUI: font/size/color/ location
		element.getCssValue("background-color");
		//#248ece
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
