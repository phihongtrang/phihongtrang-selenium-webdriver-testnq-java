 package webdriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Window_Tab {
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
	public void TC_01_Bassic_Form() {
		
		// Driver đang ở trang A
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Lấy ra ID của driver đang đứng tại tab/ window (active)
		String fromTabID = driver.getWindowHandle();
		System.out.println("From tab ID = " + fromTabID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(3);
		
		// Switch qua trang B
		switchToWindowByID(fromTabID);
		
		// Driver đang ở trang B
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String googleTabID = driver.getWindowHandle();
		
		// Quay về trang A
		switchToWindowByID(googleTabID);
		
		// Driver đang ở trang A
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		
		
		
		
		
		
		
	}

	// Chỉ dùng cho duy nhất 2 tab/ windown
	public void switchToWindowByID(String parentID) {
		// Lấy ra tất cả các ID của tab/ window đang có
		Set<String> allWindownIDs = driver.getWindowHandles();
		
		// Dùng vòng lặp để duyệt qua từng ID
		for (String id : allWindownIDs) {
			
			// Nếu như có ID nào mà khác với parentID
			if (!id.equals(parentID)) {
				
				// Switch vào
				driver.switchTo().window(id);
				sleepInSecond(3);
				
			}
		}

	}
	
	// Dùng được cho 2 hoặc nhiều hơn 2 tab/ window
	public void switchToWindowByTitle(String expectedPageTitle) {
		// Lấy ra tất cả các ID của tab/ window đang có
		Set<String> allWindownIDs = driver.getWindowHandles();
		
		// Dùng vòng lặp để duyệt qua từng ID
				for (String id : allWindownIDs) {
					// Switch vào từng tab/window
					driver.switchTo().window(id);
		// Lấy ra Title của page đã switch vào
		String currentPageTitle = driver.getTitle();
		
		if (currentPageTitle.equals(expectedPageTitle)) {
		// Thoát khỏi vòng lặp - ko duyệt nữa
			break;
			
		}
		
					
					
		
				}

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