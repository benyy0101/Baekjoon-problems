import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int count;
	static int T;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		map = new int[T][T];
		StringTokenizer st;
		for(int i = 0 ; i < T;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <T;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,0);
		System.out.println(count);
	}
	
	public static void dfs(int x, int y,int status) {
		if(x == T-1 && y == T-1) {
			count++;
			return;
		}
		
		if(status == 0) {
			if(y+1 <T && map[x][y+1] != 1) {
				dfs(x,y+1,0);
				if(x+1 <T && map[x+1][y]!=1 && map[x+1][y+1] !=1) {
					dfs(x+1,y+1,2);
				}
			}
		}
		else if(status==1) {
			if(x+1 < T && map[x+1][y] !=1) {
				dfs(x+1,y,1);
				if(y+1 < T && map[x][y+1] !=1 && map[x+1][y+1] !=1) {
					dfs(x+1,y+1,2);
				}
			}
		}
		else {
			if(y+1 < T && map[x][y+1] != 1) {
				dfs(x,y+1,0);
			}
			if(x+1 <T && map[x+1][y] !=1) {
				dfs(x+1,y,1);
			}
			if(x+1 <T && map[x+1][y] !=1 && y+1 < T && map[x][y+1] != 1 && map[x+1][y+1] != 1) {
				dfs(x+1,y+1,2);
			}
		}
	}
}
