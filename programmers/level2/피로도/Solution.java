package programmers.level2.피로도;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    boolean[] check;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(0, 0, k, dungeons);
        return max;
    }

    public void dfs(int idx, int count, int k, int[][] dungeons) {
        if (idx == dungeons.length) {
            max = Math.max(count, max);
        } else {
            for (int i = 0; i < dungeons.length; i++) {
                if (check[i]) continue;
                check[i] = true;
                int[] dungeon = dungeons[i];
                if (k >= dungeon[0]) {
                    dfs(idx + 1, count + 1, k - dungeon[1], dungeons);
                } else {
                    dfs(idx + 1, count, k, dungeons);
                }
                check[i] = false;
            }
        }
    }
}
