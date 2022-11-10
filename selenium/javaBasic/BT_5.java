package javaBasic;

import org.testng.annotations.Test;

public class BT_5 {
	int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	@Test
	public void run() {
		rotate();

	}

	public void rotate() {
		for (int i = 0; i < 10; i++) {
			b[10 - i - 1] = a[i];
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(b[i]);
		}
	}
}


