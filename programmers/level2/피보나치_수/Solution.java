package programmers.level2.피보나치_수;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
            int div = 1234567;
            if (fibo[i] >= div) fibo[i] %= div;
        }
        return fibo[n];
    }
}
