package projecteuler;

public class P012 implements P {

	@Override
	public void g() {
		int triangleNumber = 0;
		int divisorCount = 0;
		for(int i = 1; divisorCount < 500; i++){
			int part = i + 1;
			int x = i % 2 == 0? i / 2 : i;
			int y = part % 2 == 0? part / 2 : part;
			triangleNumber = (i * part) / 2;
			int a = 0;
			int b = 0;
			for(int j = 1; j <= x; j++){
				if(x % j == 0){
					a++;
				}
			}
			for(int j = 1; j <= y; j++){
				if(y % j == 0){
					b++;
				}
			}
			divisorCount = a * b;
		}
		System.out.println(triangleNumber);
	}

}
