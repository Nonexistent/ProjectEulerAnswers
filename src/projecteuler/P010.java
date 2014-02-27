package projecteuler;

public class P010 implements P {

	@Override
	public void g() {
		// uses modified Sieve of Eratosthenes
		long answer = 2L; // only even prime; skip it
		boolean[] list = new boolean[2000000];
		for (int i = 4; i < list.length; i += 2) {
			list[i - 1] = true;
		}
		for (int i = 3; i < list.length; i += 2) {
			for (int j = 2; j * i < list.length; j++) {
				list[(j * i) - 1] = true;
			}
		}
		for (int i = 3; i < list.length; i += 2) {
			if (!list[i - 1]) {
				answer += i;
			}
		}
		System.out.println(answer);
	}

}
