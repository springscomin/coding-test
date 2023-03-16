package programmers.level3.일일공_옮기기;


class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            if (i == 2) {
                System.out.println();
            }
            char[] chars = s[i].toCharArray();
            while (true) {
                int aa = -1;
                int bb = -1;
                for (int j = 0; j < s[i].length() - 2; j++) {
                    if (chars[j] == '1') {
                        if (chars[j + 1] == '1') {
                            if (chars[j + 2] == '1' && aa == -1) {
                                aa = j + 2;
                            } else if (chars[j+2] == '0' && aa != -1){
                                bb = j + 2;
                            }
                        }
                    }
                    if (aa != -1 && bb != -1) {
                        break;
                    }
                }
                if (aa > bb || aa == -1) {
                    answer[i] = String.valueOf(chars);
                    break;
                }
                chars[aa] = '0';
                chars[bb] = '1';
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String s : solution.solution(new String[]{"1110", "100111100", "0111111010","1110011010"})) {
            System.out.println(s + " ");
        }
    }
}
