package programmers.level2.k진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = change(n, k);
        for (String s : num.split("0")){
            if (s.equals("")) continue;
            if (isPrime(Long.valueOf(s))) answer++;
        }
        return answer;
    }
    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        for (long i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public String change(int n, int k) {
        String s = "";
        while (n != 0) {
            s = n % k + s;
            n /= k;
        }
        return s;
    }
}
