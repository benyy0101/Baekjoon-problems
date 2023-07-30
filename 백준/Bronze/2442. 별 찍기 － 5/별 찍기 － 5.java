import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		
		StringBuilder sb;
		
		for (int i = 0 ; i < loop; i++) {
			sb = new StringBuilder();
			
			for(int j = 0; j < (loop - (i+1)); j++) {
				sb.append(" ");
			}
			for(int j = 0; j < 2 * i + 1; j++) {
				sb.append("*");
			}
			
			System.out.println(sb.toString());
		}
		
		
	}
}
