
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean v[];
	static int map[][], N;
	static int minCost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minCost = Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		StringTokenizer st;
		v = new boolean[N+1];
		for(int i = 1 ; i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v[1] = true;
		dfs(1,1,1,0);
		System.out.println(minCost);
	}
	
	public static void dfs(int start, int now, int cnt, int cost) {

		if (now == start && cost > 0) {
			minCost = Math.min(minCost, cost);
			return;
		}

		for (int n = 1; n <= N; n++) {
			if (map[now][n] > 0) {
				if (n == start && cnt == N) {
					cost += map[now][n];
					dfs(start, n, cnt + 1, cost);
				}
				else if (!v[n]) {
					v[n] = true;
					cost += map[now][n];
					dfs(start, n, cnt + 1, cost);
					cost -= map[now][n];
					v[n] = false;
				}
			}
		}
	}
}
