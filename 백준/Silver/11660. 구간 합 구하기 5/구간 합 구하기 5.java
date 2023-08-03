
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken()); // 배열 크기
		int t = Integer.parseInt(st.nextToken()); // 합 좌표 수
		
		int[][] map = new int[size+1][size+1];
		int[][] sumMap = new int[size+1][size+1];
		
		for(int i =1; i<= size ; i ++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = 0;
			for(int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= size ; i ++) {
			for(int j = 1; j <= size; j++) {
				sumMap[i][j] = map[i][j] + sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1]; 
			}
		}
		
		
		
//		for(int i = 0; i <=size; i++) {
//			System.out.println(Arrays.toString(sumMap[i]));;
//		}
		
		for(int i = 0; i < t;i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int sum = sumMap[endX][endY] - sumMap[startX - 1][endY] - sumMap[endX][startY - 1] +sumMap[startX - 1][startY - 1];
			
			System.out.println(sum);
		}
	}
}
