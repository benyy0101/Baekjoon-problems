import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		list = new ArrayList<>();
		
		for(int i = 0 ; i < N+1;i++) {
			parents[i] = i;
		}
		
		if(T == 0) {
			System.out.println(M);
			return;
		} 
		else {
			for(int i = T; i>0 ;i--) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		} 
		ArrayList<Integer>[] partyList = new ArrayList[M];
		
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int NN = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			partyList[i] = new ArrayList<>();
			partyList[i].add(x);
			for(int j = 1 ; j< NN;j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
				partyList[i].add(y);
			}
		}
		int answer = 0;
		for(int i = 0 ; i < M;i++) {
			boolean flag = true;
			for(int num: partyList[i]) {
				if(list.contains(find(parents[num]))) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		System.out.println(answer);
	}
	
	static int find(int i) {
		if(parents[i] == i) return i;
		return find(parents[i]);
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		//list에 있는 애들이 루트가 되게
		if(list.contains(ry)) {
			int temp = rx;
			rx = ry;
			ry = temp;
		}
		parents[ry] = rx;
	}
}