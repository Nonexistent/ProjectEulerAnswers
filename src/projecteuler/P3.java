package projecteuler;

import java.util.TreeSet;

public class P3 implements P {

	@Override
	public void g() {
		long start = 600851475143L;
		TreeSet<Long> factors = new TreeSet<Long>();
		for(long i = 2L; i <= start; i++){
			while(start % i == 0){
				factors.add(i);
				start = start / i;
			}
		}
		System.out.println(factors.last());
	}

}
