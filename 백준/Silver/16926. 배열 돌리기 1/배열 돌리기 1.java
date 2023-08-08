import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int minLoop = Math.min(m, n)/2;
		int[][] diagram = new int[n][m];
		int[][] newDiagram = new int[n][m];
		
		for(int i = 0 ;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <m ; j++) {
				diagram[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] direction = {
				{1,0},
				{0,1},
				{-1,0},
				{0,-1}
		};
		for(int k =0; k < minLoop;k++) {
			for(int i = 0; i <t;i++) {
				int x = k;
				int y = k;
				int idx = 0;
				int temp = diagram[x][y];
				int temp2;
				while(true) {
					int dx = direction[idx][0] + x;
					int dy = direction[idx][1] + y;
					if(dx < 0+k || dx >= (n-k) || dy < 0+k ||dy >= (m-k)) {
						idx++;
						if(idx == 4) {
							break;
						}
					}
					dx = direction[idx][0] + x;
					dy = direction[idx][1] + y;
					temp2 = diagram[dx][dy];
					diagram[dx][dy] = temp;
					temp = temp2;
					x = dx;
					y = dy;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i <n;i++) {
			for(int j = 0; j <m;j++) {
				sb.append(diagram[i][j]);
				if(j == m-1) {
					sb.append("\n");
				}
				else {
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}
