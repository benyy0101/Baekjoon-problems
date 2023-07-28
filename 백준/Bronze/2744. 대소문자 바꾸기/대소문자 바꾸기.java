import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] target = sc.nextLine().toCharArray();
		
		StringBuilder bs = new StringBuilder();
		
		for(int i = 0; i < target.length; i++) {
			char temp = target[i];
			if(!Character.isUpperCase(temp)) {
				bs.append(Character.toUpperCase(temp));
			}
			else {
				bs.append(Character.toLowerCase(temp));
			}
		}
		
		System.out.println(bs);
	}

}