import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0 ; i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ;i++) {
			int target = Integer.parseInt(st.nextToken());
			int right = arr.length - 1;
			int left = 0;
			int mid;
			int result = 0;
			while(left <= right) {
				mid = (left + right) / 2;
				if(arr[mid] < target) {
					left = mid + 1;
				}
				else if(arr[mid] > target) {
					right = mid - 1;
				}
				else {
					result = 1;
					break;
				}	
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}