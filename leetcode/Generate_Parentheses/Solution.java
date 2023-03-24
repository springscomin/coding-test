package leetcode.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    char[] chs;
    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        chs = new char[2 * n];
        chs[0] = '(';
        dfs(1, 2 * n);
        return answer;
    }

    private void dfs (int i, int n) {
        if (i == n) {
            if (check(chs)) {
                StringBuilder sb = new StringBuilder();
                for (char c : chs) sb.append(c);
                answer.add(sb.toString());
            }
        }
        else {
            chs[i] = '(';
            dfs(i + 1, n);
            chs[i] = ')';
            dfs(i + 1, n);
        }
    }

    private boolean check(char[] chs) {
        int n = 0;
        for (char c : chs) {
            if (c == '(') n++;
            else n--;
            if (n < 0) return false;
        }
        return n == 0;
    }
}
