package leetcode.Longest_Palindromic_Substring;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ccc"));
    }
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] answerIdx = new int[2];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                answerIdx = new int[]{i, i + 1};
            }
        }

        for (int length = 3; length < s.length(); length++){
            int pi = 0;
            int pf = length - 1;
            for (; pf < s.length(); pi++, pf++) {
                if (dp[pi + 1][pf - 1] && s.charAt(pi) == s.charAt(pf)) {
                    dp[pi][pf] = true;
                    answerIdx = new int[]{pi, pf};
                }
            }
        }

        return s.substring(answerIdx[0], answerIdx[1] + 1);
    }
}
