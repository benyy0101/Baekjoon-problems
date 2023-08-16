import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][], N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i< N;i++) {
			String st = br.readLine();
			for(int j = 0; j < N;j++) {
				map[i][j] = st.charAt(j) - 48;
			}
		}
		
		System.out.println(zip(0,0,N));
	}
	
	public static String zip(int sr, int sc, int size) {
		if(size == 1) {
			if(map[sr][sc] == 1) return "1";
			else return "0";
		}
		
		int half = size / 2;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("(")
		.append(zip(sr,sc,half))
		.append(zip(sr,sc+half,half))
		.append(zip(sr+half,sc,half))
		.append(zip(sr+half,sc+half,half))
		.append(")");
		
		if(sb.toString().equals("(1111)")) return "1";
		else if(sb.toString().equals("(0000)")) return "0";
		else return sb.toString();
	}
}
