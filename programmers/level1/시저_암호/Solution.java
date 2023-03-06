package programmers.level1.시저_암호;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == ' ') sb.append(' ');
            else if (c >= 'a') {
                sb.append((char)((c - 'a' + n) % 26 + 'a'));
            } else {
                sb.append((char)((c - 'A' + n) % 26 + 'A'));
            }
        }
        return sb.toString();
    }
}
