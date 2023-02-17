package programmers.level2.N_queen;

import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }
    int[] diffR = new int[]{-1, -1, 1, 1};
    int[] diffC = new int[]{-1, 1, -1, 1};

    int answer = 0;
    boolean[][] check;

    public int solution(int n) {
        check = new boolean[n][n];
        dfs(0, n);
        return answer;
    }

    public void dfs(int i, int n) {
        if (i == n) answer++;
        else {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    LinkedList<int[]> list = getRemovedList(i, j, n);
                    dfs(i + 1, n);
                    for (int[] coord : list) check[coord[0]][coord[1]] = false;
                }
            }
        }
    }

    public LinkedList<int[]> getRemovedList(int i, int j, int n) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int k = 0; k < n; k++) {
            updateCheck(k, j, list);
            updateCheck(i, k, list);
        }
        for (int dir = 0; dir < 4; dir++) updateCross(i, j, dir, n, list);

        return list;
    }

    public void updateCheck(int row, int col, LinkedList<int[]> list) {
        if (!check[row][col]) {
            check[row][col] = true;
            list.add(new int[]{row, col});
        }
    }

    public void updateCross(int r, int c, int dir, int n, LinkedList<int[]> list) {
        if (0 <= r && r < n && 0 <= c && c < n) {
            updateCheck(r, c, list);
            updateCross(r + diffR[dir], c + diffC[dir], dir, n, list);
        }
    }
}
