package programmers.level2.프린터;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int p : priorities) {
            queue.add(p);
        }

        int max = Collections.max(queue);
        while (!queue.isEmpty()) {
            int val = queue.poll();
            if (max == val) {
                answer++;
                if (location == 0) {
                    return answer;
                }
                max = Collections.max(queue);
            } else {
                queue.add(val);
            }
            location = (location - 1 + queue.size()) % queue.size();

        }
        return answer;
    }
}
