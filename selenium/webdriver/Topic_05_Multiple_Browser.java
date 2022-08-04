package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Multiple_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@Test
	public void TC_01_Chorme() {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.quit();
	}

	@Test
	public void TC_02_FireFox() {
		// Setting OS hiểu được geckodriver => Giao tiếp với Browser
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.quit();
	}

	@Test
	public void TC_03_Edge_Chromium() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.quit();
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
