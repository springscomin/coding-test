package programmers.level2.점프와_순간이동;

public class Solution {
    public int solution(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++){
            if (i % 2 == 0) memo[i] = memo[i / 2];
            else memo[i] = memo[i - 1] + 1;
        }
        return memo[n];
    }
}
