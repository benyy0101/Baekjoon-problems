import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] visited;
	static int K,R,C, map[][];
	static int[][] kMove = {
			{1,2},
			{1,-2},
			{2,1},
			{2,-1},
			{-2,1},
			{-2,-1},
			{-1,2},
			{-1,-2}
	};
	static int[][] direction = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[K+1][R][C];
		
		for(int i = 0 ; i < R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int  i = 0 ; i <= K;i++) {
			visited[i][0][0] = true;
		}
		System.out.println(bfs(0,0, K));
	}
	
	public static int bfs(int x, int y, int k) {
		Queue<int[]> qq = new LinkedList<>();
		qq.offer(new int[] {x,y,k, 0});

		while(!qq.isEmpty()) {
			int[] pos = qq.poll();
			x = pos[0];
			y = pos[1];
			k = pos[2];
			int cnt = pos[3];
			if(x == R-1 && y == C-1) {
				return cnt;
			}
			
			if(k>0) {
				for(int i = 0 ; i < 8;i++) {
					int nx = x + kMove[i][0];
					int ny = y + kMove[i][1];
					
					if(nx < 0 || nx>= R || ny < 0 || ny >= C) continue;
					if(map[nx][ny] == 1 || visited[k-1][nx][ny]) continue;
					visited[k-1][nx][ny] = true;
					qq.offer(new int[] {nx,ny,k-1, cnt+1});
				}
			}
			
			for(int i = 0 ; i < 4;i++) {
				int nx = x + direction[i][0];
				int ny = y + direction[i][1];
				
				if(nx < 0 || nx>= R || ny < 0 || ny >= C) continue;
				if(map[nx][ny] == 1 || visited[k][nx][ny]) continue;
				visited[k][nx][ny] = true;
				qq.offer(new int[] {nx,ny,k, cnt+1});
			}
		}
		return -1;
	}
}