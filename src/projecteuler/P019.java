package projecteuler;

public class P019 implements P {

	@Override
	public void g() {
		boolean[] year = new boolean[365];
		boolean[] leapYear = new boolean[366];
		year[0] = year[31] = year[59] = year[90] = year[120] = year[151]
		= year[181] = year[212] = year[243] = year[273] = year[304] 
		= year[334] = leapYear[0] = true;
		int count = 0;
		boolean[] century = new boolean[0];
		for (int i = 1; i < year.length; i++) {
			if (year[i]) {
				leapYear[i + 1] = true;
			}
		}
		for (int i = 0; i < 101; i++) {
			boolean[] temp = i % 4 == 0 && i != 0 ? leapYear : year; // first(reference) year is not leap year
			boolean[] resize = new boolean[century.length];
			for (int j = 0; j < century.length; j++) {
				resize[j] = century[j];
			}
			century = new boolean[resize.length + temp.length];
			for (int a = 0; a < resize.length; a++) {
				century[a] = resize[a];
			}
			int counter = 0;
			for (int b = resize.length; b < century.length; b++) {
				century[b] = temp[counter++];
			}
		}
		for (int i = 6; i < century.length; i += 7) {
			if (i > 364) { // not including reference year
				if (century[i]) {
					count++;
				}
			}
		}
		System.out.println(count - 1);// because last sunday lands in the year 1st Jan 2001
	}

}
