package programmers.level2.전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        List<Integer> nums = new ArrayList<>();
        for (String phone : phone_book) {
            set.add(phone);
            int length = phone.length();
            if (!temp.contains(length)) {
                temp.add(length);
                nums.add(length);
            }
        }

        for (String phone : phone_book) {
            for (int n : nums) {
                if (n >= phone.length()) continue;
                String p = phone.substring(0, n);
                if (set.contains(p)) return false;
            }
        }

        return true;
    }
}