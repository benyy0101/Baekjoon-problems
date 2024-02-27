import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int ans_left = 0;
		int ans_right = N-1;
		int sum = Integer.MAX_VALUE;
		while(right> left) {
			int temp = list[right]+ list[left];
			if(Math.abs(temp) <= sum) {
				ans_right = right;
				ans_left = left;
				sum = Math.abs(temp);
				if(sum == 0) break;
			}
			if(temp > 0) right--;
			else left++;
		}
		System.out.println(list[ans_left]+" "+list[ans_right]);
	}
}