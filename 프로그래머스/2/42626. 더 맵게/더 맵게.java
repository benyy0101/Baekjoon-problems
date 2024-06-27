import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int answer = 0;
        for(int i = 0 ; i < scoville.length;i++){
            pq.add(scoville[i]);
        }        
        while(pq.peek() < K && pq.size() > 1){
            
            answer++;
            int one = pq.poll();
            int two = pq.poll();
            pq.add(one + two *2);
        }
        if(!pq.isEmpty() && pq.peek() < K) return -1;
        else return answer;
    }
}