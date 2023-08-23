import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
    int x;
    int y;
    int s;
    int d;
    int size;

    public Shark(int x, int y, int s, int d, int size){
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
        this.size = size;
    }
}

public class Main {
	static int R,C,M;
    static Shark[][] map;
    static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new Shark[R+1][C+1];
	    
	    for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r,c,s,d,z);
        }
	    
	    for(int i=1;i<=C;i++){
            for(int j=1;j<=R;j++){
                if(map[j][i] != null){
                    answer += map[j][i].size;
                    map[j][i] = null;
                    break;
                }
            }
            moveSharks();
        }

        System.out.println(answer);
	}
	
	static void moveSharks(){

        Queue<Shark> sharks = new LinkedList<>();
        for(int i=1;i<=R;i++) {
            for (int j = 1; j <= C; j++) {
                if(map[i][j] != null) sharks.add(map[i][j]);
            }
        }

        map = new Shark[R+1][C+1];

        while(!sharks.isEmpty()){
            Shark shark = sharks.poll();

            int speed = shark.s;
            if(shark.d == 1 || shark.d == 2) speed %= (R-1)*2;
            else speed %= (C-1)*2;

            while(speed-- > 0){
            	if(shark.d == 1) {
            		if(shark.x==1){
                        shark.d=2;
                        shark.x++;
                    }
                    else shark.x--;
                    
            	}
            	else if(shark.d == 2) {
            		if(shark.x==R){
                        shark.d=1;
                        shark.x--;
                    }
                    else shark.x++;
                    
            	}
            	else if(shark.d == 3) {
            		if(shark.y==C){
                        shark.d=4;
                        shark.y--;
                    }
                    else shark.y++;
                    
            	}
            	else {
            		if(shark.y==1){
                        shark.d=3;
                        shark.y++;
                    }
                    else shark.y--;
            	}
            }
            if(map[shark.x][shark.y] != null){
                if(map[shark.x][shark.y].size < shark.size) map[shark.x][shark.y] = shark;
            }
            else map[shark.x][shark.y] = shark;
        }
    }
}
