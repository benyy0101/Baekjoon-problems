import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r,c,startX,startY;
	static char[][] map;
	static boolean[][] v;
	static boolean flag;
	
	static int[][] direction = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		v = new boolean[r][c];
		for(int i=0;i <r;i++) {
			String ss = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = ss.charAt(j);
			}
		}
		for(int i = 0 ; i < r;i++) {
			for(int j = 0 ; j < c ;j++) {
				if(!v[i][j]) {
					init(i,j);
					dfs(i,j,0);
				}  
			}
		}
		if(!flag) System.out.println("No");
		else System.out.println("Yes");
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(x == startX &&  y == startY && cnt >=4) {
			flag = true;
			return;
		}
		
		for(int i = 0 ; i < 4;i++) {
			int nx = direction[i][0] + x;
			int ny = direction[i][1] + y;
			
			if(nx < 0 || nx >=r || ny<0 || ny >= c) continue;
			if(map[x][y] != map[nx][ny]) continue;
			if(v[nx][ny]) continue;
			v[nx][ny] = true;
			dfs(nx,ny,cnt+1);
		}
	}
	public static void init(int i, int j) {
		v = new boolean[r][c];
		startX = i;
		startY = j;
	}
	
}