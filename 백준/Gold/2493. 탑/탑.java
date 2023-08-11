
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stkTower = new Stack<Integer>();
		Stack<Integer> stkIdx = new Stack<Integer>();
		int[] tower,result;
		StringTokenizer st;
		StringBuilder sb;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		tower = new int[T];
		result = new int[T];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < T; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < T ; i++) {
			int target = tower[i];
			while(!stkTower.isEmpty() && stkTower.peek() < target) {
				stkTower.pop();
				stkIdx.pop();
			}
			
			result[i] = (stkTower.isEmpty()) ? 0: stkIdx.peek();
			stkTower.push(target);
			stkIdx.push(i+1);
		}
		sb = new StringBuilder();
		for(int i: result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
