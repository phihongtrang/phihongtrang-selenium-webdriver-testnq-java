package javaTester;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {
	public static void main(String[] args) {
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
		boolean status = true; // Nam
		status = false; // Nữ
		// Kí tự: char
		char a = 'A';
		
		// II. Kiểu dữ liệu tham chiếu ( Reference)
		// Class
		FirefoxDriver driver = new FirefoxDriver();
		
		// Interface
		WebElement firstNametextbox;
	
		// String
		String firstName = "Automation testing";
		
		// Object
		Object people;
		
		// Array
		String[] studentName = {"Nguyexn Van A", "Le Van B", "Nguyen Thi Loan"};
		
		// Collection: List/ Set/ Queue
	}
}
