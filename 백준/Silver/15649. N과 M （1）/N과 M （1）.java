

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] nums;
	static int depth;
	static int length;
	static boolean[] visited;
	public static void permute(int i) {
		if(i == depth) {
			StringBuilder sb = new StringBuilder();
			
			for(int item: nums) {
				sb.append(item);
				sb.append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int j = 1; j <= length; j++) {
			if(visited[j] == true) continue;
			nums[i] = j;
			visited[j] = true;
			permute(i + 1);
			visited[j] = false;
		}
	}
	
	public static void permute(int i, int flag) {
		if(i == depth) {
			StringBuilder sb = new StringBuilder();
			
			for(int item: nums) {
				sb.append(item);
				sb.append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int j = 0; j < length; j++) {
			if((flag & 1 << j) != 0) continue;
			nums[i] = j + 1;
			permute(i+1, flag | 1<<j);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		depth = sc.nextInt();
		nums = new int[depth];
		visited = new boolean[length+1];
		
		permute(0);
	}
}
