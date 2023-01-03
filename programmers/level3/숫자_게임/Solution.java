package programmers.level3.숫자_게임;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int point = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int finishA = A.length - 1;
        int finishB = B.length - 1;

        for (int i = 0; i < A.length; i++) {
            int a = A[finishA];
            int b = B[finishB];
            if (a < b) {
                finishB--;
                point++;
            } else if (a == b) {
                finishB--;
            }
            finishA--;
        }
        return point;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2,2,2,2,2,2,2,2,2,2,2,2}, new int[]{2,2,2,2,2,2,2,2,2,2,2,2}));
    }
}
