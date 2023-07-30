

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		
		StringBuilder sb;
		for (int i = 0 ; i < loop; i++) {
			sb = new StringBuilder();
			for(int l = 0; l <i; l++) {
				sb.append(" ");
			}
			for(int k = 0 ; k < loop - i; k++) {
				sb.append("*");
			}
			System.out.println(sb);
		}
		
		
	}
}
