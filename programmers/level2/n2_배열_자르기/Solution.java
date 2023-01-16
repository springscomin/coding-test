package programmers.level2.n2_배열_자르기;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(3, 2, 5);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = Math.max(i, j) + 1;
            }
        }

        int idx = 0;
        for (long i = left; i <= right; i++){
            answer[idx++] = map[(int)(i / n)][(int)(i % n)];
        }
        return answer;
    }
}
