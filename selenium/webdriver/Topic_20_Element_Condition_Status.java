package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_20_Element_Condition_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 15);
		
		

	}

	@Test
	public void TC_01_Visible_Displayes_Visibility() {
		driver.get("https://www.facebook.com/");
		
		// 1. Có trên IU (bắt buộc)
		// 2. Có trong HTML (bắt buộc)
		
		// Chờ cho email address textbox hiển thị trong vòng 15s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("AutomationFC");
		
	}

	@Test
	public void TC_02_Invisible_Undisplay_Invisibility_I() {
		// 1. Không có trên UI (bắt buộc)
		// 2. Có trong HTML
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		// Chờ cho Re-enter textbox không hiển thị trong vòng 15s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		

	}
	
	@Test
	public void TC_02_Invisible_Undisplay_Invisibility_II() {
		// 1. Không có trên UI (bắt buộc)
		// 2. Không có trong HTML
		driver.get("https://www.facebook.com/");
		
		// Chờ cho Re-enter textbox không hiển thị trong vòng 15s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
	}

	@Test
	public void TC_03_Presence_I() {
		driver.get("https://www.facebook.com/");
		
		// 1. Có ở trên UI
		// 2. Có ở trong cây HTML (bắt buộc)
		
		// Chờ cho email address textbox presence trong HTML trong vòng 15s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

	}

	@Test
	public void TC_03_Presence_II() {
		driver.get("https://www.facebook.com/");
		
		// 1. Có trong cây HTML (bắt buộc)
		// 2. Không có trên IU
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// Chờ cho Re-enter textbox không hiển thị trong vòng 15s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
		

	}

	@Test
	public void TC_04_Staleness() {
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// Phase 1: Element cos trong cây HTML
		WebElement reEnterEmailAddressTextbox = driver.findElement(By.name("reg_email_confirmation__"));
		
		// Thao tác với element khác làm cho element re-enter không còn trong DOM nữa
		
		
		// Close popup
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		// Chờ cho Re-enter Email  textbox không còn trong DOM trong vòng 10s
		explicitWait.until(ExpectedConditions.stalenessOf(reEnterEmailAddressTextbox));
		
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
