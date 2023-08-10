
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n ,m,matrix[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][m];
		
		for(int i = 0; i <n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] rounds = new int[t];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<t;i++) {
			rounds[i] = Integer.parseInt(st.nextToken());
		}
		int[][] newMatrix;
		for(int j =0; j < t ; j++) {
			if(rounds[j] == 1) {
				newMatrix = transform1();
				matrix = newMatrix;
			}
			else if(rounds[j] == 2) {
				newMatrix = transform2();
				matrix = newMatrix;
			}
			else if(rounds[j] == 3) {
				newMatrix = transform3();
				matrix = newMatrix;
			}
			else if(rounds[j] == 4) {
				newMatrix = transform4();
				matrix = newMatrix;
			}
			else if(rounds[j] == 5) {
				newMatrix = transform5();
				matrix = newMatrix;
			}
			else if(rounds[j] == 6) {
				newMatrix = transform6();
				matrix = newMatrix;
			}
			n = matrix.length;
			m = matrix[0].length;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0 ; i < matrix.length;i++) {
			for(int j = 0 ; j < matrix[0].length;j++) {
				sb.append(matrix[i][j]);
				if(j == matrix[0].length-1) {
					sb.append("\n");
					
				}
				else {
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
	
	public static int[][] transform1() {
		int[][] temp = new int[n][m];
		for(int i = 0; i< n;i++) {
			for(int j = 0; j < m ;j++) {
				temp[n-1-i][j] = matrix[i][j];
			}
		}
		
		return temp;
	}
	
	public static int[][] transform2() {
		int[][] temp = new int[n][m];
		for(int i = 0; i< n;i++) {
			for(int j = 0; j < m ;j++) {
				temp[i][m-1-j] = matrix[i][j];
			}
		}
		
		return temp;
	}
	public static int[][] transform3() {
		int[][] temp = new int[m][n];
		for(int i = 0; i< m;i++) {
			for(int j = 0; j < n ;j++) {
				temp[i][j] = matrix[n-1-j][i];
			}
		}
		
		return temp;
	}
	
	public static int[][] transform4(){
		int[][] temp = new int[m][n];
		for(int i = 0; i< m;i++) {
			for(int j = 0; j < n ;j++) {
				temp[i][j] = matrix[j][m-1-i];
			}
		}
		
		return temp;
	}
	
	public static int[][] transform5(){
		int[][] temp = new int[n][m];
		for(int i = 0; i< n / 2;i++) {
			for(int j = 0 ; j <m /2 ; j++) {
				temp[i][j+(int)(Math.ceil(m/2))]=matrix[i][j];
				temp[i+(int)(Math.ceil(n/2))][j+(int)(Math.ceil(m/2))]= matrix[i][j+(int)(Math.ceil(m/2))];
				temp[i+(int)(Math.ceil(n/2))][j]= matrix[i+(int)(Math.ceil(n/2))][j+(int)(Math.ceil(m/2))];
				temp[i][j]=matrix[i+(int)(Math.ceil(n/2))][j];
			}
		}
		return temp;
	}
	
	public static int[][] transform6(){
		int[][] temp = new int[n][m];
		for(int i = 0; i< n / 2;i++) {
			for(int j = 0 ; j <m /2 ; j++) {
				temp[i][j]=matrix[i][j+(int)(Math.ceil(m/2))];
				temp[i][j+(int)(Math.ceil(m/2))]= matrix[i+(int)(Math.ceil(n/2))][j+(int)(Math.ceil(m/2))];
				temp[i+(int)(Math.ceil(n/2))][j+(int)(Math.ceil(m/2))]= matrix[i+(int)(Math.ceil(n/2))][j];
				temp[i+(int)(Math.ceil(n/2))][j]=matrix[i][j];
			}
		}
		
		return temp;
	}

}
