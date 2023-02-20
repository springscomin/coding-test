package programmers.level2.쿼드압축_후_개수_세기;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}});
        System.out.println(solution1[0]);
        System.out.println(solution1[1]);
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = 0;
        while (arr.length != 1) {
            int[][] encode = new int[arr.length / 2][arr.length / 2];
            for (int row = 0; row < arr.length / 2; row++) {
                for (int col = 0; col < arr.length / 2; col++) {
                    int[] t = judge(arr, 2 * row, 2 * col);
                    int n0 = t[0];
                    int n1 = t[1];
                    if (n0 == 4) encode[row][col] = 0;
                    else if (n1 == 4) encode[row][col] = 1;
                    else {
                        answer[0] += n0;
                        answer[1] += n1;
                        encode[row][col] = -1;
                    }
                }
            }
            arr = encode;
        }
        if (arr[0][0] == 1) answer[1] += 1;
        else if (arr[0][0] == 0) answer[0] += 1;
        return answer;
    }

    static int[] diffR = {0, 0, 1, 1};
    static int[] diffC = {0, 1, 0, 1};

    public int[] judge(int[][] arr, int row, int col) {
        int[] a = new int[2];
        for (int i = 0; i < 4; i++) {
            int val = arr[row + diffR[i]][col + diffC[i]];
            if (val == 0) a[0] += 1;
            else if (val == 1) a[1] += 1;
        }
        return a;
    }
}
