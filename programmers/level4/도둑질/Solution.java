package programmers.level4.도둑질;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0, 0, 0, 0, 100, 0, 0, 100, 0, 0, 1, 1}) == 201);
        System.out.println(sol.solution(new int[]{1000, 0, 0, 1000, 0, 0, 1000, 0, 0, 1000}) == 3000);
        System.out.println(sol.solution(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(sol.solution(new int[]{1000, 0, 0, 0, 0, 1000, 0, 0, 0, 0, 0, 1000}) == 2000);
        System.out.println(sol.solution(new int[]{1000, 1, 0, 1, 2, 1000, 0}) == 2001);
        System.out.println(sol.solution(new int[]{11, 0, 2, 5, 100, 100, 85, 1}) == 198);
        System.out.println(sol.solution(new int[]{1, 1, 4, 1, 4}) == 8);
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) == 30);
        System.out.println(sol.solution(new int[]{1, 2, 3}) == 3);
    }

    public int solution(int[] money) {
        int[] memo = new int[money.length];
        memo[0] = money[0];
        memo[1] = Math.max(memo[0], money[1]);
        for (int i = 2; i < money.length - 1; i++) {
            memo[i] = Math.max(memo[i-1], memo[i - 2] + money[i]);
        }
        int temp = memo[money.length - 2];

        memo[1] = money[1];
        memo[2] = Math.max(memo[1], money[2]);
        for (int i = 3; i < money.length; i++) memo[i] = Math.max(memo[i - 1], memo[i - 2] + money[i]);
        return Math.max(temp, memo[money.length - 1]);
    }
// 시간초과
//    public int solution(int[] money) {
//        int[][] memo = new int[money.length][2];
//        memo[0][0] = money[0];
//        for (int i = 0; i < money.length - 1; i++) {
//            int[] before = memo[i];
//            int o = before[1] + money[i + 1];
//            int x = Math.max(before[0], before[1]);
//            memo[i + 1] = new int[]{o, x};
//        }
//        int temp = memo[money.length - 1][1];
//
//        memo[1] = new int[]{money[1], 0};
//        for (int i = 1; i < money.length - 1; i++) {
//            int[] before = memo[i];
//            int o = before[1] + money[i + 1];
//            int x = Math.max(before[0], before[1]);
//            memo[i + 1] = new int[]{o, x};
//        }
//        return Math.max(temp, memo[money.length - 1][0]);
//    }
}
