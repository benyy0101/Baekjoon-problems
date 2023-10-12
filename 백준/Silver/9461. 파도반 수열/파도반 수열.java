import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		long answer = 0;
		for(int tc = 0; tc < T;tc++) {
			int N = Integer.parseInt(br.readLine());
			if(dp[N] != 0) answer = dp[N];
			else answer = solve(N);
			System.out.println(answer);
		}
	}
	
	public static long solve(int num) {
		for(int i = 3; i <= num;i++){
			dp[i] = dp[i-2] + dp[i-3];
		}
		return dp[num];
	}
}