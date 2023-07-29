import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] target = sc.next().toCharArray();
		for (char item: target) {
			if(Character.isUpperCase(item)) {
				sb.append(Character.toLowerCase(item));
			}
			else {
				sb.append(Character.toUpperCase(item));
			}
		}
		System.out.println(sb.toString());
	}
	
}
