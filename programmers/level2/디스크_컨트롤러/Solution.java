package programmers.level2.디스크_컨트롤러;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[][]{{0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}, {10, 9}});
        System.out.println(solution1);
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Work> queue = new PriorityQueue<>();
        int idx = 0;
        int time = 0;
        int count = 0;
        while (count < jobs.length) {
            while (idx < jobs.length) {
                if (jobs[idx][0] <= time) {
                    queue.add(new Work(jobs[idx]));
                    idx++;
                } else break;
            }
            if (queue.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            Work work = queue.poll();
            time += work.weight;
            count++;
            answer += (time - work.start);
        }
        return answer / jobs.length;
    }
}

class Work implements Comparable<Work> {
    int start;
    int weight;

    Work(int[] jobs) {
        this.start = jobs[0];
        this.weight = jobs[1];
    }

    public int compareTo(Work w) {
        return this.weight - w.weight;
    }
}
