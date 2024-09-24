import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		v = new boolean[N];
		
		dfs(0);
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i:arr) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i = 0 ; i < N;i++) {
			if(v[i]) continue;
			v[i] = true;
			arr[depth] = i+1;
			dfs(depth+1);
			v[i] = false;
		}
	}
}