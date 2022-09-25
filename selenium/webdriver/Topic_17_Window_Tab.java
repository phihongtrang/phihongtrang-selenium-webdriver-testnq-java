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
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Vừa mở ra nó chỉ có duy nhất 1 tab
		String fromTabID = driver.getWindowHandle();
		System.out.println("From tab ID = " + fromTabID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(3);
		
		// Lúc này nó đã có 2 tab rồi
		Set<String> allWindownIDs = driver.getWindowHandles();
		System.out.println("From tab ID = " + allWindownIDs);
		
		// Dùng vòng lặp để duyệt qua từng ID đang có trong Set
		for (String id : allWindownIDs) {
			if (!id.equals(fromTabID)) {
				driver.switchTo().window(id);		
			}
			
		}
		
		
		
	}

	@Test
	public void TC_02_() {

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
