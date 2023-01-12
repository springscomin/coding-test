package programmers.level2.점프와_순간이동;

public class Solution {
    public int solution(int n) {
        return find(n);
    }

    public int find(int n){
        if (n == 1) return 1;
        else if (n % 2 == 0) return find(n / 2);
        else return find(n - 1) + 1;
    }
}
