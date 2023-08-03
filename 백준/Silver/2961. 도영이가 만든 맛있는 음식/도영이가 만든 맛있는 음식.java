import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] ingredients; 
	static boolean[] isSelected;
	static int T;
	static int minTaste = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		ingredients = new int[T][2];
		isSelected = new boolean[T];
		for(int i = 0 ; i < T ; i++) {
			ingredients[i][0] = sc.nextInt();
			ingredients[i][1] = sc.nextInt();
		}
		
		generateSubset(0);
		System.out.println(minTaste);
	}
	
	private static void generateSubset(int depth) {
		if(depth == T) {
			//System.out.println(Arrays.toString(isSelected));
			int sourScore = 1;
			int bitterScore = 0;
			boolean temp = true;
			for(int i = 0; i < T ; i++) {
				if(isSelected[i] == true) {
					sourScore *= ingredients[i][0];
					bitterScore += ingredients[i][1];
					temp = false;
				}
			}
			if(temp == false) {
				int tempScore = Math.abs(sourScore - bitterScore);
				minTaste = Math.min(minTaste, tempScore);
			}

			return;
		}
		
		isSelected[depth] = true;
		generateSubset(depth+1);
		// 부분집합에 현재 원소를 비선택
		isSelected[depth] = false;
		generateSubset(depth+1);
	}
}
