package programmers.level3.등굣길;

class Solution {
    public static final int PUDDLE = Integer.MAX_VALUE;
    public static final int mod = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int col = puddle[0];
            int row = puddle[1];
            map[row][col] = PUDDLE;
        }
        map[0][1] = 1;

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (map[row][col] != PUDDLE) {
                    map[row][col] = (map[row - 1][col] + map[row][col - 1]) % mod;
                } else {
                    map[row][col] = 0;
                }
            }
        }
        return map[n][m] % mod;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4, 3, new int[][]{{2, 2}}));
    }
}
