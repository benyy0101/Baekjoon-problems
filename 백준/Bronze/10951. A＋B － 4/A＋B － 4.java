import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String ss = br.readLine();
		while(ss != null) {
			st = new StringTokenizer(ss);
			System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
			ss = br.readLine();
		}
	}
}