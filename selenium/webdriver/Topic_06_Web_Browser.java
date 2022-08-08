package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void TC_06_Method() {
		// Dùng để close browser/ tab
		// Nếu như chỉ có 1 tab: close browser
		// Nếu như nhiều hơn 1 tab: close tab đang active
		driver.close();
		
		// Dùng để đóng Browser luôn
		// Không quan tâm có bao nhiêu tab
		driver.quit();

		//Mở 1 Url ra
		driver.get("https://www.facebook.com/");
		
		// *************** Wait **********************
		// Dùng để tìm 1 element
		driver.findElement(By.xpath(""));
		
		// Dùng để tìm nhiều element
		driver.findElements(By.xpath(""));
		
		// Lấy ra Url của page hiện tại
		driver.getCurrentUrl();
		
		// Lấy ra Source Code (HTML/ CSS/ JS) của page hiện tại
		driver.getPageSource();
		
		// Lấy ra Tittle của page hiện tại
		driver.getTitle();
		
		// *************** Window/ Tab **********************
		// Dùng để xử lý window/tab
		// Lấy ra ID của window/tab đang active
		driver.getWindowHandle();
		
		// Lấy ra ID của tất cả các window/ tab đang có
		driver.getWindowHandles();
		
		// *************** Framework - Cookie **********************
		// Cookie: Lưu lại phiên đăng nhập/ session/ dữ liệu duyệt web/...
		driver.manage().deleteAllCookies();
		
		// *************** Framework - Log **********************
		//driver.manage().log().get(Log);
		
		// Chờ cho findElement/ findElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Chờ cho 1 page load thành công
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		// *************** Javascript Executor **********************
		// Chờ cho 1 đoạn code Javascript được thực thi thành công
		// asynchronous script - bất đồng bộ
		// synchronous script - đồng bộ
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		// Full hết toàn màn hình
		driver.manage().window().fullscreen();
		
		// Mở rộng hết cửa sổ
		driver.manage().window().maximize();
		
		// Set vị trí của brower so với độ phân giải màn hình (Resolution)
		driver.manage().window().setPosition(new Point(100,250));
		driver.manage().window().getPosition();
		
		// Mở brower với cái kích thước là bao nhiêu
		// Test Responsive
		driver.manage().window().setSize(new Dimension(1920, 10800));
		driver.manage().window().getSize();
		
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://www.facebook.com/");
		driver.get("https://www.facebook.com/");
		
		//****************Alert****************
		driver.switchTo().alert();
		
		//****************Frame/ Iframe****************
		driver.switchTo().frame(0);
		
		//****************Window/ Tab****************
		driver.switchTo().window("");
		
	

	}

	@Test
	public void TC_02_() {
		
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
