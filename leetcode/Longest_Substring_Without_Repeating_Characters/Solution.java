package leetcode.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcabb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int answer = 0;

        int pi = 0;
        int pf = 1;

        while (pf < s.length()) {
            if (set.contains(s.charAt(pf))) {
                answer = Math.max(answer, pf - pi);
                while (pf - pi + 1 != set.size()) {
                    set.remove(s.charAt(pi++));
                    set.add(s.charAt(pf));
                }
            } else set.add(s.charAt(pf));
            pf++;
        }
        return Math.max(pf - pi, answer);
    }
}
