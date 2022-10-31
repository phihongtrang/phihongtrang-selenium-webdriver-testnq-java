package javaTester;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type_PI {
	// Global variable
	
	// I.  Kiểu dữ liệu nguyên thủy (Primitive)
	
			// Số nguyên: byte short int long ( k có phần thập phân)
			// Kích thước/ độ rộng để lưu trữ dữ liệu từ nhỏ đến lớn
			byte bNumber = 126;
			
			short sNumber= 32000;
			
			int iNumber = 4996512;
			
			long lNumber = 54846;
			
			// Số thực: float double ( có phần thập phân)
			float studentPoint = 9.5f;
			
			double employeeSalary = 35.6d;
			
			// Logic: boolean 
			boolean status = true; 
			
			// Kí tự: char
			char a = 'A';
			
			// II. Kiểu dữ liệu tham chiếu ( Reference)
			
			// String
			String address = "Ho Chi Minh";
			
			// Array
			String[] studentAddress = {address, "Ha Noi", "Da Nang"};
			
			// Class
			FirefoxDriver driver = new FirefoxDriver();
			
			// Interface
			WebElement firstNametextbox;
			
			// Object
			Object people;
			
			// Collection: List/ Set/ Queue/ Map
			List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
			Set<String> allWindows = driver.getWindowHandles();
			
	
	public static void main(String[] args) {
		
	}
}
