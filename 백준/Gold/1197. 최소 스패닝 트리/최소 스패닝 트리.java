import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int to;
	int weight;
	
	public Node (int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node node) {
		return weight - node.weight;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] list = new ArrayList[V+1];
		for(int i = 0 ; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0 ; i <E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
			list[to].add(new Node(from, weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int sum = 0;
		boolean[] v = new boolean[V+1];
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(v[cur.to]) continue;
			v[cur.to] = true;
			sum += cur.weight;
			for(Node next: list[cur.to]) {
				if(v[next.to]) continue;
				pq.add(next);
			}
		}
		System.out.println(sum);
	}
}