

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		StringBuilder sb; 
		
		for(int j = 1; j <= i;j++) {
			sb = new StringBuilder();
			for(int k = 0; k < i - (j);k++) {
				sb.append(" ");
			}
			
			for (int k = 0; k < j; k++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}
}
