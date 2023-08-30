import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int R,C;
	static int[][] direction= {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		dp = new int[R+1][C+1];
		
		for(int i = 1; i<= R ;i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 1 ; i <=R ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(1,1));
		//System.out.println(Arrays.deepToString(dp));
	}
	
	public static int dfs(int x, int y) {
		if(x == R && y == C) return dp[x][y] = 1;
		if(dp[x][y] != -1) return dp[x][y];
		dp[x][y] = 0;
		for(int i = 0 ; i < 4;i++) {
			int nx = x + direction[i][0];
			int ny = y + direction[i][1];
			
			if(nx <= 0 || nx > R || ny <= 0 || ny > C) continue;
			if(map[nx][ny] >= map[x][y]) continue;
			
			dp[x][y] += dfs(nx,ny);
		}
		return dp[x][y];
	}
}

/**
Hi, Benny!
What up man
*/