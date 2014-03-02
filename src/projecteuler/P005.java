package projecteuler;

public class P005 implements P {

	@Override
	public void g() {
		int answer;
		for(answer = 20; answer < Integer.MAX_VALUE; answer+=2){
			int count = 0;
			for(int i = 2; (answer % i == 0) && i <= 20; i++){
					count++;
			}
			if(count == 19){
				break;
			}
		}
		System.out.println(answer);
	}

}
