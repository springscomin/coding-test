package programmers.level3.입국심사;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(7, new int[]{10, 10}));
    }

    public long solution(int n, int[] times) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int time : times) map.put(time, 1 + map.getOrDefault(time, 0));

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        long small = list.get(0);
        long big = (long)n * list.get(0);

        while (small < big) {
            long middle = (small + big) / 2;
            long people = 0;
            for (int key : map.keySet()) {
                people += map.get(key) * (middle / key);
            }
            if (people >= n) {
                big = middle;
            } else {
                small = middle + 1;
            }
        }
        return small;
    }
}
