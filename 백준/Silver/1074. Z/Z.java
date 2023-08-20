

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N,r,c,cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		find(0,0,(int)Math.pow(2, N));

	}
	static void find(int sr,int sc,int size) {
		
		if(size==1) {
			if(sr==r && sc==c) {
				System.out.println(cnt);
			}
			cnt++;
			return;
		}
		else if(r>sr+size || c>sc+size || c<sc || r<sr) {
			cnt+=size*size;
		}
		else {
			int half=size/2;
			find(sr,sc,half);
			find(sr,sc+half,half);
			find(sr+half,sc,half);
			find(sr+half,sc+half,half);
		}
			
	}
	
}
