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
	
	By passWordText= By.cssSelector("#disable_password"); 
	By ageDisableRadio= By.cssSelector("#radio-disabled"); 
	By bioText= By.cssSelector("#bio"); 
	By job3Dropdown= By.cssSelector("#job3"); 
	By interestCheckboxDisable= By.cssSelector("#check-disbaled"); 
	By slider02=By.cssSelector("#slider-2");
	
	By email2Textbox = By.cssSelector("#email"); 
	By userNameTextbox=By.cssSelector("#new_username");
	By newPassword = By.cssSelector("#new_password");

	
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
		System.out.println("ageUnder18Radio is display"+"ageUnder18Radio");
		sleepInSecond(3);
		
	} else {
		System.out.println("ageUnder18Radio is not display"+"ageUnder18Radio");

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
			System.out.println("Element is disabled");

		}
	
//Ageunder18radio	
	
	if (driver.findElement(ageUnder18Radio).isEnabled()) {
		System.out.println("Element isEnabled"+"Ageunder18radio");
		
	} else {
		System.out.println("Element is disabled");

	}
	
//	educationTextbox
	if (driver.findElement(eduCationTextArea).isEnabled()) {
		System.out.println("Element isEnabled"+" eduCationTextArea");
		
	} else {
		System.out.println("Element is disabled"+"eduCationTextArea");

	}
	
//jobrole01/jobrole02
	if(driver.findElement(job1Dropdown).isEnabled()|| driver.findElement(job2Dropdown).isEnabled()) {
		if(driver.findElement(job1Dropdown).isEnabled()) {
		System.out.println("Element is Enabled"+" jobrole01");
		}
		if (driver.findElement(job2Dropdown).isEnabled()){
			System.out.println("Element is Enabled"+" jobrole02");
			sleepInSecond(3); }
				
	}
	else {
		System.out.println("Element is disabled" +"jobrole01&02");
		
	}
//	INterests check box 

	if (driver.findElement(interestCheckbox).isEnabled()) {
		System.out.println("Element is Enabled"+" interestCheckbox");
		
	} else {
		System.out.println("Element is disabled" + "interestCheckbox");
}
//	Slider 01 

	if (driver.findElement(slider01).isEnabled()) {
		System.out.println("Element isEnabled"+" slider01");
		
	} else {
		System.out.println("Element is disabled" + "slider01");
}
	
	if (driver.findElement(passWordText).isEnabled()) {
		
		System.out.println("Element isEnabled"+" Password");
	} else {
		System.out.println("Element is disabled"+" Password");

	}
	
	if (driver.findElement(ageDisableRadio).isEnabled()) {
		
		System.out.println("Element isEnabled"+" Age (Radiobutton is disabled)");
	} else {
		System.out.println("Element is disabled"+" Age (Radiobutton is disabled)");

	}
	
	if (driver.findElement(bioText).isEnabled()) {
		
		System.out.println("Element isEnabled"+" Biography");
	} else {
		System.out.println("Element is disabled"+" Biography");

	}
	if (driver.findElement(job3Dropdown).isEnabled()) {
		
		System.out.println("Element isEnabled"+" job Role 03");
	} else {
		System.out.println("Element is disabled"+" job Role 03");

	}
	
	if (driver.findElement(interestCheckboxDisable).isEnabled()) {
		
		System.out.println("Element isEnabled"+" interests (checkbox is disabled)");
	} else {
		System.out.println("Element is disabled"+" interests (checkbox is disabled)");

	}
	
	if (driver.findElement(slider02).isEnabled()) {
		
		System.out.println("Element isEnabled"+" Slide 02 (Disabled)");
	} else {
		System.out.println("Element is disabled"+" Slide 02 (Disabled)");

	}
	driver.quit();
	
	}
	@Test
	public void TC_03_isSelected(){
	driver.get("https://automationfc.github.io/basic-form/index.html");	
	
	driver.findElement(ageUnder18Radio).click();
	driver.findElement(By.cssSelector("#java")).click();
	
	if (driver.findElement(ageUnder18Radio).isSelected()) {
		System.out.println("Element is selected"+" ageUnder18Radio");
		sleepInSecond(1);
		
	} else {
		System.out.println("Element is not selected"+" ageUnder18Radio");

	}
	if (driver.findElement(By.cssSelector("#java")).isSelected()) {
		System.out.println("Element is selected"+" java");
		sleepInSecond(1);
		
	} else {
		System.out.println("Element is not selected"+" java");

	}
	driver.findElement(By.cssSelector("#java")).click();


	sleepInSecond(1);
	if (driver.findElement(By.cssSelector("#java")).isSelected()) {
		System.out.println("Element is selected"+" java");
		sleepInSecond(1);
		
	} else {
		System.out.println("Element is not selected"+" java");

	}
	
}
	
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(email2Textbox).sendKeys("ngocthaonguyen2902@gmail.com");
		By submit= By.id("create-account-enabled");
		
		
		driver.findElement(newPassword).sendKeys("abc");
//		driver.findElement(submit).click();
		sleepInSecond(1);
		
		//validate lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='8-char not-completed']")).isDisplayed());

		driver.findElement(newPassword).clear();
		driver.findElement(newPassword).sendKeys("ABC");
//		driver.findElement(submit).click();
		sleepInSecond(1);
		//validate uppercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(newPassword).clear();
		driver.findElement(newPassword).sendKeys("123");
//		driver.findElement(submit).click();
		sleepInSecond(1);
		//validate number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='8-char not-completed']")).isDisplayed());
		

		driver.findElement(newPassword).clear();
		driver.findElement(newPassword).sendKeys("@#");
//		driver.findElement(submit).click();
		sleepInSecond(1);
		//validate special
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='8-char not-completed']")).isDisplayed());


		driver.findElement(newPassword).clear();
		driver.findElement(newPassword).sendKeys("ngocthao");
//		driver.findElement(submit).click();
		sleepInSecond(1);
		//validate 8-char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div//li[@class='8-char completed']")).isDisplayed());
		

		driver.findElement(newPassword).clear();
		driver.findElement(newPassword).sendKeys("Th@o022996");
		driver.findElement(submit).click();
		sleepInSecond(3);
		//validate complete
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//div//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//div//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//div//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//div//li[@class='8-char completed']")).isDisplayed());

		
		
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
