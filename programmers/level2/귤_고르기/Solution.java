package programmers.level2.귤_고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        int[] size = new int[map.size()];
        int idx = 0;
        for (int key : map.keySet()){
            size[idx++] = map.get(key);
        }
        Arrays.sort(size);

        for (int i = size.length - 1; i >= 0; i--){
            k -= size[i];
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}
