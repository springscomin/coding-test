package programmers.level3.파괴되지_않은_건물;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
    }

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] skills = new int[board.length][board[0].length];

        for (int[] sk : skill) {
            int power;
            if (sk[0] == 1) power = -sk[5];
            else power = sk[5];
            skills[sk[1]][sk[2]] += power;
            if (sk[4] + 1 < board[0].length) skills[sk[1]][sk[4] + 1] -= power;
            if (sk[3] + 1 < board.length) skills[sk[3] + 1][sk[2]] -= power;
            if (sk[4] + 1 < board[0].length && sk[3] + 1 < board.length) skills[sk[3] + 1][sk[4] + 1] += power;
        }

        for (int r = 0; r < board.length; r++) {
            int beforeSum = 0;
            for (int c = 0; c < board[0].length; c++) {
                beforeSum += skills[r][c];
                skills[r][c] = beforeSum;
            }
        }
        for (int c = 0; c < board[0].length; c++ ) {
            int beforeSum = 0;
            for (int r = 0; r < board.length; r++) {
                beforeSum += skills[r][c];
                if (board[r][c] + beforeSum > 0) answer++;
            }
        }
        return answer;
    }
}
