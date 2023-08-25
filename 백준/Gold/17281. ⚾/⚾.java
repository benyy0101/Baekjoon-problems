import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int maxPoint;
	static int[][] innings;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		innings = new int[N][9];
		int[] idx = {1,2,3,4,5,6,7,8};
		int[] ace = {0};
 		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9;j++) {
				innings[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		do {
			int[] temp = new int[9];
			for(int i = 0; i < 3;i++) {
				temp[i] = idx[i];
			}
			temp[3] = ace[0];
			for(int i = 4;i<9;i++) {
				temp[i] = idx[i-1];
			}
			//int[] test = {3, 8, 7, 6, 5, 4, 2, 1, 0};
			//int point = playGame(test);
			int point = playGame(temp);
			maxPoint = Math.max(point, maxPoint);
			//if(point == 48) {System.out.println(Arrays.toString(temp));}
			
		}
		while(np(idx));
		System.out.println(maxPoint);
	}
	private static boolean np(int[] p) { // p : 다음 순열을 원하는 기존 순열의 배열
		// 1. 맨뒤쪽부터 탐색하며 꼭대기 찾기
		int N = p.length;
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		
		if(i==0) return false; // 다음 순열을 없음(가장 큰 순열의 형태)
		
		//2. 꼭대기 직전(i-1)위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		//3. 꼭대기 직전(i-1)위치의 수와 한단계 큰 수를 교환하기
		swap(p,i-1,j);
		
		//4. 꼭대기자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
	
	private static int playGame(int[] order) {
		int point = 0;
		int j = 0;
		for(int i = 0; i < N ;i++) {
			int out = 0;
			boolean[] base = new boolean[4];
			while(out <3) {
				int num = order[j];
				int hit = innings[i][num];
				j = (j+1) % 9;
				base[0] = true;
				if(hit == 4) {
					for(int k = 3 ; k >=0;k--) {
						if(base[k]) {
							point++;
							base[k] = false;
						}  
					}
					
				}
				else if(hit == 3) {
					for(int k = 3 ; k >=0;k--) {
						if(base[k] && k+3 <4) {
							base[k] = false;
							base[k+3] = true;
						}
						else if(base[k] && k+3>=4){
							base[k] = false;
							point++;
						}
					}
				}
				else if(hit == 2) {
					for(int k = 3 ; k>=0;k--) {
						if(base[k] && k+2 <4) {
							base[k] = false;
							base[k+2] = true;
						}
						else if(base[k] && k+2>=4){
							base[k] = false;
							point++;
						}
					}
				}
				else if(hit == 1) {
					for(int k = 3 ; k >=0;k--) {
						if(base[k] && k+1 <4) {
							base[k] = false;
							base[k+1] = true;
						}
						else if(base[k] && k+1>=4){
							base[k] = false;
							point++;
						}
					}
				}
				else {
					out++;
				}
			}
		}
		return point;
	}
}