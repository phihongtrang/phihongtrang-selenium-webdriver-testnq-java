package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Part_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public void sleepSecond(long timeSleep) {
		try {
			Thread.sleep(timeSleep*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Register_01_Empty_Data() {
		
		// Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify (Actual data = Expected data)
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
		
		
	}

	@Test
	public void TC_02_Register_02_Invalid_Email() {
		
		// Action
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				driver.findElement(By.id("txtFirstname")).sendKeys("Trang Phi");
				driver.findElement(By.id("txtEmail")).sendKeys("TrangPhi@1996@");
				driver.findElement(By.id("txtCEmail")).sendKeys("TrangPhi@1996@");
				driver.findElement(By.id("txtPassword")).sendKeys("123456");
				driver.findElement(By.id("txtCPassword")).sendKeys("123456");
				driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify (Actual data = Expected data)
				Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
				Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
			
			
				
		
	}
	
	@Test
	public void TC_03_Register_03_Incorrect_Email() {
		
		// Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Trang Phi");
		driver.findElement(By.id("txtEmail")).sendKeys("TrangPhi@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("TrangPhi@1996@");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify (Actual data = Expected data)
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
		
		
	}

	@Test
	public void TC_04_Register_04_Password_Less_Than_6_Chars() {
		
		// Action
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				driver.findElement(By.id("txtFirstname")).sendKeys("Trang Phi");
				driver.findElement(By.id("txtEmail")).sendKeys("TrangPhi@gmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("TrangPhi@1996@");
				driver.findElement(By.id("txtPassword")).sendKeys("1234");
				driver.findElement(By.id("txtCPassword")).sendKeys("1234");
				driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify (Actual data = Expected data)
				
				Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
				Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
	
		
	}
	@Test
	public void TC_05_Register_05_Incorrect_Confirm_Password() {
		
		// Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Trang Phi");
		driver.findElement(By.id("txtEmail")).sendKeys("TrangPhi@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("TrangPhi@1996@");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("124356");
		driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify (Actual data = Expected data)
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
		
		
		
	}
	
	@Test
	public void TC_06_Register_06_Invalid_Phone_Number() {
		
		// Action
				driver.get("https://alada.vn/tai-khoan/dang-ky.html");
				driver.findElement(By.id("txtFirstname")).sendKeys("Trang Phi");
				driver.findElement(By.id("txtEmail")).sendKeys("TrangPhi@gmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("TrangPhi@1996@");
				driver.findElement(By.id("txtPassword")).sendKeys("123456");
				driver.findElement(By.id("txtCPassword")).sendKeys("124566");
				
				// <10 chars
				driver.findElement(By.id("txtPhone")).sendKeys("012345");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify (Actual data = Expected data)
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
				
				// >10 chars
				driver.findElement(By.id("txtPhone")).clear();
				driver.findElement(By.id("txtPhone")).sendKeys("012345678910");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify (Actual data = Expected data)
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
				
				// >10 chars
				driver.findElement(By.id("txtPhone")).clear();
				driver.findElement(By.id("txtPhone")).sendKeys("12345678910");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				// Verify (Actual data = Expected data)
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
				
	
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
