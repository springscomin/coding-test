package programmers.level2._3차_n진수_게임;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(16, 16, 2, 2));
    }

    static char[] chs = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int temp = 0;
        p--;
        while (true) {
            if (sb.length() == t) break;
            Stack<Integer> nums = convertNum(start++, n);
            int size = nums.size();
            for (int i = 0; i < size  && sb.length() < t; i++) {
                int val = nums.pop();
                if (temp++ % m == p) {
                    sb.append(chs[val]);
                }
            }
        }
        return sb.toString();
    }

    Stack<Integer> convertNum(int num, int n) {
        Stack<Integer> stack = new Stack<>();
        convert(num, n, stack);
        return stack;
    }

    void convert(int num, int n, Stack<Integer> stack) {
        stack.add(num % n);
        int quotient = num / n;
        if (quotient == 0) return;
        convert(quotient, n, stack);
    }
}
