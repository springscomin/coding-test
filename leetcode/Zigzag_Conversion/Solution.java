package leetcode.Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) lists.add(new ArrayList<>());

        int idx = 0;
        boolean plus = true;
        for (char c : s.toCharArray()) {
            lists.get(idx).add(c);

            if (idx == numRows - 1) plus = false;
            else if(idx == 0) plus = true;

            if (plus) idx++;
            else idx--;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (char c : list) sb.append(c);
        }

        return sb.toString();
    }
}
