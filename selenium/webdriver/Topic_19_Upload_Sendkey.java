package webdriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_Sendkey {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Image name
	String laptop = "Laptop.jpg";
	String love = "Love.jpg";
	String meal = "Meal.jpg";

	// Upload file folder
	String uploadFileFolderPath = projectPath + File.separator + "uploadFiles" + File.separator;

	// Image path
	String laptopFilePath = uploadFileFolderPath + laptop;
	String loveFilePath = uploadFileFolderPath + love;
	String mealFilePath = uploadFileFolderPath + meal;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Upload_One_File_Per_Time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");

		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(laptopFilePath);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(loveFilePath);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(mealFilePath);

		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Laptop.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Love.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Meal.jpg']")).isDisplayed());

		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Laptop.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Love.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Meal.jpg']")).isDisplayed());

		}

	

	@Test
	public void TC_02_Upload_Multiple_File_Time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");

		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(laptopFilePath + "/n" + loveFilePath + "/n" + mealFilePath);

		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Laptop.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Love.jpg']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()= 'Meal.jpg']")).isDisplayed());

		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}

			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Laptop.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Love.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()= 'Meal.jpg']")).isDisplayed());

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
