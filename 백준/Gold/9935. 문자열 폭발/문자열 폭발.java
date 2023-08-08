import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stk = new Stack<>();
		
		for(int i = 0 ; i < target.length();i++) {
			stk.push(target.charAt(i));
			if(stk.size() >= bomb.length()) {
				boolean triggered = false;
				int idx = stk.size() - bomb.length();
				for(int j = 0 ; j<bomb.length();j++) {
					if(stk.get(idx+j) != bomb.charAt(j)) {
						triggered = true;
						break;
					}
				}
				if(!triggered) {
					for(int j = 0; j<bomb.length() ; j++) {
						stk.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int j = 0 ; j < stk.size(); j++) {
			sb.append(stk.get(j));
		}
		System.out.println((sb.length() !=0) ? sb.toString(): "FRULA");
	}
}
