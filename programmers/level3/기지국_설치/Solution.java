package programmers.level3.기지국_설치;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int range = 2 * w + 1;
        for (int station : stations) {
            int diff = station - w - start;
            if (diff > 0) {
                answer += (diff / range);
                if (diff % range != 0) answer++;
            }

            start = station + w + 1;
        }
        if (start <= n) {
            int diff = n - start + 1;
            if (diff > 0) {
                answer += (diff / range);
                if (diff % range != 0) answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(11, new int[]{4, 11}, 1));
    }
}
