package programmers.level2.JadenCase_문자열_만들기;


class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("4bacwdcdsDEw unFollowed me "));
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (Character.isLowerCase(chars[0])) {
            sb.append(Character.toUpperCase(chars[0]));
        } else sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == ' ') {
                if (Character.isLowerCase(chars[i])) sb.append(Character.toUpperCase(chars[i]));
                else sb.append(chars[i]);
                continue;
            }

            if (Character.isUpperCase(chars[i])) {
                sb.append(Character.toLowerCase(chars[i]));
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
