package projecteuler;

public class P002 implements P {

	@Override
	public void g() {
		int a = 1;
		int b = 2;
		int c = 0;
		int total = 2;
		while(c < 4000000){
			c = a + b;
			a = b;
			b = c;
			total += (c & 1) == 0 ? c : 0;
		}
		System.out.println(total);
	}

}
