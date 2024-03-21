import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int a = A.length();
		int b = B.length();
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[A.length()+1][B.length()+1];
		
		for(int i = 1; i <= a;i++) {
			for(int j = 1; j <= b ;j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} 
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		Stack<Character> stk = new Stack<>();
		
		while(a > 0 && b > 0) {
			if(a == 0 || b == 0) break;
			if(dp[a][b] == dp[a-1][b]) a--;
			else if (dp[a][b] == dp[a][b-1]) b--;
			else {
				stk.add(A.charAt(a-1));
				a--;
				b--;
			}
		}
		while(!stk.isEmpty()) sb.append(stk.pop());
		
		System.out.println(dp[A.length()][B.length()]);
		System.out.println(sb);
	}
}