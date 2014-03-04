package projecteuler;

public class P020 implements P {

	@Override
	public void g() {
		// It's a mess, but it works, executes in 3.95821 milliseconds
		int answer = 0;
		int[] productArray = new int[1];
		productArray[0] = 1;
		int[][] temp;
		for (int i = 1; i <= 100; i++) {
			int t = i;
			int carry = 0;
			temp = i < 10 ? new int[1][] : i < 100 ? new int[2][] : new int[3][];
			int[] multiBy = new int[temp.length];
			for (int k = multiBy.length - 1; k >= 0; k--) {
				multiBy[k] = t % 10;
				t /= 10;
			}
			int count = 0;
			// multiply
			for (int a = multiBy.length - 1; a >= 0; a--) {
				carry = 0;
				temp[count] = new int[productArray.length];
				int index = productArray.length - 1;
				for (int b = productArray.length - 1; b >= 0; b--) {
					int h = (multiBy[a] * productArray[b]) + carry;
					if (h >= 10) {
						carry = h / 10;
						h = h % 10;
					} else {
						carry = 0;
					}
					temp[count][index--] = h;
				}
				if (carry != 0) {
					int[] resize = new int[temp[count].length + 1];
					for (int x = temp[count].length - 1; x >= 0; x--) {
						resize[x] = temp[count][x];
					}
					temp[count] = new int[temp[count].length + 1];
					for (int x = 1; x < resize.length; x++) {
						temp[count][x] = resize[x - 1];
					}
					temp[count][0] = carry;
				}
				count++;
			}
			carry = 0;
			// addition
			int[] resize = new int[1];
			if (temp.length == 1) {
				productArray = new int[temp[0].length];
				for (int a = temp[0].length - 1; a >= 0; a--) {
					productArray[a] = temp[0][a];
				}
			} else if (temp.length == 2) {
				productArray = new int[temp[1].length + 1];
				int firstRow = temp[0].length - 1;
				int secondRow = temp[1].length - 1;
				int arrayIndex = productArray.length - 1;
				productArray[arrayIndex--] = temp[0][firstRow--];
				while (firstRow >= 0) {
					int sum = (temp[0][firstRow--] + temp[1][secondRow--]) + carry;
					if (sum >= 10) {
						carry = sum / 10;
						sum = sum % 10;
					} else {
						carry = 0;
					}
					productArray[arrayIndex--] = sum;
				}
				if (secondRow >= 0) {
					temp[1][secondRow] = carry != 0 ? temp[1][secondRow] + carry : temp[1][secondRow];
					carry = 0;
					while (secondRow >= 0) {
						int num = temp[1][secondRow] + carry;
						if (num >= 10) {
							carry = num / 10;
							temp[1][secondRow] = num % 10;
						} else {
							carry = 0;
							temp[1][secondRow] = num;
						}
						productArray[arrayIndex--] = temp[1][secondRow--];
					}
				}
					if (carry != 0) {
						resize = new int[productArray.length + 1];
						for (int x = 0; x < productArray.length; x++) {
							resize[x] = productArray[x];
						}
						productArray = new int[resize.length];
						productArray[0] = carry;
						for (int x = 1; x < productArray.length; x++) {
							productArray[x] = resize[x - 1];
						}
					}
			} else if (temp.length == 3) {
				productArray = new int[temp[2].length + 2];
				int firstRow = temp[0].length - 1;
				int secondRow = temp[1].length - 1;
				int thirdRow = temp[2].length - 1;
				int arrayIndex = productArray.length - 1;
				productArray[arrayIndex--] = temp[0][firstRow--];
				int h = temp[0][firstRow--] + temp[1][secondRow--];
				if (h >= 10) {
					h = h - 10;
					carry = 1;
				} else {
					carry = 0;
				}
				productArray[arrayIndex--] = h;
				while (firstRow >= 0) {
					int sum = (temp[0][firstRow--] + temp[1][secondRow--] + temp[2][thirdRow--]) + carry;
					if (sum >= 10) {
						carry = sum / 10;
						sum = sum % 10;
					} else {
						carry = 0;
					}
					productArray[arrayIndex--] = sum;
				}
				while (secondRow >= 0) {
					int sum = (temp[1][secondRow--] + temp[2][thirdRow--]) + carry;
					if (sum >= 10) {
						carry = sum / 10;
						sum = sum % 10;
					} else {
						carry = 0;
					}
					productArray[arrayIndex--] = sum;
				}
				temp[2][thirdRow] = carry != 0 ? temp[2][thirdRow] + carry : temp[2][thirdRow];
				carry = 0;
				while (thirdRow >= 0) {
					int num = temp[2][thirdRow];
					if (num >= 10) {
						carry = num / 10;
						num = num % 10;
					} else {
						carry = 0;
						temp[2][thirdRow] = num;
					}
					productArray[arrayIndex--] = temp[2][thirdRow--];
				}
				if (carry != 0) {
					resize = new int[productArray.length + 1];
					for (int x = 0; x < productArray.length; x++) {
						resize[0] = productArray[0];
					}
					productArray = new int[resize.length];
					for (int x = 1; x < productArray.length; x++) {
						productArray[x] = resize[x - 1];
					}
				}
			}
		}
		for (int i : productArray) {
			answer += i;
		}
		System.out.println(answer);
	}

}
