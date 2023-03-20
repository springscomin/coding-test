package leetcode.Longest_Common_Prefix;

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length - 1];
        return getCommonString(a, b);
    }

    private String getCommonString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) sb.append(a.charAt(i));
            else break;
        }
        return sb.toString();
    }
}
