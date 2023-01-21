package programmers.level2.짝지어제거하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.add(c);
            else if (c == stack.peek()) stack.pop();
            else stack.add(c);
        }
        if (stack.isEmpty()) return 1;
        return 0;
    }
}
