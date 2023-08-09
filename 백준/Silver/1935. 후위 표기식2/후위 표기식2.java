
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		String calculation = br.readLine();
		double[] nums = new double[t];
		for(int i = 0; i < t;i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stk = new Stack<Double>();
		long sum = 0;
		for(int i = 0 ; i < calculation.length();i++) {
			if(calculation.charAt(i)>= 65 && calculation.charAt(i) <= 90) {
				int temp = calculation.charAt(i) - 65;
				stk.push(nums[temp]);
			}
			else if(calculation.charAt(i) == '+') {
				double num2 = stk.pop();
				double num1 = stk.pop();
				stk.push(num1+num2);
			}
			else if(calculation.charAt(i) == '-') {
				double num2 = stk.pop();
				double num1 = stk.pop();
				stk.push(num1 - num2);
			}
			else if(calculation.charAt(i) == '*') {
				double num2 = stk.pop();
				double num1 = stk.pop();
				stk.push(num1 * num2);
			}
			else if(calculation.charAt(i) == '/') {
				double num2 = stk.pop();
				double num1 = stk.pop();
				stk.push(num1 / num2);
			}
		}
		System.out.printf("%.2f", stk.peek());
	}
}
