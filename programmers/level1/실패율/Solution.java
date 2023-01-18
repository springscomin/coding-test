package programmers.level1.실패율;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(7, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public int[] solution(int max, int[] stages) {
        int[] answer = new int[max];
        Double[][] datas = new Double[max][2];
        Arrays.sort(stages);
        int idx = 0;
        for (int stage = 1; stage <= max; stage++) {
            int stays = 0;
            for (; idx < stages.length; idx++) {
                int s = stages[idx];
                if (s != stage) break;
                stays++;
            }
            double div = stages.length - idx + stays;
            if (div == 0) {
                datas[stage - 1] = new Double[]{(double) stage, (double) 0};
            } else datas[stage - 1] = new Double[]{(double) stage, (double) stays / div};
        }
        Arrays.sort(datas, (a, b) -> b[1].compareTo(a[1]));
        for (int i = 0; i < max; i++) {
            answer[i] = datas[i][0].intValue();
        }
        return answer;
    }
}
