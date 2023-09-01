

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size, inDegree[];
	static boolean map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= testCase ; tc++) {
			size = Integer.parseInt(br.readLine());
			map = new boolean[size+1][size+1];
			st = new StringTokenizer(br.readLine());
			inDegree = new int[size+1];
			
			for(int i = 0 ; i < size;i++) {
				int num = Integer.parseInt(st.nextToken());
				inDegree[num] = i;
				for(int j = 1; j <= size;j++) {
					if(j != num && !map[j][num]) map[num][j] = true;
				}
			}  
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0;i < N;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(map[from][to]) {
					map[from][to] = false;
					map[to][from] = true;
					inDegree[from]++;
					inDegree[to]--;
				}
				else {
					map[to][from] = false;
					map[from][to] = true;
					inDegree[to]++;
					inDegree[from]--;
				}
				
			}
			String answer = topologySort();
			System.out.println(answer);
		}
	}
	
	public static String topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= size; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		
		for (int i = 1; i <= size; i++) {
			if (queue.size() == 0)
				return "IMPOSSIBLE";
			if (queue.size() > 1)
				return "?";
			int cur = queue.poll();
			sb.append(cur + " ");

			for (int j = 1; j <= size; j++) {
				if (map[cur][j]) {
					map[cur][j] = false;
					if (--inDegree[j] == 0)
						queue.offer(j);
				}
			}
		}
		return sb.toString();
	}
}
