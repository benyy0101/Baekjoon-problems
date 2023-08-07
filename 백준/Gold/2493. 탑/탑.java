
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		int[] target = new int[t];
		int[] result = new int[t];
		
		st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stk1 = new Stack<Integer>();
		Stack<Integer> stk2 = new Stack<Integer>();
		
		for(int i = 0; i < t ;i++) {
			int temp = Integer.parseInt(st.nextToken());
			while(stk1.size()!=0 && stk1.peek() < temp) {
				stk1.pop();
				stk2.pop();
			}
			if(stk2.size() == 0) {
				result[i] = 0;
			}
			else {
				result[i] = stk2.peek();
			}
			stk1.push(temp);
			stk2.push(i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i:result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
