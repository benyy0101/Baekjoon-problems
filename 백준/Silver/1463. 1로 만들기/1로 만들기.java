import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		if(N>=2) dp[2] = 1;
		if(N>=3) dp[3] = 1;
		
		for(int i= 1; i<=N ;i++) {
			if(i * 3 <= N) dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
			if(i* 2 <= N) dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
			if(i + 1 <= N) dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
		}
		System.out.println(dp[N]);
	}
}