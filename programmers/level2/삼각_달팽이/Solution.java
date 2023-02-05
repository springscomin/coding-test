package programmers.level2.삼각_달팽이;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(4)));
    }

    public int[] solution(int n) {
        int[] dRow = new int[]{1, 0, -1};
        int[] dCol = new int[]{0, 1, -1};

        int total = (n + 1) * n / 2;
        int[] answer = new int[total];
        int[][] map = new int[n][];
        for (int i = 1; i <= n; i++) map[i - 1] = new int[i];
        int row = -1;
        int col = 0;
        int k = 0;
        for (int i = 1; i <= total; i++) {
            while (true) {
                int r = row + dRow[k];
                int c = col + dCol[k];
                if (r < n && c < n && map[r][c] == 0) {
                    row = r;
                    col = c;
                    break;
                }
                k = (k + 1) % 3;
            }
            map[row][col] = i;
        }

        int idx = 0;
        for (int[] rs : map) {
            for (int cs : rs) {
                answer[idx++] = cs;
            }
        }
        return answer;
    }
}
