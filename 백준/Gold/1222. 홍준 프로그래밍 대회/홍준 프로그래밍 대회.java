import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] schools = new int[2_000_001];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        //학교의 사이즈들을 저장
        for(int i = 0 ; i <N ;i++){
            int idx = Integer.parseInt(st.nextToken());
            schools[idx]++;
        }

        long max = 0;

        for(int i = 1 ; i <=2_000_000;i++ ){
            long cnt = 0;
            for(int j = i ; j <=2_000_000; j += i){
                cnt += schools[j];
            }
            if(cnt > 1){
                max = Math.max(max,cnt * i);
            }
        }

        System.out.println(max);
        
    }
}