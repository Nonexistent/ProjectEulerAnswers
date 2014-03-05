package projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P022 implements P {

	@Override
	public void g() {
		String[] names = null;
		long answer = 0;
		String[][] values =  new String[2][26];
		int count = 0;
		for(char a = 'a'; a <= 'z'; a++){
			values[0][count] = String.valueOf(a);
			values[1][count] = Integer.toString(count + 1);
			count++;
		}
		try {
			String temp = "";
			Scanner input = new Scanner(new File("names.txt"));
			while(input.hasNext()){
			temp += input.next();
			}
			input.close();
			names = temp.toLowerCase().replace("\"", "").split(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String t = "";
		for(int i = 0; i < names.length; i++){
			for(int a = i + 1; a < names.length; a++){
				if(names[i].compareTo(names[a]) > 0){
					t = names[i];
					names[i] = names[a];
					names[a] = t;
				}
			}
		}
		for(int i = 0; i < names.length; i++){
			int temp = 0;
			String tempName = names[i];
			for(int a = 0; a < tempName.length(); a++){
				String letter = String.valueOf(tempName.charAt(a));
				for(int b = 0; b < values[0].length; b++){
					if(letter.equals(values[0][b])){
						temp += Integer.parseInt(values[1][b]);
						break;
					}
				}
			}
			answer += temp * (i + 1);
		}
		System.out.println(answer);
	}

}
