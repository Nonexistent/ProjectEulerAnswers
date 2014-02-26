package projecteuler;

public class P1 implements P{

	@Override
	public void g() {
		int f = 5;
		int t = 3;
		int x = 0;
		for(int i = 0; i < 1000; i++){
			if(i%f == 0 || i%t == 0){
				x += i;
			}
		}
		System.out.println(x);
		
	}
	
}
