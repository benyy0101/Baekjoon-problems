import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb;
		for(int tc = 0; tc<T;tc++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int i = 0; i < K;i++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")) {
					if(map.get(num) == null) map.put(num, 1);
					else map.put(num, map.get(num)+1);
				}
				else if(command.equals("D") && num == 1) {
					if(map.size() == 0) continue;
					int last = map.lastKey();
					int tmp = map.get(last);
					if(tmp > 1) map.put(last, tmp - 1);
					else map.remove(last);
				}
				else {
					if(map.size() > 0) {
						if(map.size() == 0) continue;
						int first = map.firstKey();
						int tmp = map.get(first);
						if(tmp > 1) map.put(first, tmp - 1);
						else map.remove(first);
					}
				}
			}
			if(map.size() == 0) System.out.println("EMPTY");
			else {
				sb = new StringBuilder();
				sb.append(map.lastKey());
				sb.append(" ");
				sb.append(map.firstKey());
				System.out.println(sb);
			}
		}
	}
}