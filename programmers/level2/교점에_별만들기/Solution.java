package programmers.level2.교점에_별만들기;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }

    public String[] solution(int[][] line) {
        List<int[]> intersects = getIntersects(line);
        int[] init = intersects.get(0);
        int[] rangeX = new int[]{init[0], init[0]};
        int[] rangeY = new int[]{init[1], init[1]};
        for (int[] intersect : intersects) {
            int x = intersect[0];
            int y = intersect[1];
            if (x > rangeX[1]) rangeX[1] = x;
            else if (x < rangeX[0]) rangeX[0] = x;
            if (y > rangeY[1]) rangeY[1] = y;
            else if (y < rangeY[0]) rangeY[0] = y;
        }

        boolean[][] checkArray = new boolean[rangeY[1] - rangeY[0] + 1][rangeX[1] - rangeX[0] + 1];
        for (int[] intersect : intersects) {
            checkArray[intersect[1] - rangeY[0]][intersect[0] - rangeX[0]] = true;
        }

        String[] answer = new String[checkArray.length];
        for (int i = checkArray.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < checkArray[0].length; j++) {
                if (checkArray[i][j]) sb.append("*");
                else sb.append(".");
            }
            answer[checkArray.length - 1 - i] = sb.toString();
        }


        return answer;
    }

    public List<int[]> getIntersects(int[][] line) {
        List<int[]> intersects = new ArrayList<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long adbc = (long) line[i][0] * line[j][1] - line[i][1] * line[j][0];
                if (adbc == 0) continue;
                long bfed = (long) line[i][1] * line[j][2] - line[i][2] * line[j][1];
                long ecaf = (long) line[i][2] * line[j][0] - line[i][0] * line[j][2];
                if (bfed % adbc != 0) continue;
                int x = (int) (bfed / adbc);
                if (ecaf % adbc != 0) continue;
                int y = (int) (ecaf / adbc);
                intersects.add(new int[]{x, y});
            }
        }
        return intersects;
    }
}
