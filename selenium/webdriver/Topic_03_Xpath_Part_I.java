package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void TC_01_() {
		driver.get("https://www.facebook.com/");
		
		// Locator code gọn hơn
		driver.findElement(By.xpath("//input[@id='Password']"));
		
		//Locator code xấu hơn - Khó đọc hơn
		driver.findElement(By.xpath("//*[@id=\"Pasword\"]"));
		
		// HTML Format
		/*<input class="text from-control"
		 * id="txtEmail" name="txtEmail"
		 * placeholder="Địa chỉ Email"
		 * type="email" value="">*/
		
		//input[@class='text from-control']
		//input[@id='txtEmail'] ->*
		//input[@name='txtEmail'] ->*
		//input[@placeholder='Địa chỉ Email']
		//input[@type='email']
		//input[@value='']
		
		// 1 - < hoăc <>
		// 2 - Tên thẻ (Tagname): input/ html/ head/ form/ label/ span/ p/...
		// 3 - Thuộc tính (Attribute name): class/ id/ name/ placeholder/ type/ value
		// 4 - Giá trị của thuộc tính ( Attribute value): text form-control/ txtEmail/ txtEmail..
		// 5 - > hoặc </> 
		
		// Xpath Format Basic
		// Absolute XPath: /html/ body/...
		// Relative XPath: //tagname[@attributename='attributevalue']
		// Relative XPath: //tagname[@attributename="attributevalue"]
		
		// CSS Format Basic
		//tagname[@attributename='attributevalue']
		//tagname[@attributename="attributevalue"]
	}

	@Test
	public void TC_02_() {
		
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
