

import java.util.Scanner;

public class Main {
	static int[][] output;
	static int M,N;
	static int[][] diagram;
	static int numChickens;
	static int numHouses;
	static int[][] chicken;
	static int minDistance = 10000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		diagram = new int[N][N];
		numChickens = 0;
		numHouses = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< N; j++) {
				int temp = sc.nextInt();
				diagram[i][j] = temp;
				if(temp == 1) {
					numHouses++;
				}
				else if(temp == 2) {
					numChickens++;
				}
			}
		}
		//System.out.println(numChickens);
		//System.out.println(numHouses);
		chicken = new int[numChickens][2];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ; j++) {
				if(diagram[i][j] == 2) {
					//System.out.println(idx);
					chicken[idx][0] = i;
					chicken[idx][1] = j;
					idx++;
				}
			}
		}
		
		output = new int[M][2];
		Combination(0,0);
		System.out.println(minDistance);
	}
	
	private static int calculateDistance(int[][] output) {
		int sum = 0;
		int temp = 1000;
		int distance = 0;
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				if(diagram[i][j] == 1) {
					for(int[] kfc: output) {
						distance = Math.abs(kfc[0] - i) + Math.abs(kfc[1] - j);
						temp = Math.min(distance, temp);
					}
					sum += temp;
					temp = 1000;
				}
			}
		}
		return sum;
	}
	
	public static void Combination(int depth, int start) {
		if(depth == M) {
			int result = calculateDistance(output);
			minDistance = Math.min(result, minDistance);
			return;
		}

		for(int i = start; i < numChickens;i++) {
			output[depth] = chicken[i];
			Combination(depth+1,i+1);
		}
	}
}
