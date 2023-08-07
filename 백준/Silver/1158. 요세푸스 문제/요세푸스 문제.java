import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> result = new ArrayList();
		
		Deque<Integer> target = new ArrayDeque<>();
		
		for(int i  = 0 ; i < K;i++) {
			target.add(i+1);
		}
		
		while(target.size() != 0) {
			for(int i = 0; i <N;i++) {
				int temp = target.pollFirst();
				if(i == N-1) {
					result.add(temp);
				}
				else {
					target.addLast(temp);	
				}
			}
		}
		//System.out.println(result.toString());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < K;i++) {
			sb.append(result.get(i));
			if(i != K-1) {
				sb.append(",").append(" ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
