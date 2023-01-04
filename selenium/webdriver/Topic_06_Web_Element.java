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
	/*
	public void TC_01_WebElement() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		// Tương tác được với Element thì cần tìm được element đó
		// Thông qua các locator của nó
		//Khi element dùng nhiều lần khai báo biến
		WebElement emailTextbox = driver.findElement(By.id("Email"));
		emailTextbox.isDisplayed();
		emailTextbox.clear(); 
		emailTextbox.sendKeys("ngocthaonguyen2902@gmail.com");
		WebElement passwordTextbox = driver.findElement(By.id("Password"));

		passwordTextbox.sendKeys("thảo nè");
		
		//khi dùng 1 lần
//		driver.findElement(By.id("Email")).sendKeys("ngocthaonguyen2902@gmail.com");
		
		// By: id/class/name/xpath/css

	}*/
	public void TC_02_WebElement() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		WebElement element =driver.findElement(By.id("Email"));
		element.clear();
		driver.findElement(By.id("Email")).sendKeys("ngocthaonguyen2902@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		// hoặc dùng cách này để khai báo biến nếu dùng nhiều lần nhe
		//WebElement element=driver.findElement(By.className("password"));

		//Dùng cho các textbox/ textarea/ dropdown (Editable)
		//Xóa dữ liệu trước khi nhập text
		//element.clear();
		//Nhập liệu
		//element.sendKeys("ngọc Thảo xinh đẹp");
		
		
		// Click vào các button/ link/ checkbox/ radio/ image
		//element.click();
		// hoặc dùng cách này để click nếu chưa khai báo biến
		
		WebElement elementbutton= driver.findElement(By.className("button-1 login-button"));
		elementbutton.click();

		
		//search element
		 driver.findElement(By.cssSelector("div.header-links a.ico-login")).click();
	
		String searchAtribute= element.getAttribute("placeholder");
		String emailTextboxAttributr= element.getAttribute("value");

		//Search store
		
		//GUI: font/size/color/ location
		element.getCssValue("background-color");
		//#248ece tese
		
		//vị trí của element so vs web
		element.getLocation(); 
		
		//kích thước của element (bên trong) 
		element.getSize(); 
		
		//location + size
		element.getRect();
		
		//Cần lấy  ra cái tên thẻ HTML của element đó => truyền vào cho 1 locator khác 
		driver.findElement(By.id("Email")).getTagName();
		//lấy tag name khi biết name của element
		driver.findElement(By.name("Email")).getTagName();
		
		//Lấy tag name từ css để gắng vào giá trị khác
		String emailTextboTagName = driver.findElement(By.cssSelector("#Email")).getTagName(); 
		driver.findElement(By.xpath("//"+emailTextboTagName+"[@id='email']"));
		
		//Lấy text từ Error message / success message/label/header/..
		element.getText(); 
		//Please enter your email 
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
