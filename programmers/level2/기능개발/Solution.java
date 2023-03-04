package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new int[]{95, 90, 99, 99, 80}, new int[]{1,1,1,1,1});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(calRemain(progresses[i], speeds[i]));
        }
        int max = queue.poll();
        int size = queue.size();
        int count = 1;
        for (int i = 0; i < size; i++) {
            int poll = queue.poll();
            if (max >= poll) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                max = poll;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public int calRemain(int progress, int speed) {
        int remain = 100 - progress;
        int day = remain / speed;
        if (remain % speed != 0) {
            day++;
        }
        return day;
    }
}
