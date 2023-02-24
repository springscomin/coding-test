package programmers.level2.큰_수_만들기;

import java.util.Stack;

class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution("12354", 4));
    }

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (true) {
                if (!stack.isEmpty()){
                    if (stack.peek() < c) {
                        if (k-- > 0) {
                            stack.pop();
                            continue;
                        }
                    }
                }
                break;
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
