package leetcode.Integer_to_Roman;

import java.util.Stack;

class Solution {
    String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman(int num) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; ; i += 2) {
            if(num == 0) break;
            int n = num % 10;
            num /= 10;

            StringBuilder sb = new StringBuilder();
            if (n == 4) {
                sb.append(symbols[i]);
                sb.append(symbols[i + 1]);
            } else if (n == 9) {
                sb.append(symbols[i]);
                sb.append(symbols[i + 2]);
            } else{
                if (n >= 5) {
                    sb.append(symbols[i + 1]);
                    n -= 5;
                }
                sb.append(symbols[i].repeat(n));
            }
            stack.add(sb.toString());
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.toString();
    }
}
