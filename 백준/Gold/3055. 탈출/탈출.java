import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char map[][];
	
	static Point start, end;
	
	static class Point{
		int r; int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		Queue<Point> water = new LinkedList<>();
		
		for(int r=0; r<R; ++r) {
			String str = br.readLine();
			for(int c=0; c<C; ++c) {
				map[r][c] = str.charAt(c);
			
				if(map[r][c]=='*') {
					water.add(new Point(r,c));
					continue;
				}
				
				if(map[r][c]=='S') {
					start = new Point(r,c);
					continue;
				}
				
				if(map[r][c]=='D') {
					end = new Point(r,c);
					continue;
				}
				
			
			}
		}
		
		int time = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		map[start.r][start.c] = 'X';
		
		int size, i, p, nr, nc;
		Point curr;
		while(true) {
			
			size = water.size();
			for(i=0; i<size; ++i) {
				curr = water.poll();
				
				for(p=0; p<4; ++p) {
					nr = curr.r + dr[p];
					nc = curr.c + dc[p];
				
					if(!inRange(nr, nc)) continue;
				
					if(map[nr][nc] == '.') {
						water.add(new Point(nr, nc));
						map[nr][nc] = '*';
					}
				}
			}
			
			size = q.size();
			for(i=0; i<size; ++i) {
				curr = q.poll();
				
				if(curr.r == end.r && curr.c == end.c) {
					System.out.println(time);
					System.exit(0);
				}
				
				for(p=0; p<4; ++p) {
					nr = curr.r + dr[p];
					nc = curr.c + dc[p];
				
					if(!inRange(nr, nc)) continue;
				
					if(map[nr][nc] == '.' || map[nr][nc]=='D') {
						q.add(new Point(nr, nc));
						map[nr][nc] = 'X';
					}
				}
			}
			
			++time;
			if(q.isEmpty()) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			
		}
		

	}
	
	static boolean inRange(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}

}
