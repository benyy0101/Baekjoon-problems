import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			deque.addLast(i);
		};
		while(deque.size() >1) {
			deque.removeFirst();
			int first = deque.getFirst();
			deque.removeFirst();
			deque.addLast(first);
		}
		System.out.println(deque.getFirst());
	}
}
