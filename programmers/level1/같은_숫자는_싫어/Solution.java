package programmers.level1.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int before = -1;
        for (int i : arr) {
            if (before == i) continue;
            before = i;
            list.add(i);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
