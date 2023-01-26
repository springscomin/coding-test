package programmers.level2.방문길이;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("LULLLLLLU"));
    }
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[21][21];
        int x = 0;
        int y = 0;

        for (char dir : dirs.toCharArray()) {
            int dx = 0;
            int dy = 0;
            if (dir == 'U') dy = 1;
            else if (dir == 'D') dy = -1;
            else if (dir == 'R') dx = 1;
            else dx = -1;
            int fromX = x;
            int fromY = y;
            int toX = x + dx;
            int toY = y + dy;


            if (toX < -5 || toX > 5 || toY < -5 || toY > 5) continue;
            x = toX;
            y = toY;

            int checkX = fromX + x + 10;
            int checkY = 10 - (fromY + y);
            if (map[checkX][checkY] == 0) {
                answer++;
                map[checkX][checkY] = 1;
            }
        }
        return answer;
    }
}
