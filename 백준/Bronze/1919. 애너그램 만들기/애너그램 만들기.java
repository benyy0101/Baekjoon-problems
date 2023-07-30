import java.util.Scanner;

public class Main {
	public static int[] countAlpha(char[] target) {
		int[] temp = new int[26];
		
		for (char item: target) {
			temp[item - 'a']++;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int [] aCount = countAlpha(a.toCharArray());
		int[] bCount = countAlpha(b.toCharArray());
		
		int result = 0;
		
		for (int i = 0; i < 26; i++) {
			result += Math.abs(aCount[i] - bCount[i]);
		}
		
		System.out.println(result);
	}

}