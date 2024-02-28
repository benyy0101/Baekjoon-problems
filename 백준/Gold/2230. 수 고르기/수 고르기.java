import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		for(int i = 0 ; i < N;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(list);
		int answer = Integer.MAX_VALUE;
		int left = 0; 
		int right = 0;
		while(right < N) {
			int temp = list[right] - list[left]; 
			if(temp >= M && temp < answer) {
				answer = temp;
			}
			if(temp == M) break;
			if(temp <= M) right++;
			else left++;
		}
		System.out.println(answer);
	}
}