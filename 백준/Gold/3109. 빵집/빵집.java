import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] map;
	static int count,N,K;
	static int direction[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 0;
		
		map = new boolean[N][K];
		
		direction = new int[] {-1,0,1};
		
		for(int i = 0 ; i <N;i++) {
			String line = br.readLine();
			for(int j = 0; j < K;j++) {
				map[i][j] = (line.charAt(j)=='.') ? false : true;
			}
		}
		
		for(int i = 0 ; i <N;i++) {
			if(dfs(i,0)) {
				count++;
				if(map[N-1][K-1]) break;
			}
//			for(int j = 0 ; j <N;j++) {
//				System.out.println(Arrays.toString(map[j]));
//			}
//			System.out.println();
		}
		System.out.println(count);
	}
	
	public static boolean dfs(int start, int depth) {
		map[start][depth] = true;
		
		if(depth == K - 1) {
			return map[start][depth];
		}
		
		for(int i = 0; i < 3; i++) {
			int dx = start + direction[i];
			if(dx >= 0 && dx <N && map[dx][depth+1] == false && dfs(dx,depth+1)) {
				return true;
			}
		}
		return false;
	};
}
