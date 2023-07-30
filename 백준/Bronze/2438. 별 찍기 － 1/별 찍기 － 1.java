import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int j = 0; j<i;j++) {
			sb.append("*");
			System.out.println(sb.toString());
		}
	}
}