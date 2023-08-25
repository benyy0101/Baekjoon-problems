import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static LinkedList[] map;
	static boolean onCycle[], flag, visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new LinkedList[n+1];
		onCycle = new boolean[n+1];
		visited = new boolean[n+1];
		StringTokenizer st;
		for(int i = 0; i < n+1;i++) {
			map[i] = new LinkedList<>();
		}
		
		for(int i = 0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from].add(to);
			map[to].add(from);
		}
		
		for(int i = 1 ;i <= n;i++) {
			if(dfs(i,i,0)) break;
			onCycle = new boolean[n+1];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n;i++) {
			sb.append(findDepth(i,0)).append(" ");
			visited = new boolean[n+1];
		}
		System.out.println(sb.toString());
	}
	public static boolean dfs(int cur, int init, int cnt) {
		onCycle[cur] = true;
		if(map[cur].size() == 1) return false;
		for(int i = 0, end = map[cur].size(); i < end; i++) {
			int adj = (int) map[cur].get(i);
			if(adj == init && cnt >= 2) {
				//System.out.println("hit");
				return true;
			}
			if(onCycle[adj]) continue;
			onCycle[adj] = true;
			if(!dfs(adj, init, cnt+1)) {
				onCycle[adj] = false;
			}
			else return true;
		}
		return false;
	}
	public static int findDepth(int cur, int depth) {
		visited[cur] = true;
		//if(map[cur].size() == 1) return 0;
		if(onCycle[cur]) return depth;
		for(int i = 0, end = map[cur].size(); i<end;i++) {
			int adj = (int) map[cur].get(i);
			if(visited[adj]) continue;
			int result =findDepth(adj,depth+1);
			if(result != 0) return result;
		}
		return 0;
	}
}