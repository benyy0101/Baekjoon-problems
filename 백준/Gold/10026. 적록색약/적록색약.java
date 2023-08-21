import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int normal, colored, size;
	static boolean visitedN[][],visitedC[][];
	static int[][] direction = new int[][] {
		{1,0},
		{0,1},
		{-1,0},
		{0,-1}
	};
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		normal = 0;
		colored = 0;
		
		map = new char[size][size];
		
		for (int i = 0 ; i < size ;i++) {
			String ss = br.readLine();
			for(int j = 0; j <size ;j++) {
				map[i][j] = ss.charAt(j);
			}
		}
		visitedN = new boolean[size][size];
		visitedC = new boolean[size][size];
		
		for(int i = 0; i <size;i++) {
			for(int j=0 ; j <size;j++) {
				if(!visitedN[i][j]) {
					bfs(i,j,false, map[i][j]);
					normal++;
				} 
				if(!visitedC[i][j]) {
					bfs(i,j,true, map[i][j]);
					colored++;
				} 
			}
		}
		System.out.println(normal + " " + colored);
	}
	
	public static void bfs(int x, int y, boolean isColored, char color) {
		Queue<int[]> qq = new ArrayDeque<>();
		qq.offer(new int[] {x,y});
		if(isColored) {
			visitedC[x][y] = true;
		}
		else {
			visitedN[x][y] = true;
		}
		while(!qq.isEmpty()) {
			int[] pos = qq.poll();
			
			for(int i = 0 ; i <4;i++) {
				int nx = direction[i][0] + pos[0];
				int ny = direction[i][1] + pos[1];
				
				if(nx < 0 || nx >= size || ny <0 ||ny >= size) continue;
				
				if(!isColored && visitedN[nx][ny]) continue;
				if(isColored && visitedC[nx][ny]) continue;
				
				if(!isColored) {
					if(map[nx][ny] !=  color) continue;
					visitedN[nx][ny] = true;
					qq.offer(new int[] {nx,ny});
				}
				else {
					if(color == 'B' && map[nx][ny] == color) {
						visitedC[nx][ny] = true;
						qq.offer(new int[] {nx,ny});
					}
					else if(color != 'B' && map[nx][ny] != 'B') {
						visitedC[nx][ny] = true;
						qq.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}
}