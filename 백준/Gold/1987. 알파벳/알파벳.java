
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] alphabet;
	static char map[][];
	static int direction[][] = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int r,c, maxLength;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxLength = 0;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		alphabet = new boolean[26];
		map = new char[r][c];
		for(int i= 0; i< r;i++) {
			String ss = br.readLine();
			for(int j = 0 ; j <c ;j++) {
				map[i][j] = ss.charAt(j);
			}
		}
		
		dfs(0,0,0);
		System.out.println(maxLength);
	}
	public static void dfs(int x, int y, int depth) {
		if(alphabet[map[x][y] - 'A']) {
			maxLength = Math.max(maxLength, depth);
			return;
		}
		alphabet[map[x][y] - 'A'] = true;
		for(int i = 0; i<4;i++) {
			int nx = x + direction[i][0];
			int ny = y + direction[i][1];
			
			if(nx <0 || nx >=r || ny <0 || ny >=c) continue;
			
			dfs(nx,ny,depth+1);
			
			
		}
		alphabet[map[x][y] - 'A'] = false;
	}
}
