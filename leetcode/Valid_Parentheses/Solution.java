package leetcode.Valid_Parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ')'){
                if (stack.isEmpty() || stack.pop() != '(') return false;
            }
            else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
            else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
            else stack.add(c);
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
