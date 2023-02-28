package programmers.level1.두_개_뽑아서_더하기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int n : numbers) set.add(n);
        set.stream().mapToInt(i -> i).toArray();
        int[] answer = {};
        return answer;
    }
}
