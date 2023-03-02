package programmers.level2.가장_큰_수;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3}).equals("321"));
        System.out.println(sol.solution(new int[]{12, 121}).equals("12121"));
        System.out.println(sol.solution(new int[]{340, 3403}).equals("3403403"));
        System.out.println(sol.solution(new int[]{12, 121}).equals("12121"));
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}).equals("0"));
        System.out.println(sol.solution(new int[]{0, 0, 0, 0, 0, 0}).equals("0"));
    }

    public String solution(int[] numbers) {
        StringBuilder ans = new StringBuilder();
        Integer[] nums = Arrays.stream(numbers).boxed()
                .sorted((a, b) -> (String.valueOf(b) + String.valueOf(a)).compareTo(String.valueOf(a) + String.valueOf(b))).toArray(Integer[]::new);
        if (nums[0] == 0) return "0";
        for (int n : nums) ans.append(n);
        return ans.toString();
    }
}

