import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String target = sc.next();
		int[] alpha = new int[26];
		for (char item: target.toCharArray()) {
			alpha[Character.toUpperCase(item) - 'A']++;
		}
		
		int maxCount = 0;
		char maxAlpha = 0;
		for(int i=0;i<26;i++) {
			if(maxCount < alpha[i]) {
				maxCount = alpha[i];
				maxAlpha = (char)('A' + i);
			}
			else if(maxCount == alpha[i]) {
				maxAlpha = '?';
			}
		}	
		System.out.println(maxAlpha);
		
	}
}
