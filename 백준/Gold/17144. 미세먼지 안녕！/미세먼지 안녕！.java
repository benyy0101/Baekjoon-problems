import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Dust{
	int val;
	int x;
	int y;
	public Dust(int val, int x, int y) {
		super();
		this.val = val;
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Dust [val=" + val + ", x=" + x + ", y=" + y + "]";
	}
	
	
}

public class Main {
	static int[][] direction = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		ArrayList<Integer> puri = new ArrayList<>();
		ArrayList<Dust> list = new ArrayList<>();
		
		for(int i = 0 ; i < R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C;j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == -1) puri.add(i);
				if(val==0 || val == -1) continue;
				list.add(new Dust(val, i, j));
				
			}
		}
		while(T-->0) {
			map[puri.get(0)][0] = -1;
			map[puri.get(1)][0] = -1;
			//먼지 뿌리기
			for(Dust node: list) {
				int sum=0;
				for(int[] dir:direction) {
					int dx = node.x + dir[0];
					int dy = node.y + dir[1];
					
					if(dx < 0 || dx >= R || dy <0 || dy >= C || map[dx][dy] == -1) continue;
					map[dx][dy] += node.val/5;
					sum += node.val/5;
				}
				map[node.x][node.y] += (node.val - sum);
			}
			
			//공기청정기 돌리기
			int up = puri.get(0);
			int down = puri.get(1);
			int y = 1;
			int i = 0;
			int j = 0;
			int temp=0;
			int before = map[up][y];
			
			int[][] direction_upward= {
					{0,1},
					{-1,0},
					{0,-1},
					{1,0}
			};
			int[][] direction_downward= {
					{0,1},
					{1,0},
					{0,-1},
					{-1,0}
			};
			map[up][y] = 0;
			while(up != puri.get(0) || y != 0) {
				int dx = up + direction_upward[i][0];
				int dy = y + direction_upward[i][1];
				if(dx < 0 || dx >= R || dy <0 || dy >= C) {
					i++;
					dx = up + direction_upward[i][0];
					dy = y + direction_upward[i][1];
				}
				temp = map[dx][dy];
				if(temp == -1) break;
				map[dx][dy] = before;
				before = temp;
				up = dx;
				y = dy;
			}
			y=1;
			before = map[down][y];
			map[down][y] = 0;
			while(down != puri.get(1) || y != 0) {
				int dx = down + direction_downward[j][0];
				int dy = y + direction_downward[j][1];
				if(dx < 0 || dx >= R || dy <0 || dy >= C) {
					j++;
					dx = down + direction_downward[j][0];
					dy = y + direction_downward[j][1];
				} 
				temp = map[dx][dy];
				if(temp == -1) break;
				map[dx][dy] = before;
				before = temp;
				down = dx;
				y = dy;
			}
			list = new ArrayList<>();
			for(int a = 0; a < R;a++) {
				for(int b = 0; b<C;b++) {
					if(map[a][b] > 0) list.add(new Dust(map[a][b],a,b));
				}
			}
			map = new int[R][C];
		}
		int answer = 0;
		for(Dust node: list) {
			answer += node.val;
		}
		System.out.println(answer);
	}
}