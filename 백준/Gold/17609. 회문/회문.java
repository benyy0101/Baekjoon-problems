import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int left, right, flag;
	public static char[] target;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ;i++) {
			target = br.readLine().toCharArray();
			left = 0;
			right = target.length - 1;
			flag = 0;
			if(check(left, right,true)) flag = 0;
			else if(check(left+1,right, false) || check(left, right-1, false)) flag = 1;
			else flag = 2;
			System.out.println(flag);
		}
	}
	
	public static boolean check(int start, int end, boolean init) {
		while(start <= end) {
			if(target[start] == target[end]) {
				start++;
				end--;
			}
			else {
				if(init) {
					left = start;
					right = end;
				}
				return false;
			}
		}
		return true;
	}
}