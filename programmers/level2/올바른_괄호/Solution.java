package programmers.level2.올바른_괄호;

class Solution {
    boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') count++;
            else {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
