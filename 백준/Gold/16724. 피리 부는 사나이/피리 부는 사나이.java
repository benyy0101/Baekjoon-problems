import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int parent[],N,M,idx;
	public static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		idx = N * M;
		parent = new int[idx];
		map = new char[N][M];
		
		for(int i = 0 ; i < N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < idx ;i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < idx ;i++) {
			int curX = i / M;
			int curY = i % M;
			int parX = curX;
			int parY = curY;
			if(map[curX][curY] == 'D') parX++;
			else if(map[curX][curY] == 'U') parX--;
			else if(map[curX][curY] == 'L') parY--;
			else parY++;
			parent[i] = find(parX * M + parY);
		}
		
		for(int i = 0 ; i < idx;i++) {
			parent[i] = find(i);
		}
		int ans = 0;
		
		HashMap<Integer, Boolean> parentMap = new HashMap<>();
		for(int i = 0 ; i < idx;i++) {
			if(!parentMap.containsKey(parent[i])) {
				parentMap.put(parent[i],true);
				ans++;
			}
			
		}
		System.out.println(ans);
	}
	
	public static int find(int i) {
		if(parent[i] == i) return i;
		return find(parent[i]);
	}
}