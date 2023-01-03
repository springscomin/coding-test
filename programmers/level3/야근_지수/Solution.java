package programmers.level3.야근_지수;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer work : works) queue.add(work);
        for (int i = 0; i < n; i++) {
            Integer nums = queue.peek();
            if (nums > 0) {
                queue.poll();
                queue.add(nums - 1);
            }
        }
        for (Integer k : queue) {
            answer += (long) k * k;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[]{4, 3, 3}));
    }
}
