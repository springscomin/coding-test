package programmers.level2.하노이의탑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepEquals(sol.solution(1), new int[][]{{1, 3}}));
        System.out.println(Arrays.deepEquals(sol.solution(2), new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(Arrays.deepEquals(sol.solution(3), new int[][]{{1, 3}, {1, 2}, {3, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 3}}));
        System.out.println(Arrays.deepEquals(sol.solution(4), new int[][]{
                {1, 2}, {1, 3}, {2, 3}, {1, 2}, {3, 1}, {3, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 1}, {3, 1}, {2, 3}, {1, 2}, {1, 3}, {2, 3}
        }));
    }

    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 3, 2, list);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void hanoi(int x, int from, int to, int via, List<int[]> list) {
        if (x == 1) {
            list.add(new int[]{from, to});
        } else {
            hanoi(x - 1, from, via, to, list);
            list.add(new int[]{from, to});
            hanoi(x - 1, via, to, from, list);
        }
    }
}
