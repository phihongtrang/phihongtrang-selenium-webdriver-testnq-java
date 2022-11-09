package javaBasic;

import java.util.Scanner;

public class BT_2 {
	public static void main(String[] agrs) {
		int n;
		int Fi;

		System.out.println("Nhập số nguyên n nhỏ hơn hoặc bằng 20");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		BT_2 Fibonacci = new BT_2();

		if (n <= 20) {
			Fi = Fibonacci.CalculateFi(n);
			System.out.println("Số Fibonacci của " + n + " là " + Fi);

		} else {
			System.out.println("Không hợp lệ");

		}

	}

	public int CalculateFi(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		return CalculateFi(n - 1) + CalculateFi(n - 2);

	}

}
