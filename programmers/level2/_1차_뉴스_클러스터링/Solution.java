package programmers.level2._1차_뉴스_클러스터링;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("FRANCE", "FRENCH"));
    }
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = makeMap(str1);
        HashMap<String, Integer> map2 = makeMap(str2);

        int common = 0;
        int total = 0;
        for (String key : map1.keySet()){
            common += Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));;
            map2.put(key, Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0)));
        }
        for (String key : map2.keySet()){
            total += map2.get(key);
        }
        if (total == 0) return 65536;
        return (int)((double)common / total * 65536);
    }

    public HashMap<String, Integer> makeMap(String str) {
        str = str.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++){
            String s = str.substring(i, i+2);
            if (!Character.isAlphabetic(s.charAt(0))) continue;
            if (!Character.isAlphabetic(s.charAt(1))) continue;
            int val = map.getOrDefault(s, 0);
            map.put(s, val+1);
        }
        return map;
    }
}
