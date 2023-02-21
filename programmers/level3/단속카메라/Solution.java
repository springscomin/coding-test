package programmers.level3.단속카메라;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            if (indexSet.contains(i)) continue;
            answer++;
            indexSet.add(i);
            int out = routes[i][1];
            for (int j = 0; j < routes.length; j++) {
                if (indexSet.contains(j)) continue;
                int[] tempRoute = routes[j];
                if (tempRoute[0] <= out && out <= tempRoute[1]) indexSet.add(j);
            }
        }
        return answer;
    }
}
