package programmers.level3.가장_먼_노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] check = new int[n + 1];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int[] e : edge) {
            LinkedList<Integer> values1 = map.getOrDefault(e[0], new LinkedList<>());
            LinkedList<Integer> values2 = map.getOrDefault(e[1], new LinkedList<>());

            values1.add(e[1]);
            values2.add(e[0]);

            map.put(e[0], values1);
            map.put(e[1], values2);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = 1;
        while (true) {
            answer = queue.size();
            for (int i = 0; i < answer; i++) {
                int node = queue.poll();
                LinkedList<Integer> dests = map.getOrDefault(node, new LinkedList<>());
                for (int dest : dests) {
                    if (check[dest] != 1) {
                        queue.add(dest);
                        check[dest] = 1;
                    }
                }
            }

            if (queue.isEmpty()) {
                return answer;
            }
        }
    }
}
