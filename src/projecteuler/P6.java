package projecteuler;

public class P6 implements P {

	@Override
	public void g() {
		int sumOfSquare = 0;
		int squareOfSum = 0;
		int answer = 0;
		for(int i = 1; i <= 100; i++){
			sumOfSquare += (int)Math.pow(i, 2);
			squareOfSum += i;
		}
		answer = (int)Math.pow(squareOfSum, 2) - sumOfSquare;
		System.out.println(answer);
	}

}
