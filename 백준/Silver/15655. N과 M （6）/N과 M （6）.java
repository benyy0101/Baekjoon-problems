import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, newArr;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		arr = new int [N];
		newArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(arr);
		v = new boolean[N];
		sb = new StringBuilder();
		dfs(0,0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == M) {
			for(int i:newArr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start ; i < N;i++) {
			if(v[i]) continue;
			v[i] = true;
			newArr[depth] = arr[i];
			dfs(depth+1, i+1);
			v[i] = false;
		}
	}
}