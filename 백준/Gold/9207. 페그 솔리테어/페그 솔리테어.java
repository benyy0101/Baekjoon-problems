import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int direction[][] = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    }, pins, moves, remainings;
    static char map[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < N;t++){
            map = new char[5][9];
            pins = 0;
            moves = 0;
            
            for(int i = 0 ; i < 5;i++){
                String st = br.readLine();
                for(int j = 0 ; j < 9;j++){
                    map[i][j] = st.charAt(j);
                    if(map[i][j] == 'o') pins++;
                }
            }
            remainings = pins;
            for(int i = 0 ; i < 5;i++){
                for(int j = 0 ; j < 9 ;j++){
                    if(map[i][j] == 'o') dfs(0,new int[] {i,j}, pins);
                }
            }
            System.out.println(remainings + " " + moves);
            if(t != N -1) br.readLine();
        }
    }

    public static void dfs(int depth, int[] cur, int pinCount){
        if(pinCount < remainings){
            remainings = pinCount;
            moves = depth;
        }

        for(int[] dir: direction){
            int nx = cur[0] + dir[0];
            int ny = cur[1] + dir[1];

            if(nx<0 || nx >= 5 || ny < 0 || ny >=9) continue;
            if(map[nx][ny] == 'o') {
                int nxx = nx + dir[0];
                int nyy = ny + dir[1];
    
                if(nxx <0 || nxx >= 5 || nyy < 0 || nyy >= 9 ) continue;
                if(map[nxx][nyy] == '.'){
                    map[cur[0]][cur[1]] = '.';
                    map[nx][ny] = '.';
                    map[nxx][nyy] = 'o';
                
                    for(int i = 0 ; i < 5 ;i++){
                        for(int j = 0 ; j < 9;j++){
                            if(map[i][j] == 'o') dfs(depth+1, new int[] {i,j}, pinCount -1);
                        }
                    }
    
                    map[cur[0]][cur[1]] = 'o';
                    map[nx][ny] = 'o';
                    map[nxx][nyy] = '.';
                }
                
            }
        }
    }
}