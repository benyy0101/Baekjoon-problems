
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M,N,D,output[],map[][], totalEnemy;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		output = new int[3];
		map = new int[N][M];
		for(int i = 0 ; i <N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) totalEnemy++;
			}
		}
		
		combination(0,0);
		System.out.println(answer);
	}
	
	public static void combination(int depth, int start) {
		if(depth == 3) {
			int shots = startGame();
			answer = Math.max(shots, answer);
			//System.out.println(Arrays.toString(output));
			return;
		}
		for(int i=start; i <M ;i++) {
			output[depth] = i;
			combination(depth+1, i+1);
		}
	}
	
	public static int startGame() {
		int killed = 0;
		int [][] newMap = new int[N][M];
		int target[][] = new int[3][2];
		
		for(int i = 0 ; i< N;i++) {
			newMap[i] = Arrays.copyOfRange(map[i], 0, M);
		}
		
		for(int q = 0 ; q<N;q++) {
			for(int p = 0;p <3;p++) {
				int flag = 1;
				int minDist = Integer.MAX_VALUE;
				
				for(int i = N-1 ; i >=0;i--) {
					for(int j = 0; j < M;j++) {
						if(newMap[i][j] == 0) continue;
						int distance = Math.abs(i - N) + Math.abs(j - output[p]);
						if(distance > D) continue;
						if(distance > minDist) continue;
						if(distance == minDist && target[p][1] <j) continue;
						target[p][0] = i;
						target[p][1] = j;
						minDist = distance;
						flag = 0;
					}
				}
				if(flag == 1) {
					target[p][0] = -1;
					target[p][1] = -1;
				}
			}
			
			for(int i = 0; i < 3;i++) {
				if(target[i][0] == -1) continue;
				if(newMap[target[i][0]][target[i][1]] == 0) continue;
				newMap[target[i][0]][target[i][1]] = 0;
				killed ++;
			}
			for(int i = N-1 ; i>0;i--) {
				newMap[i] = newMap[i-1];
			}
			newMap[0] = new int[M];
		}
		return killed;
	}
}
