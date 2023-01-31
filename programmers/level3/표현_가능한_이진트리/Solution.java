package programmers.level3.표현_가능한_이진트리;

import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            if (check(binary)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    public boolean check(String binary) {
        int len = binary.length();
        int size = 1;
        int l = 1;
        while (size < len) {
            l *= 2;
            size += l;
        }
        binary = "0".repeat(size - len) + binary;
        Queue<String> queue = new LinkedList<>();
        queue.add(binary);
        while (!queue.isEmpty()) {
            String b = queue.poll();
            int middle = b.length() / 2;
            if (b.length() == 1) continue;
            if (b.charAt(middle) == '0') {
                b = b.replace("0", "");
                if (b.equals("")) continue;
                return false;
            }
            queue.add(b.substring(0, middle));
            queue.add(b.substring(middle + 1));
        }
        return true;
    }
}
