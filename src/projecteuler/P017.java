package projecteuler;

public class P017 implements P {

	@Override
	public void g() {
		String[] ones = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String hundred = "hundred";
		String and = "and";
		String[] exce = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		int[] number = new int[3];
		int total = 0;
		for(int i = 1; i < 1000; i++){
			int temp = i;
			String word = "";
			for(int index = 2; index >= 0; index--){
				number[index] = temp % 10;
				 temp /= 10;
			}
			word += number[0] == 0 ? "" : number[1] == 0 && number[2] == 0 ? ones[number[0] - 1] + hundred : ones[number[0] - 1] + hundred + and;
			word += number[1] == 0 ? "" : number[1] >= 1 && number[1] < 2 ? exce[number[2]] : tens[number[1] - 2];
			word += number[2] == 0 ? "" : number[1] >= 1 && number[1] < 2 ? "" : ones[number[2] - 1];
			total += word.length();
		}
		System.out.println(total + "onethousand".length());
	}

}
