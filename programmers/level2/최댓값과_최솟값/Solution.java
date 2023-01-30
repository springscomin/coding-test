package programmers.level2.최댓값과_최솟값;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String num : nums) {
            numbers.add(Integer.parseInt(num));
        }
        Collections.sort(numbers);
        return numbers.get(0) + " " + numbers.get(numbers.size() - 1);
    }
}
