import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight="
					+ weight + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight , o.weight);
		}
	}
	static Edge[] edgeList;
	static int[] parents;
	static int V,E;
	public static void make() {
		for (int i = 0; i < V+1; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a){
		if(parents[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		// 두 노드의 root가 다르면 합침
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        edgeList = new Edge[E];
        
        for(int i=0; i < E; ++i){
        	st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
  
	        edgeList[i] = new Edge(from ,to, weight);

        }
        make();
        Arrays.sort(edgeList);
        int result = 0;
        int count=0;
        int temp = 0;
	    for(Edge edge : edgeList){
	    	if(union(edge.start,edge.end)){ 
	    		temp = Math.max(temp, edge.weight);
	    		result += edge.weight;
	    		if(++count == V-1){ 
	    			break;
	    		}
	    	}
	    }
        System.out.println(result - temp);
	}
}