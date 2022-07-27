package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_By {
	// -Bước 1: Mở Browser lên
	// -Bước 2: Nhập vào URL
	// -Bước 3: Click vào My Acount để mở trang Login ra
	// -Bước 5: Verify lỗi hiển thị
	// -Bước 6: Đóng Browser
	
	// Khai báo 1 biến để đại diện cho thư viện Selenium WebDriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		// -Bước 1: Mở Browser lên
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//Bấm cho maximize Browser lên
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_() {
		// -Bước 2: Nhập vào URL
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");	
		
		// -Bước 3: Click vào My Acount để mở trang Login ra
		
		// HTML của element (Email Textbox)
//		 <input type="email" autocapitalize="zone"
//				autocapitalize="off" 
//				autocorrect="off" spellcheck="false" 
//				name="login[username]" value="" 
//				id="email" class="input-text required-entry validate-email" 
//				title="Email Address">
		
		//input - thẻ của element này (tagname)
		// attribute - type autocapitalize autocorrect spellcheck name value id class title
		// attribute value - email off off false ...
		// Tìm 1 element
		
		//Xpath Format:
		//tagname[@atribute-name='attribute-value']
		//input[@type='email'] ->*
		//input[@name='login[username]'] ->*
		//input[@title='Email Address'] ->*
		
		//CSS Format:     tagname[atribute-name='attribute-value']
	
		// ID
		driver.findElement(By.id("email"));
		
		// Class - New User Form
		// 1 - Giá trị ko chứa khoảng trắng -> Lấy hết
		// 1 - Giá trị chứa khoảng trắng -> Lấy 1 phần
		
		// Cách gõ code ít bị lỗi:
		// Ko được dư kí tự ( )
		// Thiếu kí tự: ;
		// Ctrl Space
		
		driver.findElement(By.className("new-users")); 
		
		// Ko bị lỗi cú pháp
		// Code đúng
		// Code tối ưu sau
		
		// Name - Email Textbox
		driver.findElement(By.name("login[username]"));
		
		// Tagname - Tìm xem có bao nhiêu element trên 1 màn hình
		driver.findElement(By.tagName("a"));
		
		// LinkText (Link) - Text tuyệt đối
		driver.findElement(By.linkText("SEARCH TERMS"));
		
		// Partial LinkText (Link) - Text tương đối/ tuyệt đối
		driver.findElement(By.partialLinkText("SEARCH TERMS"));
		driver.findElement(By.partialLinkText("CH TER"));
		driver.findElement(By.partialLinkText("SEARCH"));
		driver.findElement(By.partialLinkText("TERMS"));
		
		// CSS - Cover được hết cả 6 loại trên
		driver.findElement(By.xpath("input[name='login[username]']"));
		driver.findElement(By.xpath("input[type='email']"));
		driver.findElement(By.xpath("input[title='Email Address']"));

		
		// XPath
		driver.findElement(By.xpath("//input[@name='login[username]']"));
		driver.findElement(By.xpath("//input[@type='email']"));
		driver.findElement(By.xpath("//input[@title='Email Address']"));

		
		
		// Tìm nhiều element
		// drive.findElements
	}

	@Test
	public void TC_02_() {
		
	}



	@AfterClass
	public void afterClass() {
		// -Bước 6: Đóng Browser
		driver.quit();
	}
}
