package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Button_Radio_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		By loginButtonBy = By.cssSelector("button.fhs-btn-login");
		Assert.assertTrue(driver.findElement(loginButtonBy).isDisplayed());
		
		driver.findElement(By.id("login_username")).sendKeys("TrangPhi@gmail.net");
		driver.findElement(By.id("login_password")).sendKeys("123456");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(loginButtonBy).isEnabled());
		
		String loginButtonBackgroundHexa = Color.fromString(driver.findElement(loginButtonBy).getCssValue("background-color")).asHex().toUpperCase();
		Assert.assertEquals(loginButtonBackgroundHexa, "#C92127");
		
		System.out.println(driver.findElement(loginButtonBy).getCssValue("background-color"));
		System.out.println(Color.fromString(driver.findElement(loginButtonBy).getCssValue("background-color")));
		System.out.println(Color.fromString(driver.findElement(loginButtonBy).getCssValue("background-color")).asHex());
		System.out.println(Color.fromString(driver.findElement(loginButtonBy).getCssValue("background-color")).asHex().toUpperCase());
	}

	@Test
	public void TC_02_Default_Radio_Checkbox() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		driver.findElement(By.cssSelector("input#eq5")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("input#eq5")).isSelected());
		
		driver.findElement(By.cssSelector("input#eq5")).click();
		sleepInSecond(3);
		Assert.assertFalse(driver.findElement(By.cssSelector("input#eq5")).isSelected());
		
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		driver.findElement(By.cssSelector("input#engine3")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("input#engine3")).isSelected());
		if (!driver.findElement(By.cssSelector("input#engine3")).isSelected()) {
			driver.findElement(By.cssSelector("input#engine3")).click();
			sleepInSecond(3);
			
		}
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input#engine3")).isSelected());
		
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
