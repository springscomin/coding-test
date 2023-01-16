package programmers.level2.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int rightIdx = people.length - 1;
        int leftIdx = 0;

        int answer = 0;
        while (leftIdx <= rightIdx){
            if (people[leftIdx] + people[rightIdx--] <= limit) {
                leftIdx++;
            }
            answer++;
        }
        return answer;
    }
}
