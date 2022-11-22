package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_System {
	public static void main(String[] args) {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String osName = System.getProperty("os.Name");
		
		System.out.println(projectPath);
		System.out.println(osName);
		
		@BeforeClass
		public void BeforeClass() {
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
				
			} else {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			}
		}
		
			
			driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
	}

}
