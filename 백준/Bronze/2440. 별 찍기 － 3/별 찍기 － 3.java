import java.util.Scanner;

// baekjoon 2240 별찍기

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("*");
		}
		for (int i = 0; i < n; i++) {
			System.out.println(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
