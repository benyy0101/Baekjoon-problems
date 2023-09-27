import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> blanks = new ArrayList();
	static boolean flag;
	static int[][] sudoku;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		flag = false;
		String ss;
		for(int i = 0 ; i < 9;i++) {
			ss = br.readLine();
			for(int j = 0 ; j < 9 ;j++) {
				sudoku[i][j] = ss.charAt(j) - '0';
				
				if(sudoku[i][j] == 0) blanks.add(new int[] {i,j});
			}
		}
		play(0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 9;i++) {
			for(int j = 0 ; j<9;j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void play(int idx) {
		if(idx == blanks.size()) {
			flag = true;
			return;
		} 
		int[] cur = blanks.get(idx);
		for(int i = 1 ; i <= 9; i++) {
			int x = cur[0];
			int y = cur[1];
			sudoku[x][y] = i;
			if(checkBox(x,y) && checkHrzntl(x, y) && checkVrtcl(x, y)) {
				play(idx+1);
			}
			if(flag) return;
			sudoku[x][y] = 0;
		}
	}
	
	public static boolean checkBox(int x, int y) {
		int dx = (x / 3) * 3;
		int dy = (y / 3) * 3;
		
		for(int i = 0; i < 3;i++) {
			for(int j = 0; j < 3; j++) {
				if(x == dx + i && y == dy + j) continue;
				if(sudoku[dx + i][dy + j] == sudoku[x][y]) return false;
			}
		}
		return true;
	}
	
	public static boolean checkHrzntl(int x, int y) {
		for(int i = 0; i < 9 ; i++) {
			if(i == y) continue;
			if(sudoku[x][y] == sudoku[x][i]) return false;
		}
		return true;
	}
	public static boolean checkVrtcl(int x, int y) {
		for(int i = 0; i < 9 ; i++) {
			if(i == x) continue;
			if(sudoku[x][y] == sudoku[i][y]) return false;
		}
		return true;
	}
}