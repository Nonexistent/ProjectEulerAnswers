package projecteuler;

public class P009 implements P {

	@Override
	public void g() {
		int a = 0;
		int b = 1000;
		int c = 1000;
		int answer = 0;
		loop: 
		for (int x = 1; x < b - 1; x++) {
			a = x;
			for (int y = x + 1; y < c - 1; y++) {
				b = y;
				for (int z = y + 1; z < 1000; z++) {
					c = z;
					if (a + b + c == 1000) {
						if ((a * a) + (b * b) == (c * c)) {
							answer = a * b * c;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
