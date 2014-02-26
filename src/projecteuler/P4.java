package projecteuler;

public class P4 implements P {

	@Override
	public void g() {
		int answer = 0;
		for(int a = 1; a < 1000; a++){
			for(int b = 1; b < 1000; b++){
					int temp = a * b;
					if((temp > answer) && temp == Integer.parseInt(new StringBuilder(Integer.toString(temp)).reverse().toString())){
						answer = temp;
				}
			}
		}
		System.out.println(answer);
	}

}
