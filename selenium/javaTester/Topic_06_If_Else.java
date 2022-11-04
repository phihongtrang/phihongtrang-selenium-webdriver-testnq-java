package javaTester;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_If_Else {

	@Test
	public void BT_01() {

		System.out.println("Name:");
		Scanner scName = new Scanner(System.in);
		String Name = scName.next();

		System.out.println("Age:");
		Scanner scAge = new Scanner(System.in);
		int Age = scAge.nextInt();

		int n = 15;

		System.out.println("After 15 years, age of " + Name + " will be " + (Age + n));
	}

	@Test
	public void BT_02() {
		System.out.println("Nhập số nguyên từ bàn phím");
		Scanner scN = new Scanner(System.in);
		int n = scN.nextInt();

		if (n % 2 == 0) {
			System.out.println("Số " + n + " là số chẵn");

		} else {
			System.out.println("Số " + n + " là số lẻ");

		}
	}

	@Test
	public void BT_03() {
		System.out.println("Nhập số nguyên a từ bàn phím");
		Scanner scA = new Scanner(System.in);
		int a = scA.nextInt();

		System.out.println("Nhập số nguyên b từ bàn phím");
		Scanner scB = new Scanner(System.in);
		int b = scA.nextInt();

		if (a > b) {
			System.out.println(a + " lớn hơn " + b);

		} else if (a == b) {
			System.out.println(a + " bằng " + b);
		} else {
			System.out.println(a + " nhỏ hơn " + b);
		}
	}

	@Test
	public void BT_04() {
		System.out.println("Nhập tên học sinh 1");
		Scanner sc1 = new Scanner(System.in);
		String firstStudent = sc1.nextLine();

		System.out.println("Nhập tên học sinh 2");
		Scanner sc2 = new Scanner(System.in);
		String secondStudent = sc2.nextLine();
		
		if (firstStudent.equals(secondStudent)) { System.out.println("Hai học sinh giống tên nhau");
			
		} else { System.out.println("Hai học sinh khác tên nhau");
			
		}	
	}
	
	@Test
	public void BT_05() {
		System.out.println("Nhập số nguyên a từ bàn phím");
		Scanner scA = new Scanner(System.in);
		int a = scA.nextInt();
		
		System.out.println("Nhập số nguyên b từ bàn phím");
		Scanner scB = new Scanner(System.in);
		int b = scB.nextInt();
		
		System.out.println("Nhập số nguyên c từ bàn phím");
		Scanner scC = new Scanner(System.in);
		int c = scC.nextInt();
		
		if (a>b && a>c ) { System.out.println("Số " + a + " lớn nhất");
			
		} else if (b>a && b>c ) { System.out.println("Số " + b + " lớn nhất");

		} else { System.out.println("Số " + c + " lớn nhất");
			
		}	
	}
	
	@Test
	public void BT_06() {
		System.out.println("Nhập số nguyên a từ bàn phím");
		Scanner scA = new Scanner(System.in);
		int a = scA.nextInt();
		
		if (10<a && a<100) { System.out.println("Số " + a + " nằm trong [10,100]");
			
		} else { System.out.println("Số " + a + " không nằm trong [10,100]");
		
		}

		}
		
	@Test
	public void BT_07() {
		System.out.println("Nhập điểm của sinh viên");
		Scanner scN = new Scanner(System.in);
		float n = scN.nextFloat();	
			
		if (n>=8.5 && n<=10) { System.out.println("Điểm A");
			
		} else if (n>=7.5 && n<8.5) { System.out.println("Điểm B");
		
		} else if (n>=6 && n<7.5) { System.out.println("Điểm C");
		
		} else if (n>0 && n<6) { System.out.println("Điểm D");
		
		} else { System.out.println("Bạn vui lòng nhập điểm hợp lệ");
		}		
	}	
	
	@Test
	public void BT_08() {
		System.out.println("Nhập tháng");
		Scanner scN = new Scanner(System.in);
		int n = scN.nextInt();	
		
		if (n==1 || n==3 || n==5 || n==7 || n==8 || n==10 || n==12) { System.out.println("Tháng " + n + " có 31 ngày");
			
		} else if (n==2){ System.out.println("Tháng " + n + " có 28 ngày");

		} else if (n==4 || n==6 || n==9 || n==11){ System.out.println("Tháng " + n + " có 30 ngày");
		
		} else { System.out.println("Bạn vui lòng nhập tháng hợp lệ");
		}
	}
	
	
	
}		
		
		
		
		
		
		
		
		
		
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

