package programmers.level2.무인도_여행;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    int[] diffR = new int[]{-1, 0, 1, 0};
    int[] diffC = new int[]{0, 1, 0, -1};
    char[][] map;

    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X') {
                    answer.add(getNum(i, j));
                }
            }
        }
        if (answer.isEmpty()) return new int[]{-1};
        return answer.stream().sorted().mapToInt(v -> v).toArray();
    }

    int getNum(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int answer = Character.getNumericValue(map[i][j]);
        map[i][j] = 'X';

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coord = queue.poll();
                int r = coord[0];
                int c = coord[1];

                for (int l = 0; l < 4; l++) {
                    int newR = r + diffR[l];
                    int newC = c + diffC[l];
                    if (newR < 0 || map.length <= newR || newC < 0 || map[0].length <= newC) continue;
                    if (map[newR][newC] != 'X') {
                        answer += Character.getNumericValue(map[newR][newC]);
                        map[newR][newC] = 'X';
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }
        return answer;
    }
}
