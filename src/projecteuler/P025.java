package projecteuler;

public class P025 implements P {

	@Override
	public void g() {
		// 89.064863 milliseconds
		int term = 3;
		int[] a = { 1 };
		int[] b = { 1 };
		int[] temp;
		int[] resize;
		while (b.length != 1000) {
			int carry = 0;
			int indexA = a.length - 1;
			int indexB = b.length - 1;
			temp = new int[b.length];
			while (indexA >= 0) {
				int t = (b[indexB] + a[indexA--]) + carry;
				if (t >= 10) {
					carry = 1;
					t = t - 10;
				} else {
					carry = 0;
				}
				temp[indexB--] = t;
			}
			if (indexB >= 0) {
				int t = b[indexB] + carry;
				if (t >= 10) {
					temp[indexB] = t - 10;
					resize = temp;
					temp = new int[temp.length + 1];
					for (int x = resize.length - 1; x >= 0; x--) {
						temp[x + 1] = resize[x];
					}
					temp[0] = 1;
				} else {
					temp[indexB] = t;
				}
			} else if (carry != 0) {
				resize = temp;
				temp = new int[temp.length + 1];
				for (int x = resize.length - 1; x >= 0; x--) {
					temp[x + 1] = resize[x];
				}
				temp[0] = 1;
			}
			a = b;
			b = temp;
			term++;
		}
		System.out.println(term - 1);
	}

}
