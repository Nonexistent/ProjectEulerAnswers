package projecteuler;

public class P016 implements P {

	@Override
	public void g() {
		//runs in 30 milliseconds
		int answer = 0;
		int[] temp = { 1 };
		int[] resize;
		int carry = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = temp.length - 1; j >= 0; j--) {
				int t = temp[j] * 2;
				t = carry == 1 ? t + carry : t;
				if (t >= 10) {
					temp[j] = t - 10;
					carry = 1;
				} else {
					temp[j] = t;
					carry = 0;
				}
			}
			// resize array
			int counter = temp.length - 1;
			if(carry == 1){
				resize = new int[temp.length + 1];
				for(int h = resize.length - 1; counter >= 0; h--){
					resize[h] = temp[counter--];
				}
				resize[0] = carry;
				temp = new int[resize.length];
				for(int k = resize.length - 1; k >= 0; k--){
					temp[k] = resize[k];
				}
			}
			carry = 0;
		}
		for(int k : temp){
		answer += k;
		}
		System.out.println(answer);
	}

}
