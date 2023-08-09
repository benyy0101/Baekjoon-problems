
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int priority(char target) {
		if(target == '(') return 0;
		else if(target == '+' || target == '-') return 1;
		else return 2;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String target = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		
		for(int i = 0 ; i < target.length();i++) {
			char temp = target.charAt(i);
			if(temp>= 65 && temp <=90) {
				sb.append(temp);
			}
			else if(temp == '(') {
				stk.push(temp);
			}
			else if(temp == ')') {
				while(!stk.isEmpty()) {
					char tt = stk.pop();
					if(tt == '(') {
						break;
					}
					else {
						sb.append(tt);
					}
				}
			}
			else {
				while(!stk.isEmpty() && priority(stk.peek()) >= priority(temp)) {
					sb.append(stk.pop());
				}
				stk.push(temp);
			}
		}
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		System.out.println(sb);
	}
}
