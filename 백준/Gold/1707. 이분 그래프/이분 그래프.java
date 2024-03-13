import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int V,E,visited[];
	public static ArrayList<Integer> list[];
	public static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int K = Integer.parseInt(br.readLine());
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점의 수
			E = Integer.parseInt(st.nextToken()); //간선의 수
			
			list = new ArrayList[V+1];
			
			for(int i = 0; i < V+1;i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			visited = new int[V+1];
			flag= true;
			bfs();
			System.out.println(flag ? "YES" : "NO");
		}
		
	}
	public static void bfs() {
		for(int i = 1 ; i < V+1;i++) {
			if(visited[i] != 0) continue;
			visited[i] = 1;
			Queue<Integer> qq = new ArrayDeque<>();
			qq.add(i);
			while(!qq.isEmpty()) {
				int cur = qq.poll();
				//방문하지 않았으면 색칠하기
				for(int next:list[cur]) {
					if(visited[next] == 0) qq.add(next);
					if(visited[next] != 0 && visited[next] == visited[cur]) {
						flag = false;
						return;
					}
					else if(visited[next] == 0 && visited[cur] == 1) {
						visited[next] = 2;
					}
					else if(visited[next] == 0 && visited[cur] == 2) {
						visited[next] = 1;
					}
				}
			}
		}
	}
}