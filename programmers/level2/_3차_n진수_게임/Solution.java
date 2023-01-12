package programmers.level2._3차_n진수_게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(16,16,2,1));
    }

    public String solution(int n, int t, int m, int p) {
        Queue<Integer> queue = new LinkedList<>();
        int total = t * m;
        int start = 0;
        while (queue.size() <= total) {
            addNumToQueue(start++, n, queue);
        }

        StringBuilder sb = new StringBuilder();
        p--;
        for (int i = 0; i < total; i++) {
            int val = queue.poll();
            if (i % m == p) {
                sb.append(change(val));
            }
        }
        return sb.toString();
    }

    char change(int n) {
        if (n < 10) return (char) ('0' + n);
        if (n == 10) return 'A';
        if (n == 11) return 'B';
        if (n == 12) return 'C';
        if (n == 13) return 'D';
        if (n == 14) return 'E';
        if (n == 15) return 'F';
        throw new RuntimeException();
    }

    void addNumToQueue(int num, int n,  Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        convert(num, n, stack);
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    void convert(int num, int n, Stack<Integer> stack) {
        stack.add(num % n);
        int quotient = num / n;
        if (quotient == 0) return;
        convert(quotient, n, stack);
    }
}
