package webdriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Frame_Iframe {
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
	public void TC_01_Iframe() {
		driver.get("https://kyna.vn/");

		// A -> B
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));

		// B (Element thuộc B)
		String facebookLikeNumber = driver
				.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();

		Assert.assertEquals(facebookLikeNumber, "166K likes");

		// B -> A (Element thuộc A)
		driver.switchTo().defaultContent();

		// A -> C
		driver.switchTo().frame("cs_chat_iframe");

		// C (Element thuộc C)
		driver.findElement(By.cssSelector("div.meshim_widget_Widget")).click();
		sleepInSecond(3);

		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Trang");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0123456789");
		new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Course");

		// C -> A
		driver.switchTo().defaultContent();

		String keyword = "Excel";

		// A (Element thuộc A)
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys(keyword);
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(3);

		// Verify
		List<WebElement> courseNames = driver.findElements(By.cssSelector("div.content>h4"));

		// Number
		Assert.assertEquals(courseNames.size(), 9);

		for (WebElement course : courseNames) {
			Assert.assertTrue(course.getText().contains(keyword));

		}

	}

	@Test
	public void TC_02_Fame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		
		driver.findElement(By.cssSelector("input.form-control")).sendKeys("Trangphi");
		driver.findElement(By.cssSelector("a.login-btn")).click();
		sleepInSecond(3);
		
		WebElement passwordTextbox = driver.findElement(By.id("fldPasswordDispId"));
		
		Assert.assertTrue(passwordTextbox.isDisplayed());
		
		passwordTextbox.sendKeys("Trangphi96");
		sleepInSecond(3);
		

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
