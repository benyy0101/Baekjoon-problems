import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int minDrink, finalLeft, finalRight, output[], drinks[],total;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		total = Integer.parseInt(br.readLine());
		minDrink = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		output = new int[2];
		drinks = new int[total];
		
		for(int i = 0 ; i < total;i++) {
			drinks[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(drinks);
		
		int left = 0;
		int right = total-1;
		
		while(left < right) {
			int sum = drinks[left] + drinks[right];
			int temp = Math.abs(sum);
			if(temp < minDrink) {
				minDrink = temp;
				finalLeft = drinks[left];
				finalRight = drinks[right];
			}
			
			if(sum > 0) right--;
			else left++;
			//if(minDrink == 0) break;
		}
		
		//combination(0,0);
		System.out.println(finalLeft +" " + finalRight);
	}
	
//	public static void combination(int depth,int start) {
//		if(depth == 2) {
//			//System.out.println(Arrays.toString(output));
//			int sum = Math.abs(drinks[output[0]] + drinks[output[1]]);
//			if(minDrink > sum) {
//				minDrink = sum;
//				finalLeft = output[0];
//				finalRight = output[1];
//			}
//			return;
//		}
//		for(int i = start; i< total;i++) {
//			output[depth] = i;
//			combination(depth+1,i+1);
//		}
//	}
}
