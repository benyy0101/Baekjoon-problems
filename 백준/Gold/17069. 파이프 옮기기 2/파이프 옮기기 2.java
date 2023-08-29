

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		long[][][] dp = new long[3][N+1][N+1];
		
		StringTokenizer st;
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1][2] = 1;
		
		for(int i = 1 ; i <= N;i++) {
			for(int j = 2; j <= N;j++) {
				//dp[i][j][1] -> dp[i][j+1][1]
				//dp[i][j][1] -> dp[i+1][j+1][0]
				
				//dp[i][j][0] -> dp[i+1][j+1][0]
				//dp[i][j][0] -> dp[i+1][j][2]
				//dp[i][j][0] -> dp[i][j+1][1]
				
				//dp[i][j][2] -> dp[i][j+1][2]
				//dp[i][j][2] -> dp[i+1][j+1][0]
				
				//가로
				if(j+1 <= N && map[i][j+1] != 1) {
					
					dp[1][i][j+1] += (dp[1][i][j] + dp[0][i][j]);
				}
				//세로
				if(i+1 <= N && map[i+1][j] != 1) {
					dp[2][i+1][j] += (dp[0][i][j]+dp[2][i][j]);
				}
				//대각
				if(i+1 <= N && j+1 <= N && map[i+1][j] != 1 && map[i][j+1] != 1 && map[i+1][j+1] != 1) {
					dp[0][i+1][j+1] += (dp[1][i][j] + dp[2][i][j] +dp[0][i][j]);
				}
			}
		}
		long sum = 0 ;
		for(int i = 0 ; i < 3; i++) {
			sum += dp[i][N][N];
		}
		
		System.out.println(sum);
	}
}
