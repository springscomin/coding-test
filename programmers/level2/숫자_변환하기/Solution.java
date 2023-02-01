package programmers.level2.숫자_변환하기;

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean[] check;

    public int solution(int x, int y, int n) {
        check = new boolean[y + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                if (val == y) return answer;
                else if (val > y || check[val]) continue;
                check[val] = true;
                queue.add(val + n);
                queue.add(val * 2);
                queue.add(val * 3);
            }
            answer++;
        }
        return -1;
    }
}
