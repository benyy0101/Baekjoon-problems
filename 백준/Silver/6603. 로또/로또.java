import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N,list[],nums[];
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			String ss = br.readLine();
			if(ss.equals("0")) break;
			st = new StringTokenizer(ss);
			N = Integer.parseInt(st.nextToken());
			list = new int[N];
			nums = new int[6];
			for(int i = 0; i < N;i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			System.out.println();
		}
	}
	
	public static void comb(int depth, int start) {
		if(depth == 6) {
			sb = new StringBuilder();
			for(int i = 0 ; i < 6;i++) sb.append(nums[i]).append(" ");
			System.out.println(sb);
			return; 
		}
		
		for(int i = start; i< N;i++) {
			nums[depth] = list[i];
			comb(depth+1, i+1);
		}
	}
}