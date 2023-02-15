package programmers.level2.더맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : scoville){
            heap.add(i);
        }
        int answer = 0;
        while(heap.peek() < K){
            if (heap.size() == 1) return -1;
            heap.add(heap.poll() + 2 * heap.poll());
            answer++;
        }
        return answer;
    }
}
