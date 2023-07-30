import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		
		StringBuilder sb;
		
		for (int i = loop - 1,k=0; i >= 0; i--,k++) {
			sb = new StringBuilder();
			
			for(int j = 0 ; j < k; j++) {
				sb.append(" ");
			}
			
			for(int j = i*2 + 1; j>0; j--) {
				sb.append("*");
			}
			
			
			
			
			
			System.out.println(sb.toString());
		}
		
		
	}
}
