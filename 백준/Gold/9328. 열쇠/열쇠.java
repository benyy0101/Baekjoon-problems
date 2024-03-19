import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] dir = {
				{1,0},
				{0,1},
				{-1,0},
				{0,-1}
		};
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H+2][W+2];
			for(int i = 0; i < H+2;i++) Arrays.fill(map[i], '.');
			
			for(int i = 0 ; i < H;i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j = 0 ; j < W;j++) {
					map[i+1][j+1] = temp[j];
				}
			}
			
			Queue<int[]> qq = new ArrayDeque<>();
			
			boolean[][] v = new boolean[H+2][W+2];
			HashSet<Character> keys = new HashSet<>();
			ArrayList<Integer> docs = new ArrayList<>();
			char[] keyList = br.readLine().toCharArray();
			if(keyList[0] != '0') {
				for(int i = 0; i < keyList.length; i++) {
					keys.add(keyList[i]);
				}
			}
			int answer = 0;
			qq.add(new int[] {0,0});
			while(!qq.isEmpty()) {
				int[] cur = qq.poll();
				v[cur[0]][cur[1]] = true;
				for(int i = 0 ; i < 4;i++) {
					int dx = cur[0] + dir[i][0];
					int dy = cur[1] + dir[i][1];
					if(dx < 0 || dx >= (H + 2) || dy < 0 || dy >= (W + 2) || v[dx][dy] || map[dx][dy] == '*') continue;
					if(map[dx][dy] >= 'A' && map[dx][dy] <= 'Z') {
						
						boolean flag = true;
						for(char k:keys) {
							if((k - 'a') == (map[dx][dy] - 'A')) {
								flag=false;
								break;
							}
						}
						//System.out.println(flag);
						if(flag) continue;
					}
					else if(map[dx][dy] >= 'a' && map[dx][dy] <= 'z' && !keys.contains(map[dx][dy])) {
						//System.out.println(dx + dy);
						keys.add(map[dx][dy]);
						v = new boolean[H+2][W+2];
					}
					else if(map[dx][dy] == '$' && !docs.contains(dx*W+dy)) {
						answer++;
						docs.add(dx*W+dy);
					}
					v[dx][dy] = true;
					qq.add(new int[] {dx,dy});
				}
			}
			System.out.println(answer);
		}
	}
}