package projecteuler;

public class P014 implements P {

	@Override
	public void g() {
		int starting = 0;
		int count = 0;
		for (int i = 1000000 - 1; i > 0; i--) {
			long end = (long)i;
			int tempCount = 0;
			while (end != 1) {
				end = (end & 1) == 0 ? end / 2 : (end * 3) + 1;
				tempCount++;
			}
			if (tempCount > count) {
				starting = i;
				count = tempCount;
			}
		}
		System.out.println(starting);
	}

}
