package projecteuler;

public class P005 implements P {

	@Override
	public void g() {
		int answer;
		for(answer = 20; answer < Integer.MAX_VALUE; answer++){
			int count = 0;
			for(int i = 1; i <= 20; i++){
				if(answer % i == 0){
					count++;
				}
			}
			if(count == 20){
				System.out.println(count);
				break;
			}
			count = 0;
		}
		System.out.println(answer);
	}

}
