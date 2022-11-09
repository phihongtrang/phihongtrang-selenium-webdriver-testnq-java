package javaTester;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Switch_case {
	//@Test
	public void BT_01() {
		System.out.println("Nhập tháng");
		Scanner scN = new Scanner(System.in);
		int n = scN.nextInt();	
		
		switch (n) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + n + " có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng " + n + " có 28 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng " + n + " có 30 ngày");

		default:
			break;
		}
		
		
	}
	
	//@Test
	public void BT_02() {
		System.out.println("Nhập số");
		Scanner scN = new Scanner(System.in);
		int n = scN.nextInt();	
		
		switch (n) {
		case 1:System.out.println("One");
		break;
		case 2:System.out.println("Two");
		break;
		case 3:System.out.println("Three");
		break;
		case 4:System.out.println("Four");
		break;
		case 5:System.out.println("Five");
		break;
		case 6:System.out.println("Six");
		break;
		case 7:System.out.println("Seven");
		break;
		case 8:System.out.println("Eight");
		break;
		case 9:System.out.println("Nine");
		break;
		case 10:System.out.println("Ten");
		break;

		default:
			break;
		}
	}
	class ViDuVongLapForEach {
		@Test
		public void BT_03() {

	        char[] mangKyTu = {'t', 'u', 'h', 'o', 'c'};
	        
	        // Vòng lặp for each
	        for (char kytu: mangKyTu) {
	            System.out.println(kytu);
	        }
	    }
	}
	
}		
		
		
		
		
		
		
		
		
		
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

