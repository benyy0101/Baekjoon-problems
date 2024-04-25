import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i = 0 ; i < N+1;i++) {
			for(int j = 0; j < N+1; j++) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = 100 * 1000 + 1;
			}
		}
		int answer = -1;
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = cost;
		}
		
		for(int k = 0 ; k < N+1;k++) {
			for(int i = 0 ; i <N+1;i++) {
				for(int j = 0 ; j < N+1;j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int i = 1 ; i <= N;i++) {
			answer = Math.max(answer, map[i][X] + map[X][i]);
		}
		System.out.println(answer);
	}
}