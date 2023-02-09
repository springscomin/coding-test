package programmers.level2.메뉴_리뉴얼;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }

    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            char[] chars = order.toCharArray();
            add(chars, map, course);
        }

        List<String> answer = new ArrayList<>();
        for (int c : course) {
            int max = 0;
            List<String> s = new ArrayList<>();
            for (String key : map.keySet()) {
                int val = map.get(key);
                if (key.length() != c || val < 2) continue;
                if (val > max) {
                    s = new ArrayList<>();
                    s.add(key);
                    max = val;
                } else if (val == max) {
                    s.add(key);
                }
            }
            answer.addAll(s);
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void add(char[] chars, HashMap<String, Integer> map, int[] courses) {
        Arrays.sort(chars);
        dfs(0, "", courses, chars, map);
    }

    public void dfs(int idx, String s, int[] courses, char[] chars, HashMap<String, Integer> map) {
        if (idx == chars.length) {
            for (int c : courses) {
                if (c == s.length()) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    break;
                }
            }
        } else {
            dfs(idx + 1, s + chars[idx], courses, chars, map);
            dfs(idx + 1, s, courses, chars, map);
        }
    }
}
