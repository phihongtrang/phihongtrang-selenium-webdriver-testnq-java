package javaBasic;

import java.util.Scanner;

public class BT_1 {
	public static void main(String[] args) {
		int n;
		boolean soNguyenTo ;
		System.out.println("Nhập vào số nguyên:");
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		if (n == 1 || n == 2) {
			System.out.println(n + " là số nguyên tố");
		}
		soNguyenTo = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				soNguyenTo = false;
			}
		}
		if (soNguyenTo == false) {
			System.out.println(n + " không là số nguyên tố");

		} else {
			System.out.println(n + " là số nguyên tố");

		}
	}
}
