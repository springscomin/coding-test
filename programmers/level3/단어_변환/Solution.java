package programmers.level3.단어_변환;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] c = new boolean[words.length];
        queue.add(begin);

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(target)) return answer;
                for (int j = 0; j < words.length; j++) {
                    if (!c[j] && check(s, words[j])) {
                        queue.add(words[j]);
                        c[j] = true;
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    public boolean check(String a, String b) {
        int check = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) check++;
        }
        if (check == 1) return true;
        return false;
    }
}
