import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] map = new int[N+1][N+1];
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < N;i++){
            hash.put(friends[i], i);
        }
        StringTokenizer st = null;
        for(int i = 0, end = gifts.length; i < end; i++){
            st = new StringTokenizer(gifts[i]);
            int from = hash.get(st.nextToken());
            int to = hash.get(st.nextToken());
            map[from][to]++;
        }
        int temp = 0;
        for(int i = 0; i < N;i++){
            temp = 0;
            for(int j = 0 ; j < N;j++){
                temp += map[i][j];
            }
            map[i][N] = temp;
        }
        
        for(int i = 0 ; i< N;i++){
            temp = 0;
            for(int j = 0; j < N;j++){
                temp += map[j][i];
            }
            map[N][i] = temp;
        }
        int[] points = new int[N];
        for(int i = 0 ; i < N;i++){
            points[i] = map[i][N] - map[N][i];
        }
        
        for(int i = 0 ; i < N;i++){
            temp = 0;
            for(int j = 0 ; j < N;j++){
                if(i==j) continue;
                if(map[i][j] > map[j][i]){
                    temp++;
                }
                else if(map[i][j] == map[j][i] || (map[i][j] == 0 && map[j][i] == 0)){
                    if(points[i] > points[j]) temp++;
                }
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
}