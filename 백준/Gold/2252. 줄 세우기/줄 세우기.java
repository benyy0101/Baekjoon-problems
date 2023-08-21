import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] inDegree;
	static int N;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		inDegree = new int[N+1];
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i< M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			inDegree[to]++;
		}
		
		System.out.println(bfs());
	}
	
	public static String bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <=N; ++i) {
			if(inDegree[i]==0) queue.offer(i);
		}
		 
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			
			for(int next: list[cur]) {
				if(--inDegree[next]==0) queue.offer(next);
			}
		}
		return sb.toString();
	}
}