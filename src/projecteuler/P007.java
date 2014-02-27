package projecteuler;

public class P007 implements P {

	@Override
	public void g() {
		int count = 1;
		int answer = 0;
		loop:
		for(int i = 3; count < 10001; i++){
			if((i & 1) != 0 ){
				for(int j = 3; j < i/2; j+=2){ //loop condition
					if(i % j == 0){
						continue loop;
					}
				}
				answer = i;
				count++;
			}
		}
		System.out.println(answer);
	}

}
