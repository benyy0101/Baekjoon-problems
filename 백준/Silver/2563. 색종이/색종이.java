
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean[][] map = new boolean[101][101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int count=0;
		
		for(int i = 0 ; i < t;i++) {
			st = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			for(int k = 0; k<10;k++) {
				for(int j = 0 ; j < 10;j++) {
					map[startX+k][startY+j] = true;
				}
			}
			
		}
		
		for(int k = 1; k< 101; k++) {
			for(int j = 1 ; j < 101;j++) {
				if(map[k][j] == true) count++;
			}
		}
		System.out.println(count);
	}
}
