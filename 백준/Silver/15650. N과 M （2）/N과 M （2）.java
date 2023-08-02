
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int m;
	static int n;
	static int[] output;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		output = new int[m];
		combination(0,1);
	}
	
	public static void combination(int depth, int start) {
		if(depth == m) {
			sb = new StringBuilder();
		
			for(int item:output) {
				sb.append(item+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = start; i<= n;i++) {
			output[depth] = i;
			combination(depth+1,i+1);
		}
	}
}
