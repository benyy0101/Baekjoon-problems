
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.StringTokenizer;

public class Main{

	static int[][] direction = new int[][] {

		{0,1},

		{1,0},

		{0,-1},

		{-1,0}

	};											//방향 벡터: 우하좌상 순으로

	static int N,M,K,map[][],output[], minSum, moves[][];

	static boolean v[];

	public static void main(String[] args) throws IOException {

		minSum = Integer.MAX_VALUE;				//최종 최솟값

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//N: x좌표
		M = Integer.parseInt(st.nextToken());	//M: y좌표
		K = Integer.parseInt(st.nextToken());	//K: layer

		map = new int[N][M];					//2차원 배열
		moves = new int[K][3];					//돌리기 연산을 2차원 배열에 저장
		output = new int[K];					//연산의 permutation

		v = new boolean[K];						//isVisited

		for(int i = 0; i< N ;i++) {

			st = new StringTokenizer(br.readLine());

			for(int j = 0 ; j <M;j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		//돌리기 연산을 moves에 저장
		for(int i = 0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			moves[i][0] = Integer.parseInt(st.nextToken()) - 1;
			moves[i][1] = Integer.parseInt(st.nextToken()) - 1;
			moves[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0);

		System.out.println(minSum);
	}


	public static void permutation(int cnt) {
		
		//수열이 완성될때
		if(cnt == K) {

			int[][] tempMap = new int[N][M];
			
			//새로운 맵을 만들어서 돌리기
			for(int i = 0; i <N;i++) {

				tempMap[i] = Arrays.copyOf(map[i], map[i].length);

			}

			for(int q:output) {
				//System.out.println(q);
				int x = moves[q][0];
				int y = moves[q][1];
				int depth = moves[q][2];
				
				//가장 바깥 레이어부터 돌리기
				while(depth>0) {
					
					//가장 인덱스가 작은 값부터 옮기기 시작
					int nx = x - depth;
					int ny = y - depth;
					int idx = 0;
					int temp1 = tempMap[nx][ny];
					for(int f = 0; f < 4;f++) {
						//한 레이어가 한 방향으로 바꾸는 숫자를 옮기는 횟수는 레이어 크기의 두배 
						for(int v = 0; v<depth*2;v++) {
							//옮겨가는 숫자가 있는 곳에 있는 숫자를 임시저장
							int temp = tempMap[nx + direction[idx][0]][ny+direction[idx][1]];
							tempMap[nx + direction[idx][0]][ny+direction[idx][1]] = temp1;
							temp1 = temp;
							nx += direction[idx][0];
							ny += direction[idx][1];
						}
						//한 방향으로 이동이 끝나면 idx를 올려서 방향 전환
						idx++;
					}
					depth--;
				}

//				for(int i = 0; i < N;i++) {
//
//					System.out.println(Arrays.toString(tempMap[i]));
//
//				}
//
//				System.out.println();

			}
			//배열 돌리기가 끝나면 최솟값 저장
			for(int i = 0; i < N; i++) {
				minSum = Math.min(minSum, Arrays.stream(tempMap[i]).sum());
				//System.out.println(Arrays.stream(tempMap[i]).sum());
			}
			return;
		}
		
		//permutation
		for(int i = 0; i < K;i++) {
			if(v[i]) continue;
			v[i] = true;
			output[cnt] = i;
			permutation(cnt+1);
			v[i] = false;
		}
	}
}