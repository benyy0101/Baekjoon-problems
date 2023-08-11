
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	//방향 벡터
	static int[][] direction = new int[][]{
		{1,0},
		{0,1},
		{-1,0},
		{0,-1}
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		int idx = 1;													//문제 번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int T = Integer.parseInt(br.readLine());					//map의 사이즈
			if(T == 0) break;											//0: while 종료 조건
			int [][] map = new int[T][T];								//cost를 담는 배열
			int[][] result = new int[T][T];								//최소 누적 cost를 담는 배열
			
			StringTokenizer st;
			
			for(int i = 0 ;  i < T; i++){
				st = new StringTokenizer(br.readLine());
				for(int j= 0 ; j <T;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE;					//최솟값을 저장하기 위해 가장 큰 값으로 초기화
				}
			}
			
			//방문할 노드를 관리할 우선순위 큐
			PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->(p1[2] - p2[2]));	//cost순으로 오름차순 정렬
			pq.offer(new int[] {0,0,map[0][0]});
			
			//탐색 시작
			while(!pq.isEmpty()) {
				int[] state = pq.poll();
				for(int i = 0; i < 4; i++) {
					int dx = state[0] + direction[i][0];
					int dy = state[1] + direction[i][1];
					
					//가능한 움직임인지 검증: result에서 최솟값이 갱신이 가능한 경우만 진행
					if(dx<0 || dx >=T || dy < 0 || dy>=T ||result[dx][dy] <= state[2] + map[dx][dy]) continue;

					result[dx][dy] = state[2] + map[dx][dy];
					pq.offer(new int[] {dx,dy,result[dx][dy]});
				}
			}

			System.out.println("Problem " +(idx++)+": "+result[T-1][T-1]);
		}
	}
}
