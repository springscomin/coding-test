package programmers.level3.정수_삼각형;

public class Solution {
    public int solution(int[][] triangle) {
        for (int row = triangle.length - 1; row > 0; row--) {
            for (int col = 0; col < row; col++) {
                if (triangle[row][col] > triangle[row][col + 1]) {
                    triangle[row - 1][col] += triangle[row][col];
                } else {
                    triangle[row - 1][col] += triangle[row][col + 1];
                }
            }
        }
        return triangle[0][0];
    }
}
