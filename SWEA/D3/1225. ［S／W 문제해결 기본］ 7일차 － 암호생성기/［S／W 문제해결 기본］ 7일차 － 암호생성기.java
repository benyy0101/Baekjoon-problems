import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1 ; i <= 10; i++) {
			int p = sc.nextInt();
			Deque<Integer> deque = new ArrayDeque<Integer>();
			
			for(int j = 0; j < 8 ; j ++) {
				deque.addLast(sc.nextInt());
			}
			int offset = 1;
			while(true) {
				int temp = deque.getFirst();
				deque.removeFirst();
				if((temp - offset) <= 0) {
					deque.addLast(0);
					break;
				}
				else {
					deque.addLast(temp - offset);
					offset %= 5;
					offset++;
				}
			}
			Iterator iter = deque.iterator();
			System.out.print("#"+p+" ");
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		}
	}
}
