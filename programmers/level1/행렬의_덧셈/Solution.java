package programmers.level1.행렬의_덧셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for (int row = 0; row < arr1.length; row++){
            for (int col = 0; col < arr1[0].length; col++){
                arr1[row][col] += arr2[row][col];
            }
        }
        return arr1;
    }
}
