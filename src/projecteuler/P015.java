package projecteuler;

import java.util.Arrays;

public class P015 implements P {

	@Override
	public void g() {
		// 40C20, factorial too large; cancel like terms
		long answer = 0L;
		int n = 40;
		int r = 20;
		int count = 0;
		int[] top = new int[350];
		int[] bottom = new int[350];
		Arrays.fill(top, 1);
		Arrays.fill(bottom, 1);
		for (int i = n; i > 20; i--) {
			int temp = i;
			for (int a = 2; a <= temp; a++) {
				while (temp % a == 0) {
					top[count++] = a;
					temp = temp / a;
				}
			}
		}
		count = 0;
		for (int i = r; i > 0; i--) {
			int temp = i;
			for (int a = 2; a <= temp; a++) {
				while (temp % a == 0) {
					bottom[count++] = a;
					temp = temp / a;
				}
			}
		}
		// Cancel like terms
		for (int a = 0; a < 350; a++) {
			in: for (int b = 0; b < 350; b++) {
				if (top[a] == bottom[b]) {
					top[a] = 1;
					bottom[b] = 1;
					break in;
				}
			}
		}
		long a = 1L;
		long b = 1L;
		for (int i : top) {
			a *= i;
		}
		for (int i : bottom) {
			b *= i;
		}
		answer = a / b;
		System.out.println(answer);
	}

}
