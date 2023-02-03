package programmers.level2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        String reg = "\\},\\{";
        List<Tup> list = new ArrayList<>();

        s = s.substring(2, s.length() - 2);
        String[] tups = s.split(reg);

        for (String tup : tups) {
            list.add(new Tup(tup));
        }
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).get(answer);
        }
        return answer;
    }
}

class Tup implements Comparable<Tup> {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count;

    Tup(String s) {
        String[] nums = s.split(",");
        this.count = nums.length;

        for (String num : nums) {
            int n = Integer.parseInt(num);
            int v = map.getOrDefault(n, 0);
            this.map.put(n, v + 1);
        }
    }

    int get(int[] list) {
        for (int key : list) {
            if (key == 0) break;
            int v = map.get(key);
            if (v == 1) map.remove(key);
            else map.put(key, v - 1);
        }
        Set<Integer> set = map.keySet();
        return set.stream().findAny().get();
    }

    public int compareTo(Tup t) {
        return this.count - t.count;
    }
}
