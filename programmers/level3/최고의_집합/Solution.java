package programmers.level3.최고의_집합;

public class Solution {
    public int[] solution(int n, int s) {
        if (s / n == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int k = s % n;
        for (int i = 0; i < n ; i++) {
            if (i >= n - k) {
                answer[i] = s / n + 1;
            } else {
                answer[i] = s / n;
            }
        }
        return answer;
    }
}
