import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int direction[][] = new int[][] {
		{1,0},
		{0,1},
		{-1,0},
		{0,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		int[] goal = new int[2];
		Queue<int[]> qq = new ArrayDeque();
		Queue<int[]> ww = new ArrayDeque();
		boolean[][] v = new boolean[n][m];
		for(int i = 0; i<n;i++) {
			String ss = br.readLine();
			for(int j = 0; j <m;j++) {
				map[i][j] = ss.charAt(j);
				if(map[i][j] == 'S') {
					qq.offer(new int[] {i,j});
				}
				if(map[i][j] == '*') {
					ww.offer(new int[] {i,j});
				}
				if(map[i][j] == 'D') {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
		int cnt = 0;
		int flag = 0;
		
		top:
		while(!qq.isEmpty()) {
			//물 먼저 확산
			int water = ww.size();
			for(int i = 0; i<water;i++) {
				int[] pos = ww.poll();
				for(int j = 0; j <4;j++) {
					int nx = pos[0] + direction[j][0];
					int ny = pos[1] + direction[j][1];
					if(nx < 0 || nx >= n || ny < 0|| ny >= m) continue;
					if(map[nx][ny] != '.') continue;
					map[nx][ny] = '*';
					ww.offer(new int[] {nx,ny});
				}
			}
			int duck = qq.size();
			cnt++;
			for(int i = 0; i<duck;i++) {
				int[] pos = qq.poll();
				for(int j = 0; j <4;j++) {
					int nx = pos[0] + direction[j][0];
					int ny = pos[1] + direction[j][1];
					if(nx < 0 || nx >= n || ny < 0|| ny >= m) continue;
					if(v[nx][ny]) continue;
					if(map[nx][ny] == 'D') {
						flag = 1;
						break top;
					} 
					if(map[nx][ny] != '.') continue;
					
					v[nx][ny] = true;
					qq.offer(new int[] {nx,ny});
				}
			}			
		}
		
		if(flag == 1) {
			System.out.println(cnt);
		}
		else {
			System.out.println("KAKTUS");
		}
	}
}