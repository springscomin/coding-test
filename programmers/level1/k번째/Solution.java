package programmers.level1.k번째;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++){
            int[] infos = commands[i];
            int size = infos[1] - infos[0] + 1;
            int[] arr = new int[size];
            for (int j = 0; j < size; j++){
                arr[j] = array[infos[0]++ - 1];
            }
            Arrays.sort(arr);
            answer[i] = arr[infos[2] - 1];
        }
        return answer;
    }
}
