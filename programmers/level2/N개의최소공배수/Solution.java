package programmers.level2.N개의최소공배수;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 6, 8, 14}));
    }

    public int solution(int[] arr) {
        if (arr.length == 1) return arr[0];
        Arrays.sort(arr);
        int answer = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int div = gcd(answer, arr[i]);
            answer = answer * arr[i] / div;
        }
        return answer;
    }

    public int gcd(int n1, int n2) {
        int o = n1 % n2;
        if (o == 0) return n2;
        return gcd(n2, o);
    }
}
