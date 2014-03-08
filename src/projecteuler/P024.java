package projecteuler;

public class P024 implements P {

	@Override
	public void g() {
		// http://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
		// 590.074481 milliseconds
		int[][] list = new int[1000000][10];
		int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] reverse;
		int count = 1;
		loop: 
		while (count < 1000000) {
			int k = -1;
			int l = 0;
			for (int i = 0; i < num.length - 1; i++) {
				k = num[i] < num[i + 1] && i > k ? i : k;
			}
			if (k == -1)
				break loop;
			for (int i = 0; i < num.length; i++) {
				l = num[k] < num[i] && i > l ? i : l;
			}
			int a = num[k];
			int b = num[l];
			num[l] = a;
			num[k] = b;
			int t = k + 1;
			reverse = new int[num.length - t];
			for (int i = reverse.length - 1; i >= 0; i--) {
				reverse[i] = num[t++];
			}
			t = k + 1;
			for (int i = 0; i < reverse.length; i++) {
				num[t++] = reverse[i];
			}
			for (int i = 0; i < list[0].length; i++) {
				list[count][i] = num[i];
			}
			count++;
		}
		//Answer:
		for (int i : list[999999]) {
			System.out.print(i);
		}
	}

}
