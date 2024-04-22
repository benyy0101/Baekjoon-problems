import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] leaf;
	static ArrayList<Integer>[] tree;
	static int result, banned;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		
		for(int i =0; i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root=0;
		for(int i = 0; i < N;i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			if(temp == -1) root = i; 
			else tree[temp].add(i);
		}
		banned = Integer.parseInt(br.readLine());
		if(banned == root) System.out.println(0);
		else {
			dfs(root);
			System.out.println(result);
		}
	}
	
	public static void dfs(int node) {
		if(tree[node].size() == 0 || (tree[node].size()== 1 && tree[node].get(0) == banned)) {
			result++;
			return;
		}
		for(int next: tree[node]) {
			if(next == banned) continue;
			dfs(next);
		}
	}
}