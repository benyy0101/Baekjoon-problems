import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n,k;
	static String[] words;
	static HashSet<Character> letters;
	static List<Character> cLetters;
	static Character[] output;
	static List<Character> base = new ArrayList<Character>(Arrays.asList('a','n','t','i','c'));
	static int maxWords = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 단어 수
		k = sc.nextInt(); // 알파벳 수
		
		words = new String[n];
		sc.nextLine();
		for(int i = 0 ; i < n ; i++) {
			words[i] = sc.nextLine();
		}
		letters = new HashSet<Character>();
		
		for(String word: words) {
			for(int i = 0; i < word.length() ; i++) {
				if(word.charAt(i) != 'a' && word.charAt(i) != 'n' && word.charAt(i) != 't' && word.charAt(i) != 'i' && word.charAt(i) != 'c') {
					letters.add(word.charAt(i));
				}
			}
		}
		cLetters = new ArrayList<Character>(10);
		
		int idx = 0;
		for(char i: letters) {
			cLetters.add(i);
		}
		if(k >= 5) {
			output = new Character[k-5];
			//System.out.println(cLetters.contains('h'));
			if(k-5 > cLetters.size()) {
				maxWords = words.length;
			}
			else {
				combination(0,0);
			}
		}
		System.out.println(maxWords);
		//System.out.println(Arrays.toString(cLetters));
		//System.out.println(Arrays.toString(words));
	}
	public static void combination(int depth, int start) {
		if(depth == (k -5)) {
			//System.out.println(Arrays.toString(output));
			List<Character> targetLetters = Arrays.asList(output);
			int flag = 0;
			int count = 0;
			for(String word: words) {
				for(int i = 0 ; i < word.length(); i++) {
					char target = word.charAt(i);	
					if(!(targetLetters.contains(target)||base.contains(target))) {
						//System.out.println(target);
						flag = 1;
						break;
					}
				}
				if(flag != 1) {
					count++;
				}
				maxWords = Math.max(maxWords, count);
				flag = 0;
			}
			return;
		}
			
		for(int i = start; i < cLetters.size(); i++) {
			output[depth] = cLetters.get(i);
			combination(depth + 1, i + 1);
		}
	}
}
