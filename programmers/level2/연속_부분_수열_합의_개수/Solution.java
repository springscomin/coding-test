package programmers.level2.연속_부분_수열_합의_개수;

import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int len = 1; len < elements.length; len++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += elements[(i + j) % elements.length];
                }
                set.add(sum);
            }
        }
        return set.size() + 1;
    }
}
