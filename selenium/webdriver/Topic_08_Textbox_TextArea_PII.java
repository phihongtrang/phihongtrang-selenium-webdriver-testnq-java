package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Textbox_TextArea_PII {
	WebDriver driver;
	String EmployeeID, FirstName, LastName;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		FirstName = "Trang";
		LastName = "Phi";
	}

	@Test
	public void TC_01_Login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		
	}

	@Test
	public void TC_02_Open_Add_Employee() {
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys(FirstName);
		driver.findElement(By.name("lastName")).sendKeys(LastName);
		
		sleepInSecond(8);
		driver.findElement(By.xpath("//div[@class='oxd-form-actions']/button[@type='submit']")).click();

		sleepInSecond(8);
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), FirstName);
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), LastName);
		
		
		
		
	}

	@Test
	public void TC_03_() {
		
	}  
	
	@Test
	public void TC_04_() {
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
