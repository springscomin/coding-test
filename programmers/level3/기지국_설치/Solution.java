package programmers.level3.기지국_설치;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[] check = new int[n + 1];
        int startIdx = -1;

        for (int station : stations) {
            check[station] = 1;
            for (int i = 1; i <= w; i++) {
                if (station + i <= n) check[station + i] = 1;

                if (station - i > 0) check[station - i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] != 1) {
                startIdx = i;
                break;
            }
        }

        while (startIdx < n) {
            answer++;
            startIdx += (2 * w + 1);
            for (; startIdx <= n; startIdx++) {
                if (check[startIdx] != 1) break;
            }
        }
        if (startIdx == n) answer++;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(11, new int[]{4, 11}, 1));
    }
}
