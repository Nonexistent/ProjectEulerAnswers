package projecteuler;

public class P023 implements P {

	@Override
	public void g() {
		//method sucks; too slow, going to rewrite it later
		long answer = 0;
		int[] abundant = new int[0];
		int[] resize;
		for (int i = 2; i <= 28123; i++) {
			int t = 0;
			for (int a = 1; a * a <= i; a++) {
				t += i % a != 0 ? 0 : a == 1 ? 1 : i / a != a ? a + (i / a) : a;
			}
			if (t > i) {
				resize = abundant;
				abundant = new int[abundant.length + 1];
				for (int a = 0; a < resize.length; a++) {
					abundant[a] = resize[a];
				}
				abundant[abundant.length - 1] = i;
			}
		}
		loop: 
		for (int i = 1; i <= 28123; i++) {
			System.out.println(i);
			for(int a = 0; a < abundant.length; a++){
				if(i == abundant[a]){
					continue loop;
				}
			}
			for (int a = 0; a < abundant.length && i >= abundant[a]; a++) {
				int temp = i - abundant[a];
				if (temp > 0) {
					int t = 0;
					for (int b = 1; b * b <= temp; b++) {
						t += temp % b != 0 ? 0 : b == 1 ? 1 : temp / b != b ? b + (temp / b) : b;
					}
					if (t > temp) {
						continue loop;
					}
				}
			}
			answer += i;
		}
		System.out.println("answer: " + answer);
	}
}
