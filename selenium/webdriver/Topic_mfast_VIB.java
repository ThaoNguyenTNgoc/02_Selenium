package webdriver;
//import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_mfast_VIB {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
//		boolean booleanResult;
	}
	
	@Test 
	public void TC_01_WebElement_cashback() {
		driver.get("https://bsh-rc.mfast.vn/vib_2in1?type=cashback&code=039596&oto=1");
		// Tương tác được với Element thì cần tìm được element đó
		// Thông qua các locator của nó

		// 2. Type 'Nguyễn Thị Ngọc Thảo @' in 'fullName'
	    // set step-specific timeout (will undo this at the end)
	    driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
//	    GeneratedUtils.sleep(500);
	    WebElement name= driver.findElement(By.cssSelector("#name"));
	    name.sendKeys("Nguyễn Thị Ngọc Thảo @");
	    driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
	    WebElement idnumber= driver.findElement(By.name("idNumber")); 
	    idnumber.sendKeys("123456789");
	    WebElement phone= driver.findElement(By.name("phoneNumber")); 
	    phone.sendKeys("0948339596");
	    WebElement submit= driver.findElement(By.xpath("//input[@type='submit']")); 
	    submit.click();
	    WebElement content= driver.findElement(By.xpath("//div/p[@class='txt_r_l spa_l mb-2']"));
	    content.getText().contains("Đăng ký thẻ tín dụng VIB Financial Free");
//	    String text="Đăng ký thẻ tín dụng VIB Financial Free";
//	    assert.conta(content,text);
//	    Assertions.assertTrue(content.getText().contains("Đăng ký thẻ tín dụng VIB Financial Free"));
	}
	@Test
	public void TC_02_WebElement_cashback() {
		
		driver.get("https://bsh-rc.mfast.vn/vib_2in1?type=cashback&code=039596&oto=1");
		// Tương tác được với Element thì cần tìm được element đó
		// Thông qua các locator của nó

		// 2. Type '1112' in 'fullName'
	    // set step-specific timeout (will undo this at the end)
	    driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
//	    GeneratedUtils.sleep(500);
	    WebElement name= driver.findElement(By.cssSelector("#name"));
	    name.sendKeys("1112");
	    driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
	    WebElement idnumber= driver.findElement(By.name("idNumber")); 
	    idnumber.sendKeys("123456789");
	    WebElement phone= driver.findElement(By.name("phoneNumber")); 
	    phone.sendKeys("09483");
	    WebElement textphone= driver.findElement(By.xpath("//div/div/div[@class='frm_group float_label ml10 mfast-input-error']/p[1]"));
	    textphone.getText().concat("Thảo đẹp gái");
	    WebElement submit= driver.findElement(By.xpath("//input[@type='submit']")); 
	    submit.click();
	    WebElement content= driver.findElement(By.xpath("//div/p[@class='txt_r_l spa_l mb-2']"));
	    content.getText().contains("Đăng ký thẻ tín dụng VIB Financial Free");
//	    String text="Đăng ký thẻ tín dụng VIB Financial Free";
//	    assert.conta(content,text);
//	    Assertions.assertTrue(content.getText().contains("Đăng ký thẻ tín dụng VIB Financial Free"));
	}


	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
