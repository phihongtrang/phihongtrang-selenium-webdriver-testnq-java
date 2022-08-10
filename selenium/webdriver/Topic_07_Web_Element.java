package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");

	}

	@Test
	public void TC_01_Define_Element() {
		// Muốn thao tác được với Element thì  mình phải tìm element trước
		// Sau đó mới áp dụng hành vi vào cho Element đó
		
		// 1 - Tìm Element
		// 2 - Với loại locator gì
		// 3 - Tương tác lên/ Kiểm tra nó
		
		// Muốn thao tác trực tiếp lên element thì không cần khai báo biến
		driver.findElement(By.id("send2")).click();
		
		// Thao tác từ 2 lần trở lên thì cần khai báo biến tránh việc lặp lại
		
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		emailTextbox.isDisplayed();
	}

	@Test
	public void TC_02_Element_Method() {
		WebElement element = driver.findElement(By.id(""));
		
		// Xóa dữ liệu trong những field cho phép nhập
		// Luôn luôn clear hết dữ liệu trước khi thao tác lên field đó
		// Textbox/ TextArea/ Editable Dropdown
		element.clear();
		 
		// Nhập dữ liệu trong những field cho phép nhập
		element.sendKeys("");
		element.sendKeys(Keys.ENTER);
		
		// Element cha: findElement(By.className("footer"))
		// Element tiếp theo của con: findElement(By.cssSelector("a[tittle='My account']"))
		element.findElement(By.className("footer")).findElement(By.cssSelector("a[tittle='My account']"));
		
		// Không khai báo biến = Verify trực tiếp
		Assert.assertEquals(driver.findElement(By.id("search")).getAttribute("placeholder"), "Search entire store here...");
		
		// Khai báo biến dùng nhiều lần
		String searchTextboxPlaceholderValue = driver.findElement(By.id("search")).getAttribute("placeholder");
		Assert.assertEquals(searchTextboxPlaceholderValue, "Search entire store here..." );
		
		// GUI: Font/ Size/ Color/ Pixel/...
		element.getCssValue("background-color");
		// rgb(149, 246,6)
		element.getCssValue("font-size");
		// 13px
		
		// GUI: Position/ Location/ Size of element
		element.getLocation();
		element.getRect();
		element.getSize();
		
		// Framework: Attach screenshot to Report HTML
		element.getScreenshotAs(OutputType.FILE);
		
		element = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']"));
		element = driver.findElement(By.cssSelector("div[id='advice-validate-email-email']"));
		
		element = driver.findElement(By.cssSelector("#advice-validate-email-email"));
		String emailTextboxTagname = element.getTagName();
		// Output của element này sẽ là 1 input của element khác
		
		// Truyền 1 biến vào trong 1 chuỗi
	
		driver.findElement(By.xpath("//" + emailTextboxTagname + "[@id='advice-validate-password']"));
		
		// Chuỗi thứ 1 + biến + chuỗi thứ 2 
		
		// Lấy ra Text của element hiện tại
		// 
		element.getText();
		
		// Mong muốn 1 element hiển thị / không hiển thị
		// Hiển thị: Người dùng nhìn thấy được/ có kích thước cụ thể (chiều rộng/ cao)
		// Áp dụng cho tất cả các loại element: textbox/ text area/ dropdown/ checkbox/ radio/ button...
		element.isDisplayed();
		
		// Mong muốn 1 element có thể thao tác được lên hoặc không
		// Ngược lại với disable
		// Thao tác được: Enable
		// Không thao tác đươc: Disable
		// Áp dụng cho tất cả các loại element: textbox/ text area/ dropdown/ checkbox/ radio/ button...
		element.isEnabled();
		
		// Mong muốn 1 element đã được chọn hay chưa
		// Áp dụng cho 1 vài loại element: Checkbox/ Radio Button/ Dropdown (Default)
		element.isSelected();
		
		// Click vào 1 element
		// Button/ Linl/ Checkbox/ Radio/ Image/ Icon
		element.click();
		
		// Click lên Slider và giữ chuột
		// Sau đó kép Slider này 1 tọa độ bao nhiêu pixel
		// Kéo tới 1 element khác
		action.clickAndHold(element).moveToElement(element).perform();
		
	}
	

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
