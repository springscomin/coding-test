package programmers.level2.롤케이크_자르기;

import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int top : topping) map2.put(top, map2.getOrDefault(top, 0) + 1);

        for (int top : topping) {
            map1.put(top, map1.getOrDefault(top, 0) + 1);
            int val = map2.getOrDefault(top, 0);
            if (val <= 1) map2.remove(top);
            else map2.put(top, val - 1);
            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}
