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
		int min = Integer.MAX_VALUE;
		int minRight = 0;
		int minLeft = 0;
		for(int i = 0 ; i < N;i++) {
			int target = list[i];
			int right = list.length - 1;
			int left = i+1;
			int mid;
			
			while(left <= right) {
				mid = (right - left) / 2 + left;
				int temp =Math.abs(target + list[mid]); 
				if(temp < min ) {
					min = temp;
					minRight = mid;
					minLeft = i;					
				}
				
				if(list[mid] + target < 0) {
					left = mid+1;
				}
				else right = mid-1;
			}
		}
		
		System.out.println(list[minLeft] + " " + list[minRight]);
	}
}