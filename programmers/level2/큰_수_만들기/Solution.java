package programmers.level2.큰_수_만들기;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        while (k > 0) {
            int temp = -1;
            char max = Character.MIN_VALUE;
            if (number.length() == k) return sb.toString();
            for (int i = 0; i <= k; i++) {
                char ch = number.charAt(i);
                if (ch > max) {
                    max = ch;
                    temp = i;
                }
            }
            sb.append(number.charAt(temp));
            number = number.substring(temp + 1);
            k -= temp;
            if (k == 0) {
                sb.append(number);
            }
        }
        return sb.toString();
    }
}
