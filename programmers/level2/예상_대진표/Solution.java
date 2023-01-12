package programmers.level2.예상_대진표;

class Solution{
    public int solution(int n, int a, int b) {
        return calRound(a, b, 1);
    }

    public int calRound(int a, int b, int round) {
        int nextA = (a + 1) / 2;
        int nextB = (b + 1) / 2;
        if (nextA == nextB) return round;
        return calRound(nextA, nextB, round + 1);
    }
}
