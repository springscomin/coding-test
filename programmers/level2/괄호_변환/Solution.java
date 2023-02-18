package programmers.level2.괄호_변환;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()))((()"));
    }


    public String solution(String p) {
        String[] splited = split(p);
        String u = splited[0];
        String v = splited[1];
        String answer = "";
        if (u.length() == 0) return "";
        if (isRight(u)){
            answer += u;
            if (!v.equals("")) answer += solution(v);
        } else {
            answer += "(";
            if (!v.equals("")) answer += solution(v);
            answer += ")";
            answer += convert(u);
        }
        return answer;
    }

    public String[] split(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') balance++;
            else balance--;
            if (balance == 0) return new String[]{s.substring(0, i+1),s.substring(i+1,s.length())};
        }
        return new String[]{"", ""};
    }

    public boolean isRight(String s) {
        int f = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') f++;
            else f--;
            if (f < 0) return false;
        }
        return true;
    }

    public String convert(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() <= 2) return sb.toString();
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == ')') sb.append('(');
            else sb.append(')');
        }
        return sb.toString();
    }
}
