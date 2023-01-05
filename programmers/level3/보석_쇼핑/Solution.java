package programmers.level3.보석_쇼핑;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    private static final HashMap<String, Integer> map = new HashMap<>();
    private static int full = 0;
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        full = set.size();

        int numberOfRange = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < gems.length) {
            plus(gems[end++]);

            while(isFull()) {
                if (hasMoreThanTwo(gems[start])) minus(gems[start++]);
                else break;
            }
            int currentSize = end - start;
            if (isFull() && numberOfRange > currentSize) {
                numberOfRange = currentSize;
                answer = new int[]{start + 1, end};
            }
        }
        return answer;
    }

    public void minus(String key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            if (value == 1) map.remove(key);
            map.put(key, value - 1);
        }
    }

    public boolean isFull() {
        return map.size() == full;
    }


    public void plus(String key) {
        int value = map.getOrDefault(key, 0);
        map.put(key, value + 1);
    }

    public boolean hasMoreThanTwo(String key) {
        int value = map.getOrDefault(key, 0);
        return value >= 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sol = solution.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        for (int s : sol) {
            System.out.println(s + " ");
        }
    }
}
