package projecteuler;

public class P021 implements P {

	@Override
	public void g() {
		int answer = 0;
		int[][] num = new int[10000][2];
		for(int i = 2; i < 10000; i++){
			if((i & 1) == 0){
			num[i - 2][0] = i;
			for(int a = 1; a < i; a++){
				if(i % a == 0){
					num[i - 2][1] += a;
				}
			}
			}
		}
		for(int i = 0; i < num.length; i++){
			if(num[i][0] != 0){
			for(int a = 0; a < num.length; a++){
				if(num[a][0] != 0 && i != a){
				if(num[i][0] == num[a][1] && num[i][1] == num[a][0]){
					answer += (num[i][0] + num[a][0]);
					num[i][0] = num[a][0] = 0;
					break;
				}
				}
			}
			}
		}
		System.out.println(answer);
	}

}
