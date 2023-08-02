
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int N = 9;
	static int[] dwarfs = new int[N];
	static int[] target = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i< N ; i++) {
			dwarfs[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(dwarfs));
		combination(0,0);
	}
	
	public static void combination(int depth, int start) {
		if(depth == 7) {
			int sum = 0;
			for(int item:target) {
				sum += item;
			}
			//System.out.println(sum);
			if(sum == 100) {
				for(int item:target) {
					System.out.println(item);
				}
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			target[depth] = dwarfs[i];
			combination(depth+1, i+1);
		}
	}
}
