package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_26_FluentWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expicitWait;
	JavascriptException jsExcutor;
	FluentWait<WebDriver> fluentDriver;

	long allTime = 15; // Second
	long pollingTime = 100; // Milisecond

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_() {
		driver.get("https://automationfc.github.io/dynamic-loading/");

		// Dùng FluentWait
		fluentDriver = new FluentWait<WebDriver>(driver);

		// Set tổng thời gian và tần số
		fluentDriver.withTimeout(Duration.ofSeconds(15))
				// 1/3 giây check 1 lần
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		// Apply điều kiện
		WebElement startButton = fluentDriver.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("div#start>button"));
			}
		});

		startButton.click();

	}

	public WebElement findElement(String xpathLocator) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		fluentDriver.withTimeout(Duration.ofSeconds(allTime)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		return fluentDriver.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpathLocator));
			}
		});
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
