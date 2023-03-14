package leetcode.Roman_to_Integer;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = getSymbolMap();
        int answer = 0;
        for (int i = 0; i < s.length() - 1; i++){
            int currentNum = map.get(s.charAt(i));
            int nextNum = map.get(s.charAt(i + 1));
            if (currentNum < nextNum) answer -= currentNum;
            else answer += currentNum;
        }
        return answer + map.get(s.charAt(s.length() - 1));
    }

    public HashMap<Character, Integer> getSymbolMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
        return map;
    }
}
