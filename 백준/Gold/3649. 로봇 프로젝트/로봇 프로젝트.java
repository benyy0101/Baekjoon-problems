import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in; 
		while((in = br.readLine()) !=null) {
			int totalLength = Integer.parseInt(in);
			int numLegos = Integer.parseInt(br.readLine());
			int[] legos = new int[numLegos];
			
			for(int i = 0 ; i < numLegos; i++) {
				legos[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(legos);
			
			int left = 0;
			int right = numLegos - 1;
			int flag = 0;
			
			while(left < right) {
				if(totalLength * 10000000 > (legos[left] + legos[right])) left++;
				else if( totalLength * 10000000 < (legos[left] + legos[right])) right--;
				else {
					flag = 1;
					break;
				}
			}
			
			if(flag == 1) {
				System.out.println("yes " + legos[left]+ " " + legos[right]);
			}
			else {
				System.out.println("danger");
			}
		}
	}
}
