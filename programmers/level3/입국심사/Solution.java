package programmers.level3.입국심사;

import java.util.HashMap;

class Solution {
    public long solution(int n, int[] times) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int time : times) {
            map.put(time, 1 + map.getOrDefault(time, 0));
        }
        double ppt = 0;
        for (int key : map.keySet()) {
            ppt += (double) map.get(key) / key;
        }

        long answer = (long) (n / ppt);
        for (; ; answer++) {
            int people = 0;
            for (int key : map.keySet()) {
                people += map.get(key) * (answer / key);
                if (people >= n) return answer;
            }
        }
    }
}
