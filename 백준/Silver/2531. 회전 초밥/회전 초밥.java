import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] sushiBelt = new int[N*2];
		int[] onPlate = new int[D+1];
		int answer = 0;
		int result = 0;
		int i;
		for(i = 0 ; i < N;i++) {
			sushiBelt[i] = Integer.parseInt(br.readLine());
		}
		
		for(int k = i;k<2*N;k++) {
			sushiBelt[k] = sushiBelt[k-N];
		}
		
		for(int j = 0; j <K;j++) {
			if(onPlate[sushiBelt[j]] == 0) {
				onPlate[sushiBelt[j]]++;
				answer++;
			}
			else {
				onPlate[sushiBelt[j]]++;
			}
		}
		
		result = answer;
		for(int j = 0; j <N;j++) {
			onPlate[sushiBelt[j]]--;
			if(onPlate[sushiBelt[j]] == 0) answer--;
			onPlate[sushiBelt[K+j]]++;
			if(onPlate[sushiBelt[K+j]] == 1) answer++;
			if(onPlate[C] == 0) result = Math.max(result, answer+1);
			else result = Math.max(result, answer);
			
		}
		System.out.println(result);
	}
}