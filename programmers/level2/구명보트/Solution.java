package programmers.level2.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        boolean[] check = new boolean[people.length];
        int answer = 0;

        for (int i = people.length - 1; i >= 0; i--){
            if (check[i]) continue;
            answer++;
            int left = limit - people[i];
            check[i] = true;
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--){
                if (!check[j] && left >= people[j]) {
                    flag = true;
                    check[j] = true;
                    break;
                }
            }
        }
        return answer;
    }
}
