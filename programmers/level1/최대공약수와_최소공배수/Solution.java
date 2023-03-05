package programmers.level1.최대공약수와_최소공배수;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        int a = 0;
        int b = 0;
        a = cal(Math.max(n,m), Math.min(n,m));
        b = n * m / a;
        return new int[]{a,b};
    }

    public int cal(int n1, int n2) {
        if (n1 % n2 == 0) return n2;
        else return cal(n2, n1 % n2);
    }
}
