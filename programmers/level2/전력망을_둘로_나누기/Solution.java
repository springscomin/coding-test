package programmers.level2.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    public int solution(int n, int[][] wires) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int point1 = wire[0] - 1;
            int point2 = wire[1] - 1;
            List<Integer> edgeList1 = edges.get(point1);
            edgeList1.add(point2);
            List<Integer> edgeList2 = edges.get(point2);
            edgeList2.add(point1);
        }

        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int point1 = wire[0] - 1;
            int point2 = wire[1] - 1;
            int temp = Math.abs(n - 2 * calCount(point1, point2, edges));
            if (temp < answer) {
                answer = temp;
            }
        }
        return answer;
    }

    public int calCount(int point, int no, List<List<Integer>> edges) {
        int num = 0;
        boolean[] check = new boolean[edges.size()];
        check[no] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            check[p] = true;
            num++;
            List<Integer> list = edges.get(p);
            for (int e : list) {
                if (!check[e]) queue.add(e);
            }
        }
        return num;
    }
}
